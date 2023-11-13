package com.techgenie.demo.repository;

import com.techgenie.demo.dto.model.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface FileDataRepository extends JpaRepository<FileData, Integer> {
    Optional<FileData> findByfileName(String filename);
}
