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

    @OneToOne
    @JoinColumn(name = "image_id")
    private ImageData candidateImage;

    //    @OneToMany
    @ManyToOne
    @JoinColumn(name = "party_id")
    private Party party;

    //    @OneToMany
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area candidateArea;
}
