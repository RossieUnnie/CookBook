package com.example.demo.repository;

import com.example.demo.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends ListCrudRepository<Recipe, Integer> {

}
