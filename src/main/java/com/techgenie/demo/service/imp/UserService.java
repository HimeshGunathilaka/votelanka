package com.techgenie.demo.service.imp;

import com.techgenie.demo.dto.model.User;
import com.techgenie.demo.repository.UserRepository;
import com.techgenie.demo.service.inf.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    List<com.techgenie.demo.dto.domain.User> users =  new ArrayList<>();

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<com.techgenie.demo.dto.domain.User> getAllDomains(){
        userRepository.findAll().forEach(user -> {
        users.add(com.techgenie.demo.dto.domain.User.builder()
                        .id(user.getUserId())
                        .name(user.getUserName())
//                        .type(user.getUserType())
                .types(user.getTypes())
                        .password(user.getUserPassword())
                        .build());});
    return users;}

    @Override
    public com.techgenie.demo.dto.domain.User findById(int id) {
        return modelMapper.map(userRepository.findById(id), com.techgenie.demo.dto.domain.User.class);
    }

    @Override
    public String userName(int id) {
        return modelMapper.map(userRepository.findById(id), com.techgenie.demo.dto.domain.User.class).getPassword();
    }

    @Override
    public void save(com.techgenie.demo.dto.domain.User user) {
        userRepository.save(modelMapper.map(user,User.class));
    }
}
