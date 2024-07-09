package org.mysite.gittest.board.controller;

import lombok.RequiredArgsConstructor;
import org.mysite.gittest.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
  public final BoardService boardService;

  @GetMapping("/main")
  public String main(Model model) {
    model.addAttribute("testData","실제 데이터");
    return "fragment/nav";
  }
  @PostMapping("/insert")
  public String insert(){
    //insert실행
    return "redirect:/main";
  }

  @RequestMapping("/getTime")
  public String getTime(Model model) {
    String time = boardService.getTime();
    LocalDateTime startDate = LocalDateTime.now();
    LocalDateTime endDate = LocalDateTime.now().plusDays(11);
    ChronoUnit.DAYS.between(endDate, startDate);
    List<List<String>> list = new ArrayList<>();

    List<String> list1 = new ArrayList<>();
    list1.add("B_1234.jpg");
    list1.add("B1235.jpg");
    list1.add("B1236.jpg");
    List<String> list2 = new ArrayList<>();
    list2.add("B_1234.jpg");
    list2.add("B1235.jpg");
    list2.add("B1236.jpg");
    List<String> list3 = new ArrayList<>();
    list3.add("B_1234.jpg");
    list3.add("B1235.jpg");
    list3.add("B1236.jpg");
    list.add(list1);
    list.add(list2);
    list.add(list3);

    model.addAttribute("time",time);
    model.addAttribute("startDate",startDate);
    model.addAttribute("endDate",endDate);
    model.addAttribute("diff",ChronoUnit.DAYS.between(startDate, endDate));
    model.addAttribute("list",list);

    return "time";
  }
}
