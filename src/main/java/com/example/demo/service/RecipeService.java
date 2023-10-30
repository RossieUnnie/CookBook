package com.example.demo.service;

import com.example.demo.model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe delete(Long id);

    Recipe save(Recipe recipe);

    Recipe getRecipe(Long id);

    List<Recipe> getAll();

    Recipe updateTitle(Long id, String title);

    Recipe updateIngredients(Long id, String ingredients);

    Recipe updatePreparation(Long id, String preparation);
}
