package com.example.demo.service;

import com.example.demo.model.Recipe;

import java.util.List;

public interface RecipeService {

    Recipe delete(int id);

    Recipe save(Recipe recipe);

    Recipe getRecipe(int id);

    List<Recipe> getAll();

    Recipe updateTitle(int id, String title);

    Recipe updateIngredients(int id, String ingredients);

    Recipe updatePreparation(int id, String preparation);
}
