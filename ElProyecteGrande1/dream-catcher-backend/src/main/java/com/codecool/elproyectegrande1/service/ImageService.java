package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.entity.Dream;
import com.codecool.elproyectegrande1.entity.Image;
import com.codecool.elproyectegrande1.entity.Offer;
import com.codecool.elproyectegrande1.repository.DreamRepository;
import com.codecool.elproyectegrande1.repository.ImageRepository;
import com.codecool.elproyectegrande1.repository.OfferRepository;
import com.codecool.elproyectegrande1.util.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    private final ImageRepository imageRepo;
    private final OfferRepository offerRepository;
    private final DreamRepository dreamRepository;

    public ImageService(ImageRepository imageRepo,
                        OfferRepository offerRepository,
                        DreamRepository dreamRepository) {
        this.imageRepo = imageRepo;
        this.offerRepository = offerRepository;
        this.dreamRepository = dreamRepository;
    }

    public Image uploadImage(MultipartFile file, Long dreamId, Long offerId) throws IOException {
        Image pImage = new Image();
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
        Offer offer;
        Dream dream;

        if(offerId != null) {
            offer = offerRepository.findById(offerId).orElse(null);
            pImage.setOffer(offer);
        }
        if(dreamId != null) {
            dream = dreamRepository.findById(dreamId).orElse(null);
            pImage.setDream(dream);
        }
        Image savedImage = imageRepo.save(pImage);
        updateDreamAndOffer(dreamId, offerId, savedImage);
        return savedImage;
    }

    public byte[] downloadImage(String fileName){
        Optional<Image> imageData = imageRepo.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }

    public byte[] getImageById(Long id) {
        Image image = imageRepo.findImageByID(id);
        byte [] imageData = ImageUtil.decompressImage(image.getImageData());
        return imageData;
    }

    public void updateDreamAndOffer(Long dreamId, Long offerId, Image image) {
        Dream dream;
        Offer offer;
        if (dreamId != null) {
            dream = dreamRepository.findById(dreamId).orElse(null);
            if (!dream.equals(null)) {
                dream.setMainImage(image);
                dreamRepository.update(dream, dreamId);
            }
        }
        if (offerId != null) {
            offer = offerRepository.findById(offerId).orElse(null);
            if (!offer.equals(null)) {
                offer.setMainImage(image);
                offerRepository.update(offer, offerId);
            }
        }
    }
}
