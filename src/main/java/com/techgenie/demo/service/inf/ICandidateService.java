package com.techgenie.demo.service.inf;

import com.techgenie.demo.dto.domain.Candidate;

import java.util.List;

public interface ICandidateService {
    List<Candidate> findAllCandidates();
}
