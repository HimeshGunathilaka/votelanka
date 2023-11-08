package com.techgenie.demo.service.inf;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileService {
    String uploadImageToFileSystem(MultipartFile file) throws IOException;

    byte[] downloadImageFromFileSystem(String filename) throws IOException;
}
