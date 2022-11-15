package com.himedia.domain.posts;

import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest  //별다른 설정없이 H2 데이터베이스를 자동으로 실행
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After(value = "")  // Junit에서 단위 테스트에서 끝날 때마다 수행되는 메소드 지정
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test  // 실행할 경우 H2 자동 실행
    public void BoardSaveLoad(){
        String title="테스트 게시글";
        String content="테스트 본문";

        //save() 테이블 posts에 insert/update 쿼리 실행, id 값이 있다면 update, 없다면 insert 쿼리 실행
        postsRepository.save(Posts.builder().title(title).content(content).author("hayaboy@naver.com").build());

        // 데이블 posts에 있는 모든 데이터를 조회해오는 메소드
        List<Posts> postsList=postsRepository.findAll();

        Posts posts=postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }



    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2022, 11, 15, 11, 24, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();
        //then
        Posts posts = postsList.get(0);
        System.out.println(">>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }




}
