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
@Table(name = "FILE_DATA")
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long fileId;

    @Column(name = "FileName")
    private String fileName;
    @Column(name = "FileType")
    private String fileType;
    @Column(name = "FilePath")
    private String filePath;
}
