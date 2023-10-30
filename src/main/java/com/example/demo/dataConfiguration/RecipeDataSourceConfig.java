package com.example.demo.dataConfiguration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.demo.repository",
        entityManagerFactoryRef = "recipeEntityManagerFactory",
        transactionManagerRef = "recipeTransactionManager"
)
public class RecipeDataSourceConfig {

    @Primary
    @Bean(name = "recipeDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource recipeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "recipeEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean recipeEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("recipeDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create-drop");

        return builder
                .dataSource(dataSource)
                .packages("com.example.demo.model")
                .persistenceUnit("recipe")
                .properties(properties)
                .build();
    }

    @Primary
    @Bean(name = "recipeTransactionManager")
    public PlatformTransactionManager recipeTransactionManager(
            @Qualifier("recipeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
