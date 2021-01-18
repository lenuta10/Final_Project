package com.example.catalog.domain;

import lombok.Data;

import javax.persistence.Entity;

@Data

public class Professor extends User{

    private String title;
    private String department;

}
