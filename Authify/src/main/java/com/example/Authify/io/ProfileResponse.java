package com.example.Authify.io;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {
    private String userId;
    private String email;
    private String name ;
    private boolean isAccountVerified ;
}
