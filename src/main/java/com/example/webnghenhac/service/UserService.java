package com.example.webnghenhac.service;

import com.example.webnghenhac.dto.request.UserCreationRequest;
import com.example.webnghenhac.dto.request.UserUpdateRequest;
import com.example.webnghenhac.entity.User;
import com.example.webnghenhac.exeception.AppException;
import com.example.webnghenhac.exeception.ErrorCode;
import com.example.webnghenhac.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository  userRepository;


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        return  userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public User createUser(UserCreationRequest request) {
        User user = new User();
        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USERNAME_EXISTED);
        user.setUsername(request.getUsername());

        user.setEmail(request.getEmail());
        user.setRole(request.getRole());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user);
    }

    public User updateUser(String id,UserUpdateRequest request) {
        User user = findById(id);
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());

        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        if(!userRepository.existsById(id))
            throw new RuntimeException("id does not exist");
        userRepository.deleteById(id);
    }


}
