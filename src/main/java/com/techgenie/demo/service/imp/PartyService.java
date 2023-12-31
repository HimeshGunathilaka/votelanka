package com.techgenie.demo.service.imp;

import com.techgenie.demo.dto.domain.Party;
import com.techgenie.demo.repository.PartyRepository;
import com.techgenie.demo.service.inf.IPartyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartyService implements IPartyService {
    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    @Override
    public List<Party> findAllParties() {
        try {
            List<Party> list = new ArrayList<>();
            partyRepository.findAll().forEach(party -> {
                list.add(Party.builder()
                        .id(party.getPartyId())
                        .name(party.getPartyName())
                        .no(party.getPartyNumber())
                        .image(party.getPartySymbol())
                        .build());
            });
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String saveParty(Party party) {
        try {
            partyRepository.save(com.techgenie.demo.dto.model.Party.builder()
                    .partyName(party.getName())
                    .partyNumber(party.getNo())
                    .partySymbol(party.getImage())
                    .build());
            return "Party saved successfully !";
        } catch (Exception e) {
            return "Party couldn't be saved !";
        }
    }

    @Override
    public Party findPartyById(int id) {
        com.techgenie.demo.dto.model.Party party = partyRepository.findById(id).get();
        return Party.builder()
                .id(party.getPartyId())
                .name(party.getPartyName())
                .image(party.getPartySymbol())
                .no(party.getPartyNumber())
                .build();
    }
}
