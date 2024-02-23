package com.mypractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
//UserController.java
import org.springframework.web.bind.annotation.*;

import com.mypractice.entity.User;
import com.mypractice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
	
 
 private final UserService userService;

 
 @Autowired	
 public UserService setUserService() {
	return userService;
}

public UserController(UserService userService) {
     this.userService = userService;
 }

 @GetMapping
 public List<User> getAllUsers() {
     return userService.getAllUsers();
 }

 @GetMapping("/{id}")
 public User getUserById(@PathVariable Long id) {
     return userService.getUserById(id);
 }

 @PostMapping
 public User createUser(@RequestBody User user) {
     return userService.createUser(user);
 }

 @PutMapping("/{id}")
 public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
     return userService.updateUser(id, updatedUser);
 }

 @DeleteMapping("/{id}")
 public boolean deleteUser(@PathVariable Long id) {
     return userService.deleteUser(id);
 }
}
