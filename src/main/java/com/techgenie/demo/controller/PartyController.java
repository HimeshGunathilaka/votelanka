package com.techgenie.demo.controller;

import com.techgenie.demo.dto.domain.Party;
import com.techgenie.demo.service.inf.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party")
public class PartyController {
    @Autowired
    private IPartyService partyService;

    @GetMapping("/*")
    public List<Party> findAllParties() {
        return partyService.findAllParties();
    }

    @PostMapping("/push")
    public void saveParty(@RequestBody Party party) {
        partyService.saveParty(party);
    }
}
