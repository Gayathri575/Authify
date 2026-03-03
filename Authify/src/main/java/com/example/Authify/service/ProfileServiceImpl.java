package com.example.Authify.service;

import com.example.Authify.entity.UserEntity;
import com.example.Authify.io.ProfileRequest;
import com.example.Authify.io.ProfileResponse;
import com.example.Authify.userRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository ;

    @Override
    public ProfileResponse createProfile(ProfileRequest request) {

        userRepository.findByEmail(request.getEmail())
                .ifPresent(user -> {
                    throw new RuntimeException("Email already exists");
                });

       UserEntity newProfile = convertToUserEntity(request);
       newProfile = userRepository.save(newProfile);
       return convertToprofileResponse(newProfile);
    }

    private ProfileResponse convertToprofileResponse(UserEntity newProfile) {
        return ProfileResponse.builder()
                .email(newProfile.getEmail())
                .userId(newProfile.getUserId())
                .name(newProfile.getName())
                .isAccountVerified(newProfile.getIsAccountVerified())
                .build();

    }


    private UserEntity convertToUserEntity(ProfileRequest request) {
        return UserEntity.builder()
                .email(request.getEmail())
                .userId(UUID.randomUUID().toString())
                .name(request.getName())
                .password(request.getPassword())
                .isAccountVerified(false)
                .verifyOtp(null)
                .verifyOtpExpireAt(0L)
                .restOtpExpireAt(null)
                .build();

    }

}
