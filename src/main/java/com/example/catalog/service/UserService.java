package com.example.catalog.service;


import com.example.catalog.domain.User;
import com.example.catalog.dto.LoginDto;
import com.example.catalog.dto.UserInsertDto;
import com.example.catalog.dto.UserViewDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Iterable<User> getAll();

    void add(User user);

    void delete(User user);

    void save(User user);

    Optional<User> findById(Long id);

    String login(LoginDto loginDto);

    User findByUsername(String username);



}
