package com.example.Authify.service;


import com.example.Authify.io.ProfileRequest;
import com.example.Authify.io.ProfileResponse;

public interface ProfileService {
    public ProfileResponse createProfile(ProfileRequest request);


}
