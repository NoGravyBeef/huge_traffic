package com.homestudy.backend.service;

import com.homestudy.backend.entity.User;
import com.homestudy.backend.repsitory.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Data
public class UserService {
    private final UserRepository userRepository;

    public User createUser(String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        return userRepository.save(user);
    }

    public void deleteUser(Long userPk){
        userRepository.deleteById(userPk);
    }
}
