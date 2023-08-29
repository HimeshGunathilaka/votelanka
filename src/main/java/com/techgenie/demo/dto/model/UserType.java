package com.techgenie.demo.dto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivilegedAction;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER_TYPE")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userTypeId")
    private long userTypeId;

    @Column(name = "userType")
    private String userType;

//    @ManyToMany(mappedBy = "userTypes")
//    private List<User> users;

}
