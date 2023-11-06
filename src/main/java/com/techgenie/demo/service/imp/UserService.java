package com.techgenie.demo.service.imp;

import com.techgenie.demo.dto.model.User;
import com.techgenie.demo.repository.AreaRepository;
import com.techgenie.demo.repository.UserRepository;
import com.techgenie.demo.repository.UserTypeRepository;
import com.techgenie.demo.service.inf.IAreaService;
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
    private UserTypeRepository userTypeRepository;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IAreaService areaService;

    @Transactional
    @Override
    public List<com.techgenie.demo.dto.domain.User> findAllUsers() {
        List<com.techgenie.demo.dto.domain.User> users = new ArrayList<>();
        //return propertyList.stream().map(p -> modelMapper.map(p, PropertyExtended.class)).collect(Collectors.toList());
        userRepository.findAll().forEach(user -> {
        users.add(com.techgenie.demo.dto.domain.User.builder()
                .id(user.getUserId())
                .name(user.getUserName())
                .types(user.getTypes().getType())
                .area(user.getVoterArea().getAreaName())
                .idNumber(user.getUserIdNumber())
                .phone(user.getVoterPhone())
                .build());
        });
    return users;}


    @Override
    public void save(com.techgenie.demo.dto.domain.User user) {
        userRepository.save(User.builder()
                .userIdNumber(user.getIdNumber())
                .userName(user.getName())
                .voterArea(areaRepository.findByareaName(user.getArea()))
                .types(userTypeRepository.findBytype(user.getTypes()))
                .voterPhone(user.getPhone())
                .build());
    }

    @Transactional
    @Override
    public com.techgenie.demo.dto.domain.User findUserById(int id) {
        User user = userRepository.findById(id).get();
        return com.techgenie.demo.dto.domain.User.builder()
                .id(user.getUserId())
                .name(user.getUserName())
                .idNumber(user.getUserIdNumber())
                .types(user.getTypes().getType())
                .area(user.getVoterArea().getAreaName())
                .phone(user.getVoterPhone())
                .build();
    }

    @Override
    public com.techgenie.demo.dto.domain.User findByUserName(String name) {
        User user = userRepository.findByuserName(name);
        return com.techgenie.demo.dto.domain.User.builder()
                .name(user.getUserName())
                .id(user.getUserId())
                .area(user.getVoterArea().getAreaName())
                .idNumber(user.getUserIdNumber())
                .types(user.getTypes().getType())
                .phone(user.getVoterPhone())
                .build();
    }

}
