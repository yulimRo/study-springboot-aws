package com.example.springboot.web.dto;

import com.example.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /*
    Entity 클래스를 Request/Response 클래스로 사용해서는 안된다.
    그래서 Entity 클래스와 별개로 Dto 클래스를 하나 더 만듬
     */
    public Posts toEntity(){
        return Posts.builder().title(title).content(content).author(author).build();
    }
}
