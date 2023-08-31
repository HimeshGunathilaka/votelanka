package com.techgenie.demo.dto.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class Candidate {
    private long id;
    private String name;
    private String party;
    private String no;
}
