package com.techgenie.demo.dto.domain;

import lombok.*;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class User {
    private long id;
    private String name;
    private long type;
    private String password;
}
