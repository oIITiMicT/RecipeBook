package com.example.RecipeBook.controller;

import com.example.RecipeBook.builder.UserResponseBuilder;
import com.example.RecipeBook.dto.UserResponseDto;
import com.example.RecipeBook.model.User;
import com.example.RecipeBook.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
}
