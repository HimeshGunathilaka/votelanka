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
    public String save(MultipartFile file) throws IOException {
        try {
            ImageData imageData = imageRepository.save(ImageData.builder()
                    .imageName(file.getOriginalFilename())
                    .imageType(file.getContentType())
                    .imageData(ImageUtils.compressImage(file.getBytes()))
                    .build());
            return file.getOriginalFilename();
        } catch (Exception e) {
            return "Image couldn't be saved !";
        }
    }

    @Transactional
    @Override
    public byte[] findImage(String filename) {
        try {
            Optional<ImageData> dbImageData = imageRepository.findByimageName(filename);
            com.techgenie.demo.dto.domain.ImageData image = com.techgenie.demo.dto.domain.ImageData.builder()
                    .id(dbImageData.get().getImageId())
                    .name(dbImageData.get().getImageName())
                    .type(dbImageData.get().getImageType())
                    .data(dbImageData.get().getImageData()).build();
            return ImageUtils.decompressImage(image.getData());
        } catch (Exception e) {
            return null;
        }
    }

}
