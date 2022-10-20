package com.example.RecipeBook.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.example.RecipeBook.services.JwtRefreshService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class JwtRefreshServiceImpl implements JwtRefreshService {
    public static final String ACCESS_TOKEN = "access_token";
    public static final String REFRESH_TOKEN = "refresh_token";
    @Value("${jwt.token.secret}")
    private String secret;
    private final UserTokenProvider tokenProvider;

    @Override
    public Map<String, String> refresh(String oldRefreshToken) {
        Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT refreshDecoded = verifier.verify(oldRefreshToken);
        String emailFromOldRefresh = refreshDecoded.getSubject();
        Map<String, String> tokensPair = tokenProvider.provide(emailFromOldRefresh);
        String accessToken = tokensPair.get(UserTokenProvider.ACCESS_TOKEN);
        String refreshToken = tokensPair.get(UserTokenProvider.REFRESH_TOKEN);
        log.info("User {}: refreshed refresh token", emailFromOldRefresh);
        return Map.of(ACCESS_TOKEN, accessToken, REFRESH_TOKEN, refreshToken);
    }
}
