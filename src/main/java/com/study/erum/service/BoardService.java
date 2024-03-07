package com.study.erum.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.study.erum.dto.BoardDTO;
import com.study.erum.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;

  
  public int save(BoardDTO boardDTO) {
    return boardRepository.save(boardDTO);
  }


  public List<BoardDTO> findAll() {
    return boardRepository.findAll();
  }


  public BoardDTO findById(Long id) {
    return boardRepository.findById(id);
  }


  public void updateHits(Long id) {
    boardRepository.updateHits(id);
  }


  public void delete(Long id) {
    boardRepository.delete(id);
    
  }


  public void update(BoardDTO boardDTO) {
    boardRepository.update(boardDTO);
  }


  public List<BoardDTO> pagingList(int page) {
    // 한 페이지에 최대 출력할 게시물 수
    int pageLimit = 3;
    
    /*
      페이지 제일 첫번째 게시물 순서
      page 1 -> 0 (0 * 3)
      page 2 -> 3 (1 * 3)
      page 3 -> 6 (2 * 3)
     */
    int pagingStart = (page-1) * pageLimit;
    Map<String, Integer> pagingParams = new HashMap<String, Integer>();
    pagingParams.put("start", pagingStart);
    pagingParams.put("limit", pageLimit);
    
    List<BoardDTO> pagingList = boardRepository.pagingList(pagingParams);
    
    return pagingList;
  }
  
}
