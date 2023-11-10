package com.techgenie.demo.service.imp;

import com.techgenie.demo.dto.domain.Candidate;
import com.techgenie.demo.repository.AreaRepository;
import com.techgenie.demo.repository.CandidateRepository;
import com.techgenie.demo.repository.ImageRepository;
import com.techgenie.demo.repository.PartyRepository;
import com.techgenie.demo.service.inf.ICandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CandidateService implements ICandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private AreaService areaService;

    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Transactional
    @Override
    public List<Candidate> findAllCandidates() {
        List<Candidate> list = new ArrayList<>();
        candidateRepository.findAll().forEach(candidate -> {
            list.add(Candidate.builder()
                    .no(candidate.getCandidateVoteNo())
                    .id(candidate.getCandidateId())
                    .area(candidate.getCandidateArea().getAreaName())
                    .name(candidate.getCandidateName())
                    .image(candidate.getCandidateImage().getImageName())
                    .party(candidate.getParty().getPartyName())
                    .mobileNo(candidate.getCandidateMobile())
                    .build());
        });
        return list;
    }

    @Transactional
    @Override
    public String saveCandidate(Candidate candidate) {
        try {
            candidateRepository.save(com.techgenie.demo.dto.model.Candidate.builder()
                    .candidateName(candidate.getName())
                    .candidateMobile(candidate.getMobileNo())
                    .candidateArea(areaRepository.findByareaName(candidate.getArea()))
                    .candidateImage(imageRepository.findByimageName(candidate.getImage()).get())
                    .candidateVoteNo(candidate.getNo())
                    .party(partyRepository.findBypartyName(candidate.getParty()))
                    .build());
            return "Candidate saved successfully !";
        } catch (Exception e) {
            return "Candidate couldn't be saved !";
        }
    }
}
