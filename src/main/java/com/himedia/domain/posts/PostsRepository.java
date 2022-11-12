package com.himedia.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


//Entity 클래스는 기본 Repository없이는 제대로 역할을 할 수 없다. 같은 패키지에 있어야 함
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
