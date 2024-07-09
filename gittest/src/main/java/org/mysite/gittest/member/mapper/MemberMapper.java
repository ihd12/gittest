package org.mysite.gittest.member.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.mysite.gittest.member.dto.Member;

@Mapper
public interface MemberMapper {
  String getTime();
  Member getMember(String id);
}
