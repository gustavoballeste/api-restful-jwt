package com.gustavoballeste.api_restful_jwt.entity;

import javax.persistence.*;

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

    public Phone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
