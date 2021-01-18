package com.example.catalog.dto;

import com.example.catalog.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserViewDto {

    private String fistName;
    private String lastName;
    private Role role;
    private String username;

}
