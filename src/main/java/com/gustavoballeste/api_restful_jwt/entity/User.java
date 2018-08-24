package com.gustavoballeste.api_restful_jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_user")
@ToString
@AllArgsConstructor
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id") })
    private List<Role> roles;

}
