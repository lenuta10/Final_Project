package com.example.catalog.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Table
@Entity
public class UserRole {

    @Id
    @Column(length = 50)
    @Enumerated(value = EnumType.STRING)
    private Role name;

}
