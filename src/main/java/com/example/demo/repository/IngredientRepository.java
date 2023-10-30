package com.example.demo.repository;

import com.example.demo.model.Ingredient;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends ListCrudRepository<Ingredient, Long> {
}
