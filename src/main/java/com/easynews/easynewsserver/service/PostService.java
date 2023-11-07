package com.easynews.easynewsserver.service;

import com.easynews.easynewsserver.model.PostRequest;
import com.easynews.easynewsserver.model.db.Post;
import com.easynews.easynewsserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    PostService(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save( PostRequest postRequest) {
        Post post = convertToPost(postRequest);
        post = postRepository.save(post);
        return (post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    private Post convertToPost(PostRequest postRegRequest) {
        Post post = new Post();
        post.setTitle(postRegRequest.title());
        post.setDescription(postRegRequest.description());
        post.setCreatedAt(new Date().toInstant());
        return post;
    }

//    private PostResponse convertToPostResponse(Post post) {
//        return new PostResponse(post.getId().toString(), post.getTitle(), post.getDescription());
//    }

}
