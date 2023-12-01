package com.example.springboot.web.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class HelloResponseDtoTest {

	@Test
	public void test_lombok() {
		String name = "test";
		int amount = 000;
		
		HelloResponseDto dto = new HelloResponseDto(name, amount);
		
		/*
		 * assertThat
		 *   assertj 라는 테스트 검증 라이브러리의 검증 메서드 
		 *   검증하고 싶은 대상을 메서드의 인자로 받는다.
		 *   메서드 체이닝 지원으로 isEqualTo와 같이 메서드를 이어서 사용할 수 있다.
		 * isEqualTo
		 *   assertj의 동등 비교 메서드 
		 *   assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공
		 * 왜 Junit 기본 assertThat을 사용하지 않는가 
		 *   - CoreMatchers와 달리 추가적으로 라이브러리가 필요하지 않다. 자동완성이 좀더 확실하게 지원된다.  
		 */
		assertThat(dto.getName()).isEqualTo(name);
		assertThat(dto.getAmount()).isEqualTo(amount);
	}
	
}
