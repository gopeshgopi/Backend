package com.restaruant.app.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "coupons")
public class Coupons {

    @Id
    private String couponCode;

    private String description;

    private int max_value;


}
