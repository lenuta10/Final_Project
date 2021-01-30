package com.example.catalog.service.impl;

import com.example.catalog.domain.User;
import com.example.catalog.dto.LoginDto;
import com.example.catalog.repository.UserRepository;
import com.example.catalog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    @Override
    public String login(LoginDto loginDto)
    {
        User user = userRepository.getUserByUsername(loginDto.getUsername());
        if(user == null) {
            throw new RuntimeException("User does not exist.");
        }
        if(!user.getPassword().equals(loginDto.getPassword())){
            throw new RuntimeException("Password mismatch.");
        }
        return "Welcome " + user.getFirstName() + " " + user.getLastName();
    }
}
