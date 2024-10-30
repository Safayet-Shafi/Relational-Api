package com.springboot.blogPost.dto;


import com.springboot.blogPost.model.Comment;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PostDTO {

    private long id;
    private String title;
    private String description;
    private String content;
    private Set<Comment> comment ;

}