package com.example.RecipeBook.services;

import com.example.RecipeBook.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserById(Long id);

    Optional<User> findUserByEmail(String email);

    UserDetails loadUserByUsername(String email);
}
