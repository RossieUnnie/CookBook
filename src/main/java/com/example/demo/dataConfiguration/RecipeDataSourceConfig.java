//package com.example.demo.dataConfiguration;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "recipeEntityManagerFactory",
//        transactionManagerRef = "recipeTransactionManager",
//        basePackages = {"com.example.demo.repository"})
//public class RecipeDataSourceConfig {
//
//    @Primary
//    @Bean(name = "recipeProperties")
//    public DataSourceProperties recipeDataSourceProperties() {
//
//        return new DataSourceProperties();
//    }
//
//    @Primary
//    @Bean(name = "recipeDatasource")
//    @ConfigurationProperties(prefix = "spring.datasource.recipe")
//    public DataSource dataSource(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Primary
//    @Bean(name = "recipeEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean (
//            EntityManagerFactoryBuilder builder, @Qualifier("recipeDatasource") DataSource dataSource){
//
//        return builder.dataSource(dataSource)
//                .packages("com.example.model.recipe")
//                .persistenceUnit("recipe").build();
//    }
//
//    @Primary
//    @Bean(name = "recipeTransactionManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("recipeEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}
