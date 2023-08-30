package com.techgenie.demo.dto.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "USER_TYPE")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeId")
    private long typeId;

    @Column(name = "type")
    private String type;

    //    @OneToMany(fetch = FetchType.EAGER, mappedBy = "types", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "types")
    private List<User> users;
}
