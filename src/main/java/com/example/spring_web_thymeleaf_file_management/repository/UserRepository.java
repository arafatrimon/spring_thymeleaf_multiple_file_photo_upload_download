package com.example.spring_web_thymeleaf_file_management.repository;

import com.example.spring_web_thymeleaf_file_management.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
