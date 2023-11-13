package com.techgenie.demo.controller;

import com.techgenie.demo.dto.domain.Candidate;
import com.techgenie.demo.service.inf.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
@CrossOrigin
public class CandidateController {

    @Autowired
    private ICandidateService candidateService;

    @GetMapping("/*")
    public List<Candidate> findAllCandidates() {
        try {
            return candidateService.findAllCandidates();
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/push")
    public String saveCandidate(@RequestBody Candidate candidate) {
        try {
            return candidateService.saveCandidate(candidate);
        } catch (Exception e) {
            return "An error occurred !";
        }
    }

}
