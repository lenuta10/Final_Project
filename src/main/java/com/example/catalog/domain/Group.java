package com.example.catalog.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "classes")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Year is mandatory")
    private int year;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="group")
    private List<User> users = new ArrayList<>();

}
