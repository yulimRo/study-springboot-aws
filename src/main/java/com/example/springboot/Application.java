package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplicaton 어노테이션으로 인해 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정하며, 해당 위치부터 설정을 읽어가기 때문에 
 * 이 클래스는 최 상단에 위치해야한다.
 */
@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
				//내장 Was 실행 및 ApplicationContext 생성. - 내장 was를 사용하면 언제어디서나 같은 환경에서 스프링 부트를 배포할 수 있어 권장되는 부분이다.
				SpringApplication.run(Application.class); 
	}

}
