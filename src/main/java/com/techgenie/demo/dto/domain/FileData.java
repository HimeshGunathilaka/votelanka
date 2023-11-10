package com.techgenie.demo.dto.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class FileData {
    private long id;
    private String name;
    private String type;
    private String path;
}
