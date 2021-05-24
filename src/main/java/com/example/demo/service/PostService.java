package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.model.PostRequest;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPost(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> getPostsFromUser(int userId) {
        return postRepository.findByUserId(userId);
    }

    public Post createPost(PostRequest postRequest, int userId) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new IllegalStateException("No such user")
        );

        Post post = new Post(postRequest.getTitle(), postRequest.getMessage());
        post.setUser(user);
        post.setDate(LocalDate.now());
        return postRepository.save(post);
    }

    public String deletePost(int id) {
        boolean exists = postRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("No such post");
        }
        postRepository.deleteById(id);
        return "Post with id " + id + " deleted";
    }

    @Transactional
    public Post updatePost(int id, PostRequest postRequest) {
        Post post = postRepository.findById(id).orElseThrow(
                ()-> new IllegalStateException("No such post")
        );
        String title = postRequest.getTitle();
        if(title != null) {
            if (title.length()>0 && !Objects.equals(title, post.getTitle())) {
                post.setTitle(title);
            }
        }
        String message = postRequest.getMessage();
        if(message != null) {
            if (message.length()>0 && !Objects.equals(message, post.getMessage())) {
                post.setMessage(message);
            }
        }
        return postRepository.findById(id).orElse(null);
    }
}
