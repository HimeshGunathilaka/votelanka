package com.techgenie.demo.service.imp;

import com.techgenie.demo.dto.model.User;
import com.techgenie.demo.repository.UserRepository;
import com.techgenie.demo.service.inf.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    List<com.techgenie.demo.dto.domain.User> users =  new ArrayList<>();

    @Transactional
    @Override
    public List<com.techgenie.demo.dto.domain.User> findAllUsers() {

        //return propertyList.stream().map(p -> modelMapper.map(p, PropertyExtended.class)).collect(Collectors.toList());
        userRepository.findAll().forEach(user -> {
        users.add(com.techgenie.demo.dto.domain.User.builder()
                .id(user.getUserId())
                .name(user.getUserName())
                .types(user.getTypes().getType())
                .area(user.getVoterArea().getAreaName())
                .password(user.getUserPassword())
                .build());
        });
    return users;}

    @Override
    public void save(com.techgenie.demo.dto.domain.User user) {
        userRepository.save(modelMapper.map(user,User.class));
    }

    @Transactional
    @Override
    public com.techgenie.demo.dto.domain.User findUserById(int id) {
//        return modelMapper.map(userRepository.findById(id).map(user -> User.builder()
//                .userId(user.getUserId())
//                .userName(user.getUserName())
//                .userPassword(user.getUserPassword())
//                .types(user.getTypes())
//                .build()),com.techgenie.demo.dto.domain.User.class);
        return null;
    }

}
