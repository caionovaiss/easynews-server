package com.easynews.easynewsserver.controllers;

import com.easynews.easynewsserver.model.PostRequest;
import com.easynews.easynewsserver.model.db.Post;
import com.easynews.easynewsserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostService postService;

    @PostMapping
    public Post savePost(@RequestBody PostRequest post) {
        return postService.save(post);
    }

    @GetMapping
    public ResponseEntity getAllPosts() {
        var allPosts = postService.getAllPosts();
        return ResponseEntity.ok(allPosts);
    }

}
