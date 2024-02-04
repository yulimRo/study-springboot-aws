package com.example.springboot.web;

import java.util.concurrent.TimeUnit;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.web.dto.HelloResponseDto;

//@RestController은 JSON을 반환하는 Controller로 만들어 주며, 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 한다.
@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public ResponseEntity hello() {
		return ResponseEntity.ok().cacheControl(CacheControl.maxAge(20, TimeUnit.SECONDS))
		        .body("hello");
	}
	
	/*
	 * @RequestParam : 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
	 */
	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto (@RequestParam("name") String name, @RequestParam("amount") int amount) {
		return new HelloResponseDto(name, amount);
	}
	

}
