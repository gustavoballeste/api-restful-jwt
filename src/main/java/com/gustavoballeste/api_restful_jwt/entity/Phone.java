package com.gustavoballeste.api_restful_jwt.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_phone")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer ddd;

    private Integer number;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
