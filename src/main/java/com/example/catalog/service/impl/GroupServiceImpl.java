package com.example.catalog.service.impl;

import com.example.catalog.domain.Group;
import com.example.catalog.repository.GroupRepository;
import com.example.catalog.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    @Override
    public Iterable<Group> getAll() {

        return groupRepository.findAll();

    }

    @Override
    public void add(Group group) {

        groupRepository.save(group);

    }

    @Override
    public void delete(Group group) {
        groupRepository.delete(group);
    }

    public Optional<Group> findById(Long id){

        return groupRepository.findById(id);
    }

    @Override
    public void save(Group group)
    {
        groupRepository.save(group);
    }
}
