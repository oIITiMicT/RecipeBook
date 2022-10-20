package com.example.RecipeBook.controller;

import com.example.RecipeBook.model.Recipe;
import com.example.RecipeBook.services.impl.RecipeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RecipeController {

    private final RecipeServiceImpl recipeService;

    @GetMapping("/recipe")
    public Recipe getRecipeById(@RequestParam Long id) {
        return recipeService.getRecipeById(id);
    }

}
