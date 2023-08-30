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
        userTypeRepository.findAll().forEach(userType -> {
            userTypes.add(UserType.builder()
                    .type(userType.getType())
                    .users(userType.getUsers())
                    .build());
        });
        return userTypes;
    }

    @Transactional
    @Override
    public List<com.techgenie.demo.dto.model.UserType> getTypes() {
        return userTypeRepository.findAll();
    }

    @Override
    public void saveAllTypes(UserType userType) {
        userTypeRepository.save(modelMapper.map(userType, com.techgenie.demo.dto.model.UserType.class));
    }

    @Override
    public void saveTypes(com.techgenie.demo.dto.model.UserType userType) {
        userTypeRepository.save(userType);
    }

    @Transactional
    @Override
    public com.techgenie.demo.dto.model.UserType findById(int id) {
        return modelMapper.map(userTypeRepository.findById(id), com.techgenie.demo.dto.model.UserType.class);
    }
}
