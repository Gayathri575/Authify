package com.example.Authify.io;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest {
    @NotNull(message = "Name Should Not be Null")
    private String name;
    @Email
    @NotNull(message = "Email Should Not be Null")
    private String email ;
    @Size(min = 6 , message = "Password Must 6 characters")
    private String password;
}
