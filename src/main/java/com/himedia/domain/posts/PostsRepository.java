package com.himedia.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


//Entity 클래스는 기본 Repository없이는 제대로 역할을 할 수 없다. 같은 패키지에 있어야 함
public interface PostsRepository extends JpaRepository<Posts, Long> {   //Posts 클래스로 Database를 접근하게 해줌, 보통 MyBatis에서 DAO라고 불림, JPA에서는 Repository라고 부르며 인터페이스로 생성
                                                                        // 단순히 JpaRepository<T,PK 타입>를 상속하면 기본적인 CURD 메서드가 자동으로 생성
                                                                        // @Repository를 추가할 필요도 없습니다. 주의할 점은 Entity 클래스와 기본 Entity Repository는 함께 위치
                                                                        // Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수가 없다.
    @Query("SELECT p From Posts p ORDER BY p.id DESC")   //SpringDataJPA에서 제공하지 않는 메소드는 쿼리로 작성해도 됨
    List<Posts> findAllDesc();
}