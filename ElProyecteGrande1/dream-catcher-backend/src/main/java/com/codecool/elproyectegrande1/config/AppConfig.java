package com.codecool.elproyectegrande1.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.List;

@Data
@EnableAsync
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private List<String> authorizedRedirectUris = List.of("http://localhost:8081/oauth2/redirect");

    public AppConfig authorizedRedirectUris(List<String> authorizedRedirectUris) {
        this.authorizedRedirectUris = authorizedRedirectUris;
        return this;
    }

    private String tokenSecret;

    private long tokenExpirationMsec;

    public List<String> getAuthorizedRedirectUris() {
        return authorizedRedirectUris;
    }

    public String getTokenSecret() {
        return tokenSecret;
    }

    public void setTokenSecret(String tokenSecret) {
        this.tokenSecret = tokenSecret;
    }

    public long getTokenExpirationMsec() {
        return tokenExpirationMsec;
    }

    public void setTokenExpirationMsec(long tokenExpirationMsec) {
        this.tokenExpirationMsec = tokenExpirationMsec;
    }
}
