package com.Akshay.CRUD.Services.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails loadUserByUsername(String email);
}
