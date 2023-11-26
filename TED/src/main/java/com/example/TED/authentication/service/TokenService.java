package com.example.TED.authentication.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.TED.authentication.model.UserModel;
import com.example.TED.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class TokenService {

    @Value("${security.jwt.token.secret-key:secret}")
    private String secretKey = "secret";

    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000; // 1h

    Algorithm algorithm = null;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        algorithm = Algorithm.HMAC256(secretKey.getBytes());
    }
     public TokenDTO gerarToken(UserModel usuario) {

        List<String> roles = usuario.getRoles().stream()
                .map( u -> u.getRoleName().toString()).toList();

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        var accessToken = getAccessToken(usuario.getUsername(), roles, now, validity);
        var refreshToken = getRefreshToken(usuario.getUsername(), roles, now);

        return new TokenDTO(usuario.getUsername(), true, now, validity, accessToken, refreshToken);
    }

    private String getAccessToken(String username, List<String> roles, Date now, Date validity) {
        String issuerUrl = ServletUriComponentsBuilder
                .fromCurrentContextPath().build().toUriString()
                + "/alunoOnline";
        return JWT.create()
                .withClaim("listaPerfeil", roles)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withSubject(username)
                .withIssuer(issuerUrl)
                .sign(algorithm)
                .strip();
    }

    private String getRefreshToken(String username, List<String> roles, Date now) {
        Date validityRefreshToken = new Date(now.getTime() + (validityInMilliseconds * 3));
        return JWT.create()
                .withClaim("roles", roles)
                .withIssuedAt(now)
                .withExpiresAt(validityRefreshToken)
                .withSubject(username)
                .sign(algorithm)
                .strip();
    }

    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(secretKey.getBytes()))
                .build().verify(token).getSubject();
    }



}