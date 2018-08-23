package com.gustavoballeste.api_restful_jwt.repository;

import com.gustavoballeste.api_restful_jwt.entity.Role;
import com.gustavoballeste.api_restful_jwt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
