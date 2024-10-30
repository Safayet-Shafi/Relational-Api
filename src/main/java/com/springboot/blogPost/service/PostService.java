package com.springboot.blogPost.service;



import com.springboot.blogPost.dto.PostDTO;
import com.springboot.blogPost.dto.ResponseModelDTO;
import com.springboot.blogPost.model.Post;

import java.util.List;

public interface PostService {

    ResponseModelDTO createPost(PostDTO postDTO);

    List<PostDTO> getAllPosts();
//
//    PostDTO postGetByUniqueId(long uniqueId);
//
//    PostDTO postGetByTitle(String title);
//
//    PostDTO updateTypeConversion(PostDTO postDTO ,long uniqueId);
}
