package com.gustavoballeste.api_restful_jwt.repository;

import com.gustavoballeste.api_restful_jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String email);
}
