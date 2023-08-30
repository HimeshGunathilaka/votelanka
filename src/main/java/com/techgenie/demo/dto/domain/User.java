package com.techgenie.demo.dto.domain;

import com.techgenie.demo.dto.model.UserType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class User {
    private long id;
    private String name;
    private UserType types;
    private String password;
}
