package com.study.erum;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.erum.sample.Restaurant;

import lombok.extern.log4j.Log4j;

//ctrl + shift + O 필수
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
  
  @Autowired
  private Restaurant restaurant;
  
  @Test
  public void testExist() {
    
    assertNotNull(restaurant);
    /*
     * sysout 대신에 log.info를 쓰면 좋은 점? 개발 할 때는 level을 info로 설정하면 보여줌
     * 제품을 배포할 때는 level을 warning으로 설정하면 보이지 않음
     * 
     * 단위 테스트는 서버 없이 테스트 할 수 있다 단위 테스트 할 때 서버가 필요하다면?
     * -> 실제 서버를 돌리는 것이 아니고 실제 서버를 따라한 가상서버를 돌린다.(mockito)
     */
    log.info(restaurant);
    log.info("------------------------------------");
    log.info(restaurant.getChef());
    
    
  }
}
