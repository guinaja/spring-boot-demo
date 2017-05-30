package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by prayoon-pc on 5/25/2017.
 */
@Getter
@Setter
public class City implements Serializable {
    private Long id;

    private String name;

    private String countryCode;

    private String district;

    private String population;
}
