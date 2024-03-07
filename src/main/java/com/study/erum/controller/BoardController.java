package com.study.erum.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.erum.dto.BoardDTO;
import com.study.erum.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
  
  private final BoardService boardService;
  
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
  
  //게시글 리스트 조회
  @GetMapping("/")
  public String findAll(Model model) {
    List<BoardDTO> boardDTOList = boardService.findAll();
    //list.jsp에 model을 실어서 전달
    model.addAttribute("boardList",boardDTOList);
    return "list";
  }
  
  //상세 페이지 조회
  @GetMapping
  //RequestParam은 쿼리스트링으로부터 값을 받아온다
  public String findById(@RequestParam("id") Long id, Model model) {
    BoardDTO boardDTO = BoardService.findById(id);
    model.addAttribute("board",boardDTO);
    return "detail";
  }
  
}
