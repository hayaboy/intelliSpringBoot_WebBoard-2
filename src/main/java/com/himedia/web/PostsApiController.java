package com.himedia.web;


import com.himedia.service.PostsService;
import com.himedia.web.dto.PostsResponseDto;
import com.himedia.web.dto.PostsSaveRequestDto;
import com.himedia.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }


    @PutMapping("/api/v1/posts/{id}")   // 데이터베이스에 쿼리가 없는 이유는 JPA의 영속성 컨텍스트(엔티티를 영구 저장하는 환경)
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){

        return postsService.findById(id);
    }


    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
