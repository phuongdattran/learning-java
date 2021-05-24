package com.example.demo.user;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping(path="{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody ObjectNode objectNode) {
        return userService.updateUser(id, objectNode);
    }

    @DeleteMapping(path="{id}")
    public String deleteUser(@PathVariable("id") int id) {
        return userService.deleteUser(id);
    }
}
