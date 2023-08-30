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
//
//    @Column(name = "UserType")
//    private long userType;

    @Column(name = "Password")
    private String userPassword;

    //    @JoinTable(
//            name = "USER_TYPE_EXTENDED",
//            joinColumns = @JoinColumn(name = "USER_ID"),
//            inverseJoinColumns = @JoinColumn(name = "USER_TYPE"))
    @OneToOne
    @JoinColumn(name = "user_type")
    private UserType types;
}
