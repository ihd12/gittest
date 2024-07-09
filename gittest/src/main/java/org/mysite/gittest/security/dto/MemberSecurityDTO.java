package org.mysite.gittest.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
//import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@ToString
//public class MemberSecurityDTO extends User implements OAuth2User {
public class MemberSecurityDTO extends User{
  //멤버 변수 설정
  private String mid;
  private String mpw;
  private String email;
  private boolean del;
  private boolean social;
  private String auth;
  //생성자
  public MemberSecurityDTO(String username, String password, String email,
                           boolean del, boolean social,
                           Collection<? extends GrantedAuthority> authorities) {
    // 부모 클래스의 생성자를 부르는 super
    super(username, password, authorities);
    //객체안의 멤버 변수에 각각의 데이터 설정부
    this.mid = username;
    this.mpw = password;
    this.email = email;
    this.del = del;
    this.social = social;
  }

//  @Override
//  public Map<String,Object> getAttributes() {
//    return this.getProps();
//  }
//
//  @Override
//  public String getName() {
//    return this.mid;
//  }
}















