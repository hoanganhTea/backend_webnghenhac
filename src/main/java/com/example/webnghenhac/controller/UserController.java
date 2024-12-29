package com.example.webnghenhac.controller;

import com.example.webnghenhac.dto.request.UserCreationRequest;
import com.example.webnghenhac.dto.request.UserUpdateRequest;
import com.example.webnghenhac.entity.User;
import com.example.webnghenhac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
        List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") String id) {
        return  userService.findById(id);
    }

    @PostMapping
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUser(request);
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable("id") String id,@RequestBody UserUpdateRequest request){
        return userService.updateUser(id,request);
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return "User has deleted";
    }
}
