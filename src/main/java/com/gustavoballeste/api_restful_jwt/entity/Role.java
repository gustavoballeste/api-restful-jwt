package com.gustavoballeste.api_restful_jwt.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    String name;

    public Role(String name) {
        this.name = name;
    }
}
