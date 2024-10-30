package com.springboot.blogPost.service.serviceImpl;


import com.springboot.blogPost.dto.PostDTO;
import com.springboot.blogPost.dto.ResponseModelDTO;
import com.springboot.blogPost.model.Post;
import com.springboot.blogPost.repository.PostRepo;
import com.springboot.blogPost.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Slf4j
public class ServiceImpl implements PostService {

    private final PostRepo postRepo;

    private final ModelMapper mapper;

    public ServiceImpl(PostRepo postRepo, ModelMapper mapper) {
        this.postRepo = postRepo;
        this.mapper = mapper;
    }

    @Override
    public ResponseModelDTO createPost(PostDTO postDTO) {
//        System.out.println("postDTO = " + postDTO);
//        log.info("postDTO: {}", postDTO);
        ResponseModelDTO responseModelDTO = new ResponseModelDTO();
        Post post = maptoEntity(postDTO);
        try{
            Post Post1 = postRepo.save(post);
            responseModelDTO.setResponseCode(1);
            responseModelDTO.setResponseMessage("SuccessFull");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return responseModelDTO;

    }

    @Override
    public List<PostDTO> getAllPosts() {
        List<Post> posts = postRepo.findAll();
        return posts.stream().map(post -> maptoDTO(post)).toList();
    }



    private PostDTO maptoDTO(Post post) {
        PostDTO postDTO = mapper.map(post, PostDTO.class);
        return postDTO;
    }

    private Post maptoEntity(PostDTO postDTO) {
        Post post = mapper.map(postDTO, Post.class);
        return post;
    }
}
