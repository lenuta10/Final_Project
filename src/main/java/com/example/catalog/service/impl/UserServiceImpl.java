package com.example.catalog.service.impl;

import com.example.catalog.domain.User;
import com.example.catalog.repository.UserRepository;
import com.example.catalog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public void delete(User user) {
        userRepository.delete(user);
    }

    public Optional<User> findById(Long id){

        return userRepository.findById(id);
    }

    @Override
    public void save(User user)
    {
        userRepository.save(user);
    }
}
