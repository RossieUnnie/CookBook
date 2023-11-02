package com.example.demo.dataConfiguration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class IngredientConfiguration {

    @Bean(name = "ingredientProperties")
    @ConfigurationProperties("spring.datasource.ingredient")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "ingredientDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.order")
    public DataSource dataSource(@Qualifier("ingredientProperties")DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }
}
