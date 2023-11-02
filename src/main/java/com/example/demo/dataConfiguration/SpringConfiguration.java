package com.example.demo.dataConfiguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {
    @Autowired
    private Environment env;

    @Bean
    @Primary
    public DataSource recipeDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.recipe.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.recipe.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.recipe.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.recipe.password"));

        return dataSource;
    }

    @Bean
    public DataSource ingredientDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.ingredient.driver-class-name"));
        dataSource.setUrl(env.getProperty("spring.datasource.ingredient.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.ingredient.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.ingredient.password"));

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplateRecipe(@Qualifier("recipeDataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }

    @Bean
    public JdbcTemplate jdbcTemplateIngredient(@Qualifier("ingredientDataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }
}
