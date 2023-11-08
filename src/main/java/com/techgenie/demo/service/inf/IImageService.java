package com.techgenie.demo.service.inf;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageService {

    String uploadImage(MultipartFile file) throws IOException;

    byte[] downloadImage(String filename) throws IOException;
}
