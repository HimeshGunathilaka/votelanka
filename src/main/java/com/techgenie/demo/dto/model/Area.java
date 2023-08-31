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
@Table(name = "AREA")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long areaId;

    @Column(name = "Name")
    private String areaName;

    @Column(name = "No")
    private String areaNo;

    @OneToMany(mappedBy = "candidateArea")
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "voterArea")
    private List<User> voters;
}
