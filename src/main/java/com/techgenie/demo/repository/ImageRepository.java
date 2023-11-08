package com.techgenie.demo.repository;

import com.techgenie.demo.dto.model.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ImageRepository extends JpaRepository<ImageData, Integer> {
    Optional<ImageData> findByimageName(String fileName);
}
