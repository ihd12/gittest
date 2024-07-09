package org.mysite.gittest.board.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
  String getTime();
}
