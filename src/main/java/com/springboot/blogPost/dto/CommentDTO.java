package com.springboot.blogPost.dto;



import com.springboot.blogPost.model.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

    private long comment_id;
    private String name;
    private String email;
    private String body;
    private Post post;
}