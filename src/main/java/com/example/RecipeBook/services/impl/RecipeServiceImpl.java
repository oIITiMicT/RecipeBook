package com.example.RecipeBook.services.impl;

import com.example.RecipeBook.model.Recipe;
import com.example.RecipeBook.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl {

    private final RecipeRepository recipeRepository;

    public Recipe getRecipeById(Long id) {
        return recipeRepository.getRecipeById(id);
    }
}
