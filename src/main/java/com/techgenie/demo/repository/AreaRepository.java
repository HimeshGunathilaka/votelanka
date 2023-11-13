package com.techgenie.demo.repository;

import com.techgenie.demo.dto.model.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
    Area findByareaName(String name);
}