package com.example.springboot.web;


import com.example.springboot.domain.posts.PostsService;
import com.example.springboot.web.dto.PostsResponseDto;
import com.example.springboot.web.dto.PostsSaveRequestDto;
import com.example.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

/*
@Autowired 어노테이션 사용 되신 생성자로 주입 받는 방식으로 postsService 의존성 주입 받음
-> RequiredArgsConstructor에서 final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성
 */
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    /**
     * @title 게시물 등록
     * @param requestDto
     * @return
     */
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    /**
     * @title 게시물 수정
     * @param id
     * @param requestDto
     * @return
     */
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    /**
     * @title 게실물 조회
     * @param id
     * @return
     */
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
