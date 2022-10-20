package com.example.RecipeBook.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {

    private long id;
    private String username;
    private String email;
    private List<Long> commentsId;
    private List<Long> friendsId;
    private List<Long> createdRecipesId;
    private List<Long> favoriteRecipesId;
}
