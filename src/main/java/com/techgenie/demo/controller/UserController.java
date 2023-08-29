package com.techgenie.demo.controller;

import com.techgenie.demo.dto.model.User;
import com.techgenie.demo.repository.UserRepository;
import com.techgenie.demo.service.inf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> readAll(){return userService.getAll();}

    @GetMapping("/test")
    public String getName(int id){return userService.userName(id);}
}
