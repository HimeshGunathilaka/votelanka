package com.techgenie.demo.service.inf;

import com.techgenie.demo.dto.model.User;

import java.util.List;

public interface IUserService {
    List<User> getAll();
    com.techgenie.demo.dto.domain.User findById(int id);
    String userName(int id);
}
