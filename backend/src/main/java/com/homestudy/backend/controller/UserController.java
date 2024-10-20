package com.homestudy.backend.controller;

import com.homestudy.backend.entity.User;
import com.homestudy.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        User user = userService.createUser(username, password, email);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userPk}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userPk) {
        userService.deleteUser(userPk);
        return ResponseEntity.noContent().build();
    }
}
