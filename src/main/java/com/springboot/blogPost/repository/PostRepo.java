package com.springboot.blogPost.repository;


import com.springboot.blogPost.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Long> {

    Post findByTitle(@Param("title") String title);
}
