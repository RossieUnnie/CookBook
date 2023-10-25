package com.example.demo.service;

import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe delete(int id) {
        Recipe recipe = recipeRepository.findById(id).get();
        recipeRepository.delete(recipeRepository.findById(id).get());
        return recipe;
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe getRecipe(int id) {
        Recipe recipe = recipeRepository.findById(id).get();
        return recipe;
    }

    @Override
    public List<Recipe> getAll() {
        List<Recipe> recipe = new ArrayList<>();

        List<Recipe> recipeToFind = recipeRepository.findAll();
        for (Recipe found : recipeToFind) {
            recipe.add(found);
        }
        return recipe;
    }
    @Override
    public Recipe updateTitle(int id, String title) {
        Recipe recipe = recipeRepository.findById(id).get();
        recipe.setTitle(title);
        recipeRepository.save(recipe);
        return recipe;
    }

    @Override
    public Recipe updateIngredients(int id, String ingredients) {
        Recipe recipe = recipeRepository.findById(id).get();
        recipe.setIngredients(ingredients);
        recipeRepository.save(recipe);
        return recipe;
    }

    @Override
    public Recipe updatePreparation(int id, String preparation) {
        Recipe recipe = recipeRepository.findById(id).get();
        recipe.setPreparation(preparation);
        recipeRepository.save(recipe);
        return recipe;
    }

}
