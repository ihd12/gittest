package org.mysite.gittest.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Member {
  private String mid;
  private String mpw;
  private String email;
  private boolean del;
  private boolean social;
  private String auth;
  public boolean isEmpty(){
    if (this.mid.isEmpty()){
      return true;
    }
    return false;
  }
}
