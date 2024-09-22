package dev.security.jwt.controller;

import dev.security.jwt.service.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final JwtProvider jwtProvider;

    public AuthController(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        LOG.debug("Token request for user {}", authentication.getName());
        String token = jwtProvider.generateToken(authentication);
        LOG.debug("Token is generated {}" , token);
        return token;
    }
}
