package com.techgenie.demo.dto.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CANDIDATE")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long candidateId;

    @Column(name = "Name")
    private String candidateName;

    @Column(name = "PhoneNo")
    private String candidateMobile;

    @Column(name = "VoteNo")
    private String candidateVoteNo;

    @Column(name = "Image", columnDefinition = "TEXT")
    private String candidateImage;

    //    @OneToMany
    @OneToOne
    @JoinColumn(name = "party_id")
    private Party party;

    //    @OneToMany
    @OneToOne
    @JoinColumn(name = "area_id")
    private Area candidateArea;
}
