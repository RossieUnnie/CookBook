package com.example.demo.dataConfiguration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;

@Configuration
public class RecipeDataSourceConfig {

    @Primary
    @Bean(name = "recipeProperties")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties recipeDataSourceProperties() {

        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "recipeDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(@Qualifier("recipeProperties")DataSourceProperties properties){
        return  properties.initializeDataSourceBuilder().build();
    }
}
