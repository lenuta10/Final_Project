package com.example.catalog.service;


import com.example.catalog.domain.User;
import com.example.catalog.dto.UserInsertDto;
import com.example.catalog.dto.UserViewDto;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface UserService {


    // CRUD

    // add
    // getAll
    // update
    // remove
    // getById
    // etc...

    // Give me all of the users from the database (NO FILTER).
    Iterable<User> getAll();

    void add(User user);

    void delete(Long id);

}