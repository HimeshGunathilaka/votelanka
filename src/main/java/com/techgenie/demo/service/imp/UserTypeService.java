package com.techgenie.demo.service.imp;

import com.techgenie.demo.dto.domain.UserType;
import com.techgenie.demo.repository.UserTypeRepository;
import com.techgenie.demo.service.inf.IUserTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserTypeService implements IUserTypeService {

    private final List<UserType> userTypes = new ArrayList<>();
    @Autowired
    private UserTypeRepository userTypeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public List<UserType> getAllTypes() {
        try {
            userTypeRepository.findAll().forEach(userType -> {
                userTypes.add(UserType.builder()
                        .type(userType.getType())
                        .users(userType.getUsers())
                        .build());
            });
            return userTypes;
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    public List<com.techgenie.demo.dto.model.UserType> getTypes() {
        try {
            return userTypeRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String saveAllTypes(UserType userType) {
        try {
            userTypeRepository.save(modelMapper.map(userType, com.techgenie.demo.dto.model.UserType.class));
            return "User Types saved successfully !";
        } catch (Exception e) {
            return "User Types couldn't be saved !";
        }
    }

    @Override
    public String saveTypes(com.techgenie.demo.dto.model.UserType userType) {
        try {
            userTypeRepository.save(userType);
            return "User Type saved successfully !";
        } catch (Exception e) {
            return "User Type couldn't be saved !";
        }
    }

    @Transactional
    @Override
    public com.techgenie.demo.dto.model.UserType findById(int id) {
        try {
            return modelMapper.map(userTypeRepository.findById(id), com.techgenie.demo.dto.model.UserType.class);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public com.techgenie.demo.dto.model.UserType findByUserType(String type) {
        try {
            return userTypeRepository.findBytype(type);
        } catch (Exception e) {
            return null;
        }
    }
}
