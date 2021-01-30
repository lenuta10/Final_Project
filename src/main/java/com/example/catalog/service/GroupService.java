package com.example.catalog.service;

import com.example.catalog.domain.Group;
import com.example.catalog.dto.LoginDto;

import java.util.Optional;

public interface GroupService {

    Iterable<Group> getAll();

    void add(Group group);

    void delete(Group group);

    void save(Group group);

    Optional<Group> findById(Long id);

}
