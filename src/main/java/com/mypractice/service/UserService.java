package com.mypractice.service;

//UserService.java
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mypractice.entity.User;
@Service
public class UserService {
	
 private List<User> users = new ArrayList<>();
 private Long nextId = 1L;

 public List<User> getAllUsers() {
     return users;
 }

 public User getUserById(Long id) {
     return users.stream()
             .filter(user -> user.getId().equals(id))
             .findFirst()
             .orElse(null);
 }

 public User createUser(User user) {
     user.setId(nextId++);
     users.add(user);
     return user;
 }

 public User updateUser(Long id, User updatedUser) {
     for (int i = 0; i < users.size(); i++) {
         User user = users.get(i);
         if (user.getId().equals(id)) {
             updatedUser.setId(id);
             users.set(i, updatedUser);
             return updatedUser;
         }
     }
     return null;
 }

 public boolean deleteUser(Long id) {
     return users.removeIf(user -> user.getId().equals(id));
 }
}
