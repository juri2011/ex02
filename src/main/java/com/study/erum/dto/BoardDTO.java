package com.study.erum.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

/*
  board_table 구조
    id  bigint
    boardWriter varchar(50)
    boardPass varchar(20)
    boardTitle  varchar(50)
    boardContents varchar(500)
    boardCreatedTime  datetime
    boardHits int
    fileAttached  int
*/
public class BoardDTO {
  private Long id;
  private String boardWriter;
  private String boardPass;
  private String boardTitle;
  private String boardContents;
  private Timestamp boardCreatedTime;
  private int boardHits;
}
