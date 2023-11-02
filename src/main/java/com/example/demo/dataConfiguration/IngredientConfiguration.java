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
//        entityManagerFactoryRef = "ingredientEntityManagerFactory",
//        transactionManagerRef = "ingredientTransactionManager",
//        basePackages = {"com.example.demo.repository"})
//public class IngredientConfiguration {
//
//    @Bean(name = "ingredientProperties")
//    public DataSourceProperties dataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean(name = "ingredientDatasource")
//    @ConfigurationProperties("spring.datasource.ingredient")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "ingredientEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
//            (EntityManagerFactoryBuilder builder, @Qualifier("ingredientDatasource") DataSource dataSource) {
//
//        return builder.dataSource(dataSource)
//                .packages("com.example.model.ingredient")
//                .persistenceUnit("ingredient").build();
//    }
//
//    @Bean(name = "ingredientTransactionManager")
//    public PlatformTransactionManager transactionManager(
//            @Qualifier("ingredientEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
//
//        return new JpaTransactionManager(entityManagerFactory);
//    }
//}
