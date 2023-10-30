package com.example.demo.controller;

import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    private final RecipeService recipeService;

    @Autowired
    public ApiController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }


    @PostMapping("/create")
    public ResponseEntity<?> createRecipe(@RequestBody Recipe recipe) {
        return ResponseEntity.status(201).body(recipeService.save(recipe));
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<?> getRecipe(@PathVariable Long id) {
        return ResponseEntity.status(200).body(recipeService.getRecipe(id));
    }

    @GetMapping("/")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(recipeService.getAll());
    }

    @DeleteMapping("recipe/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.status(200).body(recipeService.delete(id));
    }

    @PatchMapping("/update/title/{id}")
    public ResponseEntity<?> updateTitle(@PathVariable Long id,
                                         @RequestParam String title) {
        return ResponseEntity.status(200).body(recipeService.updateTitle(id, title));
    }

    @PatchMapping("/update/ingredients/{id}")
    public ResponseEntity<?> updateIngredients(@PathVariable Long id,
                                               @RequestParam String ingredients) {
        return ResponseEntity.status(200).body(recipeService.updateIngredients(id, ingredients));
    }

    @PatchMapping("/update/preparation/{id}")
    public ResponseEntity<?> updatePreparation(@PathVariable Long id,
                                               @RequestParam String preparation) {
        return ResponseEntity.status(200).body(recipeService.updatePreparation(id, preparation));
    }
}