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
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long userId;

    @Column(name = "Name")
    private String userName;

    @Column(name = "IdNumber")
    private String userIdNumber;

    @ManyToOne
    @JoinColumn(name = "user_type")
    private UserType types;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area voterArea;

    @Column(name = "Phone")
    private String voterPhone;
}
