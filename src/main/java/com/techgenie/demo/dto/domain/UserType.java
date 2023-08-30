package com.techgenie.demo.dto.domain;

import com.techgenie.demo.dto.model.User;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class UserType {
    private int id;
    private String type;
    private List<User> users;
}
