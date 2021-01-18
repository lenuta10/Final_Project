package com.example.catalog.service.impl;

import com.example.catalog.domain.User;
import com.example.catalog.dto.UserInsertDto;
import com.example.catalog.dto.UserViewDto;
import com.example.catalog.repository.UserRepository;
import com.example.catalog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Iterable<User> getAll() {

        return userRepository.findAll();

    }

    @Override
    public void add(User user) {

        userRepository.save(user);

    }

    @Override
    public void delete(Long id) {

    }

    public User findById(Long id){
        User user = new User();

        return user;
    }

    public void save(User user)
    {

    }
}
