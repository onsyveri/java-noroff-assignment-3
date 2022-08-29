package com.example.assignment3.models;

import javax.persistence.*;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int character_id;
    @Column(length = 50, nullable = false)
    private String full_name;
    @Column(length = 50)
    private String alias;
    @Column(length = 30)
    private String gender;
    @Column(length = 2083)
    private String picture;
}
