package com.techgenie.demo.repository;

import com.techgenie.demo.dto.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByuserName(String name);
}
