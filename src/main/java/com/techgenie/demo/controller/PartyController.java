package com.techgenie.demo.controller;

import com.techgenie.demo.dto.domain.Party;
import com.techgenie.demo.service.inf.IPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/party")
@CrossOrigin
public class PartyController {
    @Autowired
    private IPartyService partyService;

    @GetMapping("/*")
    public List<Party> findAllParties() {
        try {
            return partyService.findAllParties();
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/party_id")
    public Party findPartyById(int id) {
        try {
            return partyService.findPartyById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/push")
    public String saveParty(@RequestBody Party party) {
        try {
            partyService.saveParty(party);
            return "Party saved successfully !";
        } catch (Exception e) {
            return "An error occurred !";
        }
    }
}
