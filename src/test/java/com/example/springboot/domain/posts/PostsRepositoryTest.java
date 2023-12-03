package com.example.springboot.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.tomcat.jni.Local;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest //@SpringBootTest을 사용할 경ㅇ H@ 데이터베이스를 자동으로 실행
public class PostsRepositoryTest {

		@Autowired
		PostsRepository postsRepository;
		
		/*
		 * @After
		 * Junit에서 단위 테스트가 끝날 때마다 수행되는 메서드 지정
		 * 전체 테스트를 수행할 떄 테스트간 데이터 침범을 막기 위해 사용 
		 * 
		 */
		@After
		public void cleanup() {
			postsRepository.deleteAll();
		}
		
		@Test
		public void save_post() {
			String title = "제목";
			String content = "내용";
			
			//repository.save() :  테이블에id 값이 있으면 update, 없으면 insert
			postsRepository.save(Posts.builder().title(title).content(content).author("ylro@mcnc.co.kr").build());
			
			//repository.findAll() : 테이블 posts에 있는 모든 데이터를 조회해오는 메서드
			//when
			List<Posts> postsList = postsRepository.findAll();
			
			//then
			Posts posts = postsList.get(0);
			assertThat(posts.getTitle()).isEqualTo(title);
			assertThat(posts.getContent()).isEqualTo(content);
		}

		@Test
		public void saveBaseTimeEntity() {
			//given
			LocalDateTime now = LocalDateTime.of(2023,12,4,0,4,0,0);

			postsRepository.save(Posts.builder().title("title3").content("content3").author("ylro3").build());

			//when
			List<Posts> postsList = postsRepository.findAll();

			//then
			Posts posts = postsList.get(0);

			System.out.println(">>>>> createDate=" + posts.getCreateDate() +", modifiedDate=" + posts.getModifiedDate());

			assertThat(posts.getCreateDate()).isAfter(now);
			assertThat(posts.getModifiedDate()).isAfter(now);

		}
}
