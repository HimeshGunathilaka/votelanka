package com.techgenie.demo.dto.domain;

import com.techgenie.demo.dto.model.UserType;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class User {
    private long id;
    private String name;
    private List<UserType> types;
    //    private long type;
    private String password;
}
