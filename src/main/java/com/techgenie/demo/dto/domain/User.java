package com.techgenie.demo.dto.domain;

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
    private String types;
    private String password;
}
