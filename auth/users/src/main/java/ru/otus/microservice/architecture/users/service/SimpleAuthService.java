package ru.otus.microservice.architecture.users.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import ru.otus.microservice.architecture.users.model.domain.Profile;
import ru.otus.microservice.architecture.users.model.domain.User;
import ru.otus.microservice.architecture.users.model.entity.UserEntity;
import ru.otus.microservice.architecture.users.repository.UserRepository;

import javax.persistence.EntityNotFoundException;

import java.net.URI;

@Service
public class SimpleAuthService implements AuthService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final UserRepository userRepository;
    private final URI profilesUri;
    private final String secret;

    @Autowired
    public SimpleAuthService(UserRepository userRepository, @Value("${profiles.uri}") URI profilesUri, @Value("${jwt.secret}") String secret) {
        System.out.println(profilesUri);
        this.userRepository = userRepository;
        this.profilesUri = profilesUri;
        this.secret = secret;
    }

    @Override
    @Transactional
    public String register(User user) {
        RequestEntity<Profile> requestEntity = RequestEntity.post(profilesUri).body(user.getProfile());
        ResponseEntity<Void> responseEntity = restTemplate.exchange(requestEntity, Void.class);
        String profileId = responseEntity.getHeaders().getFirst("X-Profile-Id");
        UserEntity userEntity = new UserEntity(null, profileId, user.getLogin(), user.getPassword());
        userRepository.save(userEntity);
        return profileId;
    }

    @Override
    public String login(User user) {
        UserEntity userEntity = userRepository.findByLogin(user.getLogin()).orElseThrow(EntityNotFoundException::new);
        if (!user.getPassword().equals(userEntity.getPassword()))
            throw new RuntimeException();
        return Jwts.builder()
                .setSubject(user.getLogin())
                .setId(userEntity.getProfileId())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}