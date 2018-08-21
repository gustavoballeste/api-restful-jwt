package com.gustavoballeste.api_restful_jwt.repository;

import com.gustavoballeste.api_restful_jwt.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
