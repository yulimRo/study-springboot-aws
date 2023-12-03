package com.example.springboot.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자 자동 추가
// 실제 DB의 테이블과 매칭될 클래스 (Entity  클래스) - DB작업 대신 Entity 클래스 작업, 클래스의카멜케이스 이름을 언더스코어네이밍으로 테이블이름을 매칭해준다 
// Entity 클래스에는 절대 setter 메서드 사용하지 않는다. (정적팩토리메서드를 만든다.)
//Entity 클래스는 DB와 맞닿는 핵심 클래스로 Entity 클래스 기준으로 테이블, 스키마가 생성됨
@Entity
public class Posts extends BaseTimeEntity {

	@Id //해당 테이블의 PK 필드
	@GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타냄, 이때 GenerationType.IDENTITY 옵션을 추가해야 auto_increment가 됨(springboot 2.0)
	private Long id;
	
	/*
	 * @Column :  테이블 칼럼
	 * 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
	 * 하지만 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
	 */
	@Column(length = 500, nullable = false) 
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable =  false)
	private String content;
	
	private String author;
	
	@Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}

	public void update(String title, String content){
		this.title = title;
		this.content = content;
	}
	
}
