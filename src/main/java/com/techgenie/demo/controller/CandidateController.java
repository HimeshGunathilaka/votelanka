package com.techgenie.demo.controller;

import com.techgenie.demo.dto.domain.Candidate;
import com.techgenie.demo.service.inf.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private ICandidateService candidateService;

    @GetMapping("/*")
    public List<Candidate> findAllCandidates() {
        return candidateService.findAllCandidates();
    }

}
