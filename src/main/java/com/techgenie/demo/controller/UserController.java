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
        try {
            return userService.findAllUsers();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/user")
    public User findUser(int id) {
        try {
            return userService.findUserById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/push")
    public String save(@RequestBody com.techgenie.demo.dto.domain.User user) {
        try {
            userService.save(user);
            return "Voter saved successfully !";
        } catch (Exception e) {
            return "An error occurred !";
        }
    }
}
