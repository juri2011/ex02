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
import com.study.erum.dto.PageDTO;
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
  
  //게시글 작성
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
    boardService.updateHits(id);
    BoardDTO boardDTO = boardService.findById(id);
    model.addAttribute("board",boardDTO);
    return "detail";
  }
  
  //게시글 삭제
  @GetMapping("/delete")
  public String deleteForm(@RequestParam("id") Long id) {
    boardService.delete(id);
    /*
       "list" 대신에 redirect 쓰는 이유?
       return "name"과 return "redirect:~~"의 차이
       1. return "name" : servlet-context.xml에 지정된 대로 같은 이름을 가진 jsp파일을 호출한다.
                          (url이 변경되지 않으므로 새로고침시 같은 요청을 계속 처리할 수 있다.)
       2. return "redirect:~~~" : 해당 주소로 URL 요청을 다시 한다.(url이 변경된다.)
       
       * 번외 : forward?
               forward는
               
       redirect는 post가 중복되는 것을 막아준다. 이걸 PRG 패턴이라고 한다.
       
     */
    return "redirect:/board/";
  }
  
  //게시글 수정 페이지로 이동
  @GetMapping("/update")
  public String updateForm(@RequestParam("id") Long id, Model model) {
    BoardDTO boardDTO = boardService.findById(id);
    model.addAttribute("board", boardDTO);
    return "update";
  }
  
  //게시글 수정
  @PostMapping("/update")
  public String update(@ModelAttribute BoardDTO boardDTO, Model model) {
    //update 수행
    boardService.update(boardDTO);
    //업데이트 된 최신 정보를 가져옴
    BoardDTO dto = boardService.findById(boardDTO.getId());
    model.addAttribute("board",dto);
    //상세조회페이지로 이동
    return "detail";
    //주의!! 아래 코드를 실행하면 조회수가 총 2번 증가한다.
//    return "redirect:/board?id="+boardDTO.getId();
  }
  
  @GetMapping("/paging")
  //쿼리스트링을 통해 page 값을 받아오는데 쿼리스트링이 없으면 기본 값을 1페이지로 지정한다.
  public String paging(Model model,
                       @RequestParam(value = "page", required = false, defaultValue = "1")
                       int page) {
    List<BoardDTO> pagingList = boardService.pagingList(page);
    PageDTO pageDTO = boardService.pagingParam(page);
    model.addAttribute("boardList",pagingList);
    model.addAttribute("paging", pageDTO);
    return "paging";
  }
  
}
