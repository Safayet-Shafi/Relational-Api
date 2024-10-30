package com.springboot.blogPost.controller;


import com.springboot.blogPost.dto.PostDTO;
import com.springboot.blogPost.dto.ResponseModelDTO;
import com.springboot.blogPost.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping()
    public ResponseModelDTO postInsert(@RequestBody PostDTO postDTO) {
//        System.out.println("postDTO = " + postDTO);
        log.info("Received PostDTO: {}", postDTO);
        return postService.createPost(postDTO);
    }

    @GetMapping()
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }






}