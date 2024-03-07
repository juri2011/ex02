package com.study.erum.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

//Component : 클래스 주입
@Component
@Data
public class Restaurant {
  
  //Autowired : 변수를 주입할 때 쓴다
  @Autowired
  private Chef chef;
  
  
}
