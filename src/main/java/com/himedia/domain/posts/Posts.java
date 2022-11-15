package com.himedia.domain.posts;

import com.himedia.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor  // 기본 생성자 자동 추가
@Entity  //테이블과 링크될 클래스, Entity 클래스에서는 절대 Setter 메소드를 만들지 않습니다. JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리 대신 이 Entity 클래스의 수정을 통해 작업
public class Posts extends BaseTimeEntity {

    @Id  //해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //auto_increment
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)  //타입을 TEXT로 변경
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함, DB에 삽입(값을 넣어주는(setter) 역할), Entity 클래스에서는 절대 Setter 메서드를 만들지 않는다.
    public Posts(String title, String content, String author){
         this.title=title;
         this.content=content;
         this.author=author;
     }
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
