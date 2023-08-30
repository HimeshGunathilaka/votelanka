package com.techgenie.demo.controller;

import com.techgenie.demo.dto.model.User;
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
    public List<User> readAll(){return userService.getAll();}

    @GetMapping("/domains")
    public List<com.techgenie.demo.dto.domain.User> readAllDomains(){return userService.getAllDomains();}

    @GetMapping("/test")
    public String getName(int id){return userService.userName(id);}

    @PostMapping("/push")
    public void push(@RequestBody com.techgenie.demo.dto.domain.User user) {
        userService.save(user);
    }
}
