package com.techgenie.demo.controller;

import com.techgenie.demo.service.inf.IFileService;
import com.techgenie.demo.service.inf.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    @Autowired
    private IImageService imageService;

    @Autowired
    private IFileService fileService;

    @PostMapping("/database")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = imageService.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/database/{filename}")
    public ResponseEntity<?> downloadImage(@PathVariable String filename) throws IOException {
        byte[] imageData = imageService.downloadImage(filename);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
    }

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = fileService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/fileSystem/{filename}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String filename) throws IOException {
        byte[] imageData = fileService.downloadImageFromFileSystem(filename);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
    }
}
