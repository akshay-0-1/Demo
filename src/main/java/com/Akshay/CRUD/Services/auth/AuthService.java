package com.Akshay.CRUD.Services.auth;
import com.Akshay.CRUD.dto.SignupRequest;
import com.Akshay.CRUD.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}


