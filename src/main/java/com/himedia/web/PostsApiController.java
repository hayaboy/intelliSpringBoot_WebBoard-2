package com.himedia.web;


import com.himedia.service.PostsService;
import com.himedia.web.dto.PostsSaveRequestDto;
import com.himedia.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        return null;
    }
}
