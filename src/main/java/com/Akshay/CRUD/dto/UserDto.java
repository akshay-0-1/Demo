package com.Akshay.CRUD.dto;
import com.Akshay.CRUD.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private UserRole userRole;
}