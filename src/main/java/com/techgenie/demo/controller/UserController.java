package com.techgenie.demo.controller;

import com.techgenie.demo.dto.domain.User;
import com.techgenie.demo.repository.UserRepository;
import com.techgenie.demo.service.inf.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/*")
    public List<com.techgenie.demo.dto.domain.User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/user")
    public User findUser(int id) {
        return userService.findUserById(id);
    }

    @PostMapping("/push")
    public void save(@RequestBody com.techgenie.demo.dto.domain.User user) {
        userService.save(user);
    }
}
