package com.techgenie.demo.service.inf;

import com.techgenie.demo.dto.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    List<com.techgenie.demo.dto.domain.User> getAllDomains();
    com.techgenie.demo.dto.domain.User findById(int id);
    String userName(int id);

    void save(com.techgenie.demo.dto.domain.User user);
}
