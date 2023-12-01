package com.example.springboot.web;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/*
 * HelloController 테스트 소스
 * @RunWith : 테스트를 진행할 때 Junit에 내장된 실행자 외에 다른 실행자를 실행시킴. 즉, 스프링 부트 테스트와 Junit 사이에 연결자 역할 
 * @WebMvcTest : 스프링 테스트 어노테이션 중 Web에 집중할 수 있는 어노테이션, 선언할 경우 @Controller, @ControllerAdvice등을 사용할 수 있지만, @Service, @Component, @Repository등은 사용할 수 없다. 여기서는 컨트롤러만 사용하기 때문에 선언
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
	
	
	@Autowired //스프링 관리하는 빈을 주입 받음
	private MockMvc mvc; //웹API를 테스트할 때 사용, 스프링 mvc 테스트의 시작점, 이 클래스를 통해 HTTP GET,POST 등 테스트 가능
	
	public void return_hello() throws Exception {
		String hello = "hello";
		
		
		/*
		 * perform() : MockMvc를 통해 전달받은 RequestBuilder을 요청 (/hello 주소로 HTTP GET 요청), 체이닝 지원으로 여러 검정 기능 이어서 선언 가능
		 * andExpect(status().isOk()) : mvc.perform의 결과를 검증, HTTP Header의 Status를 검증
		 * andExpect(content().string(hello)) : mvc.perform의 결과 검증, 응답 본문의 내용을 검증, Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증
		 * 
		 * 정상결과 :  INFO 27360 --- [main] c.e.springboot.web.HelloControllerTest   : Started HelloControllerTest in 1.042 seconds (JVM running for 1.543)
		 */
		mvc.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string(hello));
		
	}
	
	
	@Test
	public void return_helloDto() throws Exception {
		String name ="홍길동";
		int amount = 2000;
		
		/*
		 * param() : 전달 받은 파라미터가 있을 경우 RequestBuilder에다가 param()으로 설정 해줄 수 있다. String만 허용, 숫자/날짜는 문자열로 변경
		 * jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메서드, $를 기준으로 필드명 명시
		 */
		mvc.perform(get("/hello/dto")
				.param("name", name)
				.param("amount", String.valueOf(amount)))	
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name", is(name)))
		.andExpect(jsonPath("$.amount", is(amount)));
		
		
		
	}
	

}
