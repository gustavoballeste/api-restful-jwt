package com.gustavoballeste.api_restful_jwt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_user")
@NoArgsConstructor
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 80, nullable = false)
    private String username;

    @Column(length = 80, nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade= CascadeType.PERSIST)
    private List<Phone> phones;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
