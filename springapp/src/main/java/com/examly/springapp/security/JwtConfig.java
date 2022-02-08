package com.examly.springapp.security;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {

    private String secretKey;
    private String tokenPrefix;
    private Integer accessTokenExpirationAfterDays;

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getTokenPrefix() {
        return tokenPrefix;
    }

    public void setTokenPrefix(String tokenPrefix) {
        this.tokenPrefix = tokenPrefix;
    }

    public Integer getAccessTokenExpirationAfterDays() {
        return accessTokenExpirationAfterDays;
    }

    public void setAccessTokenExpirationAfterDays(Integer accessTokenExpirationAfterDays) {
        this.accessTokenExpirationAfterDays = accessTokenExpirationAfterDays;
    }

    public Algorithm getAlgorithm() {
        return Algorithm.HMAC256(getSecretKey().getBytes());
    }
}