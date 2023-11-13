package com.techgenie.demo.dto.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Data
public class ImageData {
    private long id;
    private String name;
    private String type;
    private byte[] data;
}
