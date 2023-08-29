package com.techgenie.demo.dto.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    private long id;
    private String name;
    private long type;
    private String password;
}
