package com.example.catalog.domain;


import lombok.Data;
import org.apache.tomcat.jni.Address;
@Data

public abstract class User {

    private int id;
    private String fistName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String Role;

}
