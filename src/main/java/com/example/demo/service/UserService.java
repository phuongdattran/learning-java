package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.UserRequest;
import com.example.demo.repository.UserRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        userRepository.save(user);
        return user;
    }

    @Transactional
    public User updateUser(int id, UserRequest userRequest) {
        User userExists = userRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("No such user with id: " + id)
        );

        String username = userRequest.getUsername();
        if(username != null) {
            if (username.length() > 0 && !Objects.equals(username, userExists.getUsername())) {
                userExists.setUsername(username);
            }
        }

        String email = userRequest.getUsername();
        if(email != null) {
            if (email.length() > 0 && !Objects.equals(email, userExists.getEmail())) {
                Optional<User> optionalUser = userRepository.findUserByEmail(email);
                if (optionalUser.isPresent()) {
                    throw new IllegalStateException("Email taken");
                }
                userExists.setEmail(email);
            }
        }

        return userRepository.findById(id).orElse(null);
    }

    public String deleteUser(int id) {
        boolean exists = userRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("No such user with id: " + id);
        }
        userRepository.deleteById(id);
        return "user deleted";
    }

}
