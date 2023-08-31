package com.techgenie.demo.controller;

import com.techgenie.demo.repository.UserRepository;
import com.techgenie.demo.service.inf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<com.techgenie.demo.dto.domain.User> readAllDomains() {
        return userService.findAllUsers();
    }

    @PostMapping("/push")
    public void push(@RequestBody com.techgenie.demo.dto.domain.User user) {
        userService.save(user);
    }
}
