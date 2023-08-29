package com.techgenie.demo.dto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
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

    @Column(name = "UserType")
    private long userType;

    @Column(name = "Password")
    private String userPassword;

    @ManyToMany
    @JoinTable(
            name = "USER_TYPE_EXTENDED",
            joinColumns = @JoinColumn(name = "ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_TYPES"))
    private List<UserType> userTypes;
}
