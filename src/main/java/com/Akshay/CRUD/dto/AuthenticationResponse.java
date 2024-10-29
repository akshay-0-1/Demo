package com.Akshay.CRUD.dto;
import com.Akshay.CRUD.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;
}
