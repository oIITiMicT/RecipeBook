package com.example.RecipeBook.services;

import java.util.Map;

public interface JwtRefreshService {

    Map<String, String> refresh(String oldRefreshToken);
}
