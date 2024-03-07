package com.study.erum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
public class HomeController {
	
  /*
  RequestMapping({,})
  -> 중괄호 : 두 개 이상의 경로가 들어갈 때
  
  ex01 프로젝트에선 /member/와 /member 가 달랐는데
  여기서는 /index/와 /index가 동일하게 적용될 수 있도록 두 개의 경로를 적기 위해 중괄호를 활용하는 것이다.
  */
  @RequestMapping({"","/"})
  public String home() {
   //log4j의 info 레벨에서 표시(warning 레벨에선 표시되지 않음)
   //참고로 개발 할 땐 info, 개발이 끝날 땐 warning으로 레벨을 바꾼다.
   log.info("Welcome home!");
   return "index";
  }
  	
}
