package com.techgenie.demo.service.inf;

import com.techgenie.demo.dto.domain.User;

import java.util.List;

public interface IUserService {
    List<com.techgenie.demo.dto.domain.User> findAllUsers();

    String save(com.techgenie.demo.dto.domain.User user);

    User findUserById(int id);

    User findByUserName(String name);
}
