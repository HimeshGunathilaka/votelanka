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
    }
}
