package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        imageService.uploadImage(file);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<byte[]> downloadImage(@PathVariable String fileName) {
        byte[] image = imageService.downloadImage(fileName);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }

    @GetMapping("/image/display/{id}")
    @ResponseBody
    public String showImage(@PathVariable("id") Long id) {
        byte[] image = imageService.getImageById(id);
        String encodedString = Base64.getEncoder().encodeToString(image);
        return encodedString;
    }
}
