package com.techgenie.demo.service.inf;

import com.techgenie.demo.dto.domain.UserType;

import java.util.List;

public interface IUserTypeService {
    List<UserType> getAllTypes();

    List<com.techgenie.demo.dto.model.UserType> getTypes();

    void saveAllTypes(UserType userType);

    void saveTypes(com.techgenie.demo.dto.model.UserType userType);

    com.techgenie.demo.dto.model.UserType findById(int id);
}
