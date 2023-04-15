package com.codecool.elproyectegrande1.security.oauth;

import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.exceptions.OAuth2AuthenticationProcessingException;
import com.codecool.elproyectegrande1.repository.UserRepository;
import com.codecool.elproyectegrande1.security.UserPrincipal;
import com.codecool.elproyectegrande1.security.oauth.user.OAuth2UserInfo;
import com.codecool.elproyectegrande1.security.oauth.user.OAuth2UserInfoFactory;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomOauth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        try {
            return processOAuth2User(userRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception e){
            throw new InternalAuthenticationServiceException(e.getMessage(), e.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest userRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.get(userRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());

        if(StringUtils.isEmpty(oAuth2UserInfo.getEmail())){
            throw new OAuth2AuthenticationProcessingException("Email not found from provider");
        }

        Optional<User> userOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail());
        User appUser;
        if(userOptional.isPresent()){
            appUser = userOptional.get();
            //TODO check provider if equals
            appUser = update(appUser, oAuth2UserInfo);
        } else {
            appUser = register(userRequest, oAuth2UserInfo);
        }

        return UserPrincipal.create(appUser, oAuth2User.getAttributes());
    }

    private User register(OAuth2UserRequest userRequest, OAuth2UserInfo oAuth2UserInfo) {
        User appUser = new User();

        throw new RuntimeException("not implemented");

        // return userRepository.save(appUser);
    }

    private User update(User appUser, OAuth2UserInfo oAuth2UserInfo) {
        throw new RuntimeException("not implemented");
        // return userRepository.save(appUser);
    }
}
