package ru.otus.microservice.architecture.profiles.controller;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.otus.microservice.architecture.profiles.exception.ApiAuthException;
import ru.otus.microservice.architecture.profiles.model.domain.Profile;
import ru.otus.microservice.architecture.profiles.service.ProfileService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ProfileController {
    private final ProfileService profileService;
    private final String secret;

    @Autowired
    public ProfileController(ProfileService profileService, @Value("${jwt.secret}") String secret) {
        this.profileService = profileService;
        this.secret = secret;
    }

    @PostMapping(path = "/profiles")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(@RequestBody Profile profile, HttpServletResponse httpServletResponse) {
        String profileId = profileService.create(profile);
        httpServletResponse.setHeader("X-Profile-Id", profileId);
    }

    @PatchMapping(path = "/profiles/{id}")
    public void update(@PathVariable(name = "id") String id, @RequestBody Profile profile, @RequestHeader("Authorization") String token) {
        validate(token, id);
        profileService.update(id, profile);
    }

    @GetMapping(path = "/profiles/{id}")
    public Profile read(@PathVariable(name = "id") String id, @RequestHeader(name = "Authorization") String token) {
        validate(token, id);
        return profileService.read(id);
    }

    private void validate(String token, String profileId) {
        String id;
        try {
            id = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getId();
        } catch (Exception e) {
            throw new ApiAuthException("Token is incorrect");
        }
        if (!profileId.equals(id))
            throw new ApiAuthException("Denied for this user");
    }
}