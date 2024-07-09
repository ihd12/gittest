package org.mysite.gittest.board.service;

import lombok.RequiredArgsConstructor;
import org.mysite.gittest.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
  public final BoardMapper boardMapper;

  @Override
  public String getTime() {
    String time = boardMapper.getTime();
    return time;
  }
}
