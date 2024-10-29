package com.Akshay.CRUD.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home") // Base path for this controller
public class HomeController {

    @GetMapping // Handle GET requests to /api/home
    public String welcomeUser() {
        return "Welcome to the E-Learning Platform!"; // Welcome message
    }
}
