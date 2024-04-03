package com.restaruant.app.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.id.IncrementGenerator;

@Entity
@Data
@Getter
@Setter
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int pid;

    private String title;
    private String description;
    private int lowPrice;
    private int mediumPrice;
    private int highPrice;
    private String img;


}
