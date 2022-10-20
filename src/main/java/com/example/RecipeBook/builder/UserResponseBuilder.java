package com.example.RecipeBook.builder;

import com.example.RecipeBook.dto.UserResponseDto;
import com.example.RecipeBook.model.Comment;
import com.example.RecipeBook.model.Recipe;
import com.example.RecipeBook.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserResponseBuilder {

    public UserResponseDto buildUserResponse(User user) {
        UserResponseDto userResponse = new UserResponseDto();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        List<Long> comments = new ArrayList<>();
        for (Comment now : user.getComments()) {
            comments.add(now.getId());
        }
        userResponse.setCommentsId(comments);
        List<Long> friends = new ArrayList<>();
        for (User now : user.getFriends()) {
            friends.add(now.getId());
        }
        userResponse.setFriendsId(friends);
        List<Long> createdRecipes = new ArrayList<>();
        for (Recipe now : user.getCreatedRecipes()) {
            createdRecipes.add(now.getId());
        }
        userResponse.setCreatedRecipesId(createdRecipes);
        List<Long> favoriteRecipes = new ArrayList<>();
        for (Recipe now : user.getFavoriteRecipes()) {
            favoriteRecipes.add(now.getId());
        }
        userResponse.setFavoriteRecipesId(favoriteRecipes);
        return userResponse;
    }
}
