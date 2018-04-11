package com.gladunalexander.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties for jwt with default values.
 * Should be modified in application.yml/properties.
 *
 * @author Alexander Gladun
 */

@Getter
@Setter
@ConfigurationProperties(value = "jwt")
public class JWTProperties {

    private String secret = "secret";

    private Token token = new Token();

    @Getter
    @Setter
    public static class Token {

        private long expirationTime = 43200;

        private long rememberMeTime = 1209600;
    }
}
