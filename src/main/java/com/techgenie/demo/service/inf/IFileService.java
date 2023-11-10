package com.techgenie.demo.service.inf;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileService {
    String save(MultipartFile file) throws IOException;

    byte[] findFile(String filename) throws IOException;
}
