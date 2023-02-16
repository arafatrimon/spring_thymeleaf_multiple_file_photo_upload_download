package com.example.spring_web_thymeleaf_file_management.service;

import com.example.spring_web_thymeleaf_file_management.model.User;
import com.example.spring_web_thymeleaf_file_management.model.UserFiles;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User save(User user);

    User findById(Long userId);

    List<UserFiles> findFilesByUserId(Long userId);

    User update(User user);

    void deleteFilesByUserId(Long userId);

    void deleteUser(Long userId);
}
