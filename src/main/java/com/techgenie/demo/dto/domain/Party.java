package com.techgenie.demo.dto.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Party {
    private long id;
    private String name;
    private String image;
    private long no;
}
