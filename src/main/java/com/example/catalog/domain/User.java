package com.example.catalog.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Firstname is mandatory")
    private String firstName;

    @NotBlank(message = "Lastname is mandatory")
    private String lastName;
    private String phoneNumber;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Role is mandatory")
    private String role;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "Password is mandatory")
    private String password;


    @OneToMany(fetch=FetchType.LAZY, mappedBy = "user")
    private List<CourseRegistration> courseRegistrations;

    @ManyToOne()
    @JoinColumn(name="class_id")
    private Group group;

}
