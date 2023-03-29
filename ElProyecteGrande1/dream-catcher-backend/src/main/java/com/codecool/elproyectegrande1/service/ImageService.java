package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.entity.Image;
import com.codecool.elproyectegrande1.repository.ImageRepository;
import com.codecool.elproyectegrande1.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepo;

    public Image uploadImage(MultipartFile file) throws IOException {
        Image pImage = new Image();
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
        return imageRepo.save(pImage);
    }

    public byte[] downloadImage(String fileName){
        Optional<Image> imageData = imageRepo.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }

    public Image getImageFromDb(String fileName) {
        Image image = imageRepo.findImageByName(fileName);
        return image;
    }

    public byte[] getImageById(Long id) {
        Image image = imageRepo.findById(id).get();
        byte [] imageData = ImageUtil.decompressImage(image.getImageData());
        return imageData;
    }
}
