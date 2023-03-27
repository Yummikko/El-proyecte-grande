package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.entity.Image;
import com.codecool.elproyectegrande1.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

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
    void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<Image> image)
            throws ServletException, IOException {
        image = imageService.getImageById(id);
        response.setContentType("image/jpeg");
        response.setContentType("image/png");
        response.setContentType("image/jpg");
        response.getOutputStream().write(image.get().getImageData());
        response.getOutputStream().close();
    }
}
