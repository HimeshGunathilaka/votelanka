package com.techgenie.demo.service.imp;

import com.techgenie.demo.dto.model.ImageData;
import com.techgenie.demo.repository.ImageRepository;
import com.techgenie.demo.service.inf.IImageService;
import com.techgenie.demo.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService implements IImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        ImageData imageData = imageRepository.save(ImageData.builder()
                .imageName(file.getOriginalFilename())
                .imageType(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes()))
                .build());
        if (imageData != null) {
            return "File uploaded successfully" + file.getOriginalFilename();
        }
        return null;
    }

    @Transactional
    @Override
    public byte[] downloadImage(String filename) {
        Optional<ImageData> dbImageData = imageRepository.findByimageName(filename);
        return ImageUtils.decompressImage(dbImageData.get().getImageData());
    }

}
