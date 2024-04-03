package com.restaruant.app.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    private String customer;

    private String address;

    private int total;

    private int status;

    // 0 for preparation 1 for wait for pickup

    private int method;
    // 0 for offline method 1 for online method



}
