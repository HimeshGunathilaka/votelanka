package com.techgenie.demo.service.inf;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IImageService {

    String save(MultipartFile file) throws IOException;

    byte[] findImage(String filename) throws IOException;
}
