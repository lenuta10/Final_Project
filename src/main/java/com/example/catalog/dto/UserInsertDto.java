package com.example.catalog.dto;

import com.example.catalog.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInsertDto {

    private String fistName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Role role;
    private String username;
    private String password;


}
