package com.techgenie.demo.repository;

import com.techgenie.demo.dto.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserTypeRepository extends JpaRepository<UserType, Integer> {
    UserType findBytype(String type);
}
