package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Superhero implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String name;
    private boolean good;

}
