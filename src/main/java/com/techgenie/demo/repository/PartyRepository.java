package com.techgenie.demo.repository;

import com.techgenie.demo.dto.model.Party;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PartyRepository extends JpaRepository<Party, Integer> {
}
