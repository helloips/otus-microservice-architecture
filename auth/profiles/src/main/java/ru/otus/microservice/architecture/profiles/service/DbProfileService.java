package ru.otus.microservice.architecture.profiles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.microservice.architecture.profiles.repository.ProfileRepository;
import ru.otus.microservice.architecture.profiles.model.domain.Profile;
import ru.otus.microservice.architecture.profiles.model.entity.ProfileEntity;

import javax.persistence.EntityNotFoundException;

@Service
public class DbProfileService implements ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public DbProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    @Transactional
    public String create(Profile profile) {
        ProfileEntity profileEntity = new ProfileEntity(null, profile.getFullName(), profile.getCitizenship(), profile.getAge());
        profileRepository.save(profileEntity);
        return profileEntity.getId();
    }

    @Override
    @Transactional
    public void update(String id, Profile profile) {
        ProfileEntity profileEntity = profileRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        profileEntity.setFullName(profile.getFullName());
        profileEntity.setCitizenship(profile.getCitizenship());
        profileEntity.setAge(profile.getAge());
    }

    @Override
    public Profile read(String id) {
        ProfileEntity profileEntity = profileRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new Profile(profileEntity.getFullName(), profileEntity.getCitizenship(), profileEntity.getAge());
    }
}
