package com.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Mybatis의 Dao(또는 DB Layer), JPA에선 Repository
// JpaRepository<T,ID>를 상속하면 기본적인 CRUD 메서드가 자동으로 생성된다. -> @Repository를 추가할 필요 없음
// Entity 크래스와 기본 Entity Repository는 함께 위치해야한다. 
public interface PostsRepository extends JpaRepository<Posts, Long>{
	
	

}
