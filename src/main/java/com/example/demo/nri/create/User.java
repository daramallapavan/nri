package com.example.demo.nri.create;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    private String name;
    private String email;

    private int age;
    private String city;

    private String gender;

    private String username;





}
