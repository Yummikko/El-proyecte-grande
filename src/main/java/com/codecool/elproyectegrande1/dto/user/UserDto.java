package com.codecool.elproyectegrande1.dto.user;

import com.codecool.elproyectegrande1.entity.Role;
import com.codecool.elproyectegrande1.util.PasswordMatches;
import com.codecool.elproyectegrande1.util.ValidEmail;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@PasswordMatches
public class UserDto {
    @NotNull
    @Size(min = 1)
    private String username;

    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;

    private boolean isUsing2FA;
    private String profileImgUrl;
    private List<String> roles;

    public String getEmail() {
        return email;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    public List<String> getRoles() {
        return roles;
    }

    public UserDto(String username, String email, String profileImgUrl, List<String> roles) {
        this.username = username;
        this.email = email;
        this.profileImgUrl = profileImgUrl;
        this.roles = roles;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public List<String> getRole() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(final String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public boolean isUsing2FA() {
        return isUsing2FA;
    }

    public void setUsing2FA(boolean isUsing2FA) {
        this.isUsing2FA = isUsing2FA;
    }

}
