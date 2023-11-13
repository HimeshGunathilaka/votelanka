package com.techgenie.demo.service.inf;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IImageService {

    String save(MultipartFile file) throws IOException;

    byte[] findImage(String filename) throws IOException;

    List<byte[]> findAllImages();
}
