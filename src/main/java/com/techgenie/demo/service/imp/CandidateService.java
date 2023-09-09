package com.techgenie.demo.service.imp;

import com.techgenie.demo.dto.domain.Candidate;
import com.techgenie.demo.repository.CandidateRepository;
import com.techgenie.demo.service.inf.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService implements ICandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> findAllCandidates() {
        List<Candidate> list = new ArrayList<>();
        candidateRepository.findAll().forEach(candidate -> {
            list.add(Candidate.builder()
                    .no(candidate.getCandidateVoteNo())
                    .id(candidate.getCandidateId())
                    .area(candidate.getCandidateArea().getAreaName())
                    .name(candidate.getCandidateName())
                    .image(candidate.getCandidateImage())
                    .party(candidate.getParty().getPartyName())
                    .mobileNo(candidate.getCandidateMobile())
                    .build());
        });
        return list;
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        candidateRepository.save(com.techgenie.demo.dto.model.Candidate.builder()
                .candidateName(candidate.getName())
                .candidateMobile(candidate.getMobileNo())
                .candidateArea(null)
                .candidateImage(candidate.getImage())
                .candidateVoteNo(candidate.getNo())
                .party(null)
                .build());
    }
}
