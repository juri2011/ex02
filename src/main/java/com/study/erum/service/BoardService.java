package com.study.erum.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.study.erum.dto.BoardDTO;
import com.study.erum.dto.PageDTO;
import com.study.erum.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

  private final BoardRepository boardRepository;
  //한 페이지당 출력할 최대 게시물 수
  private final int pageLimit = 3;
  //화면에 출력할 최대 페이징 수
  private final int blockLimit = 3;
  
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


	public PageDTO pagingParam(int page) {
		//전체 글 갯수 조회
		int boardCount = boardRepository.boardCount();
		//전체 페이지 갯수
		/*
			전체게시물갯수 / 한페이지당갯수 했을 때
			나머지가 1이라도 있다면,
			그 1개의 게시물을 위해 페이지를 하나 더 만들어야 하므로
			올림처리를 해야 한다.
			그리고 maxPage가 int 형으로 값을 받으므로
			double인 값을 int로 캐스팅 한다.
		 */
		int maxPage = (int)(Math.ceil((double)boardCount/pageLimit));
		/*
 			startPage 알고리즘 :
 			화면에 표시되는 페이지의 그룹을(예 : [1,2,3][4,5,6]...) 블록이라고 했을 때,
 			1. 현재 페이지의 블록 넘버를 구한다.
 				Math.ceil((double)page/blockLimit))
 			2. 이전 블록의 마지막 페이지를 구하기 위해 우선 이전 블록의 넘버를 구한다.
 			   현재 블록 넘버가 1일 경우 0을 구한다.
 				((int)(Math.ceil((double)page/blockLimit)))-1
 			3. 이전 블록의 마지막 페이지를 구한다.
 			   현재 블록 넘버가 1일 경우 0을 구한다.
 				(((int)(Math.ceil((double)page/blockLimit)))-1)*blockLimit
 			4. 이전 블록의 마지막 페이지에서 1을 더하면, 현재 블록의 첫번째 페이지를 구할 수 있다.
 				(((int)(Math.ceil((double)page/blockLimit)))-1)*blockLimit+1
		*/
		int startPage = (((int)(Math.ceil((double)page/blockLimit)))-1)*blockLimit+1;
		// 현재 시작페이지에서 blockLimit에 1만큼 뺀 값을 더하면 현재 마지막 페이지가 될 숫자를 얻을 수 있다.
		int endPage = startPage+blockLimit-1;
		
		/*
 			endPage가 maxPage와 같을 경우
 			마지막 페이지까지 게시물이 잘 출력되지만,
 			endPage가 maxPage보다 클 경우
 			maxPage까지는 게시물이 출력 되지만
 			남은 페이지들은 게시물이 출력되지 않기 때문에
 			view에 보여줄 필요가 없어진다.
 			그래서 maxPage를 넘어가는 페이지는 표시하지 않게 처리하는 작업이 필요한데
 			endPage를 maxPage에 맞춰버리면 남는 페이지에 대해선 처리를 하지 않으므로
 			필요한 페이지들만 출력할 수 있다.
		*/
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		//페이징 정보를 controller에 넘기기 위해 객체를 생성
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPage(page);
		pageDTO.setMaxPage(maxPage);
		pageDTO.setMaxPage(startPage);
		pageDTO.setMaxPage(endPage);
		return pageDTO;
	}
  
}
