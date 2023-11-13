package com.techgenie.demo.dto.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "IMAGE_DATA")
public class ImageData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long imageId;

    @Column(name = "ImageName")
    private String imageName;

    @Column(name = "ImageType")
    private String imageType;

    @Lob
    @Column(name = "ImageData", length = 1000)
    private byte[] imageData;

    @OneToOne(mappedBy = "candidateImage")
    private Candidate candidate;
}
