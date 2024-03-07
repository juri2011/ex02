package com.study.erum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.erum.dto.BoardDTO;

@Controller
@RequestMapping("/board")
public class BoardController {
  
  //saveForm 화면 출력
  @GetMapping("/save")
  public String saveForm() {
    return "save";
  }
  
  //save 기능 수행
  @PostMapping("/save")
  public String save(@ModelAttribute BoardDTO boardDTO) {
    int saveResult = boardService.save(boardDTO);
    if(saveResult > 0) {
      return "redirect:/board/";
    }else {
      return "save";
    }
  }
  
}
