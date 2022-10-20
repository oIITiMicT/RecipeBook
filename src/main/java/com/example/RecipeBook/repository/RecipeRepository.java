package com.example.RecipeBook.repository;

import com.example.RecipeBook.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe getRecipeById(Long id);
}
