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
        try {
            String uploadImage = imageService.save(file);
            return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/database/{filename}")
    public ResponseEntity<?> downloadImage(@PathVariable String filename) throws IOException {
        try {
            byte[] imageData = imageService.findImage(filename);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFileSystem(@RequestParam("image") MultipartFile file) throws IOException {
        try {
            String uploadImage = fileService.save(file);
            return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fileSystem/{filename}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String filename) throws IOException {
        try {
            byte[] imageData = fileService.findFile(filename);
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
        } catch (Exception e) {
            return null;
        }

    }
}
