package org.mysite.gittest.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mysite.gittest.member.dto.Member;
import org.mysite.gittest.member.mapper.MemberMapper;
import org.mysite.gittest.security.dto.MemberSecurityDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
//  private final MemberRepository memberRepository;
  private final MemberMapper memberMapper;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    log.info("loadUserByUsername : "+username);
    //데이터베이스에 username으로 검색한 회원 정보를 취득
    Member member = memberMapper.getMember(username);
    //회원정보가 있는지 확인하는 if문
    if (member.isEmpty()) {
      throw new UsernameNotFoundException(username);
    }
    List<GrantedAuthority> authorities = new ArrayList<>();
    if(member.getAuth().equals("ADMIN")){
      authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    }
    authorities.add(new SimpleGrantedAuthority("ROLE_"+member.getAuth()));

    // Member객체를 MemberSecurityDTO 객체로 변환
    MemberSecurityDTO memberSecurityDTO = new MemberSecurityDTO(
        member.getMid(),
        member.getMpw(),
        member.getEmail(),
        member.isDel(),
        false,
        authorities);
    log.info("memberSecurityDTO");
    log.info(memberSecurityDTO);
    return memberSecurityDTO;
  }
}
