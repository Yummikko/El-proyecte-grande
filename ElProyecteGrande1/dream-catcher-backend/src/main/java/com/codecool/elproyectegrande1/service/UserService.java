package com.codecool.elproyectegrande1.service;

import com.codecool.elproyectegrande1.entity.Avatar;
import com.codecool.elproyectegrande1.repository.AvatarRepository;
import com.codecool.elproyectegrande1.repository.UserRepository;
import com.codecool.elproyectegrande1.util.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.Collections;

@Service
public class UserService {

    public Map<String, Object> getUserClaims() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (authentication.getPrincipal() instanceof OidcUser) {
            OidcUser principal = ((OidcUser) authentication.getPrincipal());
            return principal.getClaims();
        }
        return Collections.emptyMap();
    }
    private final UserRepository userRepository;
    private final AvatarRepository avatarRepository;

    public UserService(UserRepository userRepository, AvatarRepository avatarRepository) {
        this.userRepository = userRepository;
        this.avatarRepository = avatarRepository;
    }

    public Avatar uploadAvatar(MultipartFile file) throws IOException {
        Avatar pAvatar = new Avatar();
        pAvatar.setName(file.getOriginalFilename());
        pAvatar.setType(file.getContentType());
        pAvatar.setImageData(ImageUtil.compressImage(file.getBytes()));
        return avatarRepository.save(pAvatar);
    }

    public Avatar getUserAvatar(String fileName) {
        Avatar avatar = avatarRepository.findAvatarByName(fileName);
        return avatar;
    }

    public byte[] getAvatarById(Long id) {
        Avatar image = avatarRepository.findAvatarByID(id);
        byte [] imageData = ImageUtil.decompressImage(image.getImageData());
        return imageData;
    }
}
