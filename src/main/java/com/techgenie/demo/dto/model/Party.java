package com.techgenie.demo.dto.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PARTY")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long partyId;

    @Column(name = "Name")
    private String partyName;

    @Column(name = "No")
    private long partyNumber;

    @Column(name = "Symbol", columnDefinition = "TEXT")
    private String partySymbol;

    @OneToMany(mappedBy = "party")
    private List<Candidate> candidates;
}
