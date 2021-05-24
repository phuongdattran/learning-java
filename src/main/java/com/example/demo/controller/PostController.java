package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="posts")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping(path="{id}")
    public Post getPost(@PathVariable("id") int id) {
        return postService.getPost(id);
    }

    @GetMapping(path="user/{userId}")
    public List<Post> getPostsFromUser(@PathVariable("userId") int userId) {
        return postService.getPostsFromUser(userId);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        int userId = 1;
        return postService.createPost(post, userId);
    }

    @DeleteMapping(path="{id}")
    public String deletePost(@PathVariable("id") int id) {
        return postService.deletePost(id);
    }

    @PutMapping(path="{id")
    public Post updatePost(@PathVariable("id") int id, ObjectNode objectNode) {
        return postService.updatePost(id, objectNode);
    }
}
