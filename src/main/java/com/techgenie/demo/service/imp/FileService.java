package com.techgenie.demo.service.imp;

import com.techgenie.demo.dto.model.FileData;
import com.techgenie.demo.repository.FileDataRepository;
import com.techgenie.demo.service.inf.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class FileService implements IFileService {

    private final String FOLDER_PATH = "/home/himesh/Pictures/VoteLanka/Images/";
    @Autowired
    private FileDataRepository fileDataRepository;

    @Override
    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();
        FileData fileData = fileDataRepository.save(FileData.builder()
                .fileName(file.getOriginalFilename())
                .fileType(file.getContentType())
                .filePath(filePath)
                .build());
        file.transferTo(new File(filePath));
        if (fileData != null) {
            return "File uploaded successfully" + filePath;
        }
        return null;
    }

    @Override
    public byte[] downloadImageFromFileSystem(String filename) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByfileName(filename);
        String filePath = fileData.get().getFilePath();
        byte[] image = Files.readAllBytes(new File(filePath).toPath());
        return image;
    }
}