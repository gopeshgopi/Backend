package com.restaruant.app.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    private  String email;
    private  String firstName;
    private  String lastName;
    private  String password;
    private  long  mobileNumber;
    private  String  role;
}
