package com.springboot.blogPost.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "posts",uniqueConstraints = {@UniqueConstraint(columnNames={"title"})}
)
public class Post {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private long id;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name="content",nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Comment> comment = new HashSet<>();

    public Set<Comment> getcomments() {
        return comment;
    }

    public void setComment(Set<Comment> comment) {
        this.comment = comment;
        for (Comment a : comment) {
            a.setPost(this);
        }
    }



//    public Set<LSALLOCATENOM> getLsallocatenomSet() {
//        return lsallocatenomSet;
//    }
//
//    public void setLsallocatenomSet(Set<LSALLOCATENOM> lsallocatenomSet) {
//        this.lsallocatenomSet = lsallocatenomSet;
//        for( LSALLOCATENOM a : lsallocatenomSet){
//            a.setLsdrwrallocat(this);
//        }
//    }
}