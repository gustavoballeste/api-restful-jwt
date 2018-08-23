package com.gustavoballeste.api_restful_jwt.api.dto;

public class PhoneDTO {

    private Integer number;
    private Integer ddd;

    public PhoneDTO() {
    }

    public PhoneDTO(Integer number, Integer ddd) {
        this.number = number;
        this.ddd = ddd;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }
}
