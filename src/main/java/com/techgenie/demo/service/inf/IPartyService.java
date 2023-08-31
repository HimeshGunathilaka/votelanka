package com.techgenie.demo.service.inf;

import com.techgenie.demo.dto.domain.Party;

import java.util.List;

public interface IPartyService {
    List<Party> findAllParties();
}
