package com.example.Authify.io;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AuthResponse {
    private String email;
    private String token ;
}
