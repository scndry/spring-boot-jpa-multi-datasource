package io.github.scndry.poc.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
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

@Configuration
public class JpaRepositoriesConfig {

    private final JpaProperties jpaProperties;
    private final EntityManagerFactoryBuilder entityManagerFactoryBuilder;

    public JpaRepositoriesConfig(JpaProperties jpaProperties,
                                 EntityManagerFactoryBuilder entityManagerFactoryBuilder) {
        this.jpaProperties = jpaProperties;
        this.entityManagerFactoryBuilder = entityManagerFactoryBuilder;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean cafeEntityManagerFactory(
            DataSource cafeDataSource) {
        return entityManagerFactoryBuilder.dataSource(cafeDataSource)
                .packages("io.github.scndry.poc.entity.cafe", "io.github.scndry.poc.converter")
                .persistenceUnit("cafe")
                .properties(jpaProperties.getHibernateProperties(new HibernateSettings()))
                .build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager cafeTransactionManager(
            EntityManagerFactory cafeEntityManagerFactory) {
        return new JpaTransactionManager(cafeEntityManagerFactory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean cafeLogEntityManagerFactory(
            @Qualifier("cafeLogDataSource") DataSource cafeLogDataSource) {
        return entityManagerFactoryBuilder.dataSource(cafeLogDataSource)
                .packages("io.github.scndry.poc.entity.cafelog", "io.github.scndry.poc.converter")
                .persistenceUnit("cafelog")
                .properties(jpaProperties.getHibernateProperties(new HibernateSettings()))
                .build();
    }

    @Bean
    public PlatformTransactionManager cafeLogTransactionManager(
            @Qualifier("cafeLogEntityManagerFactory") EntityManagerFactory cafeLogEntityManagerFactory) {
        return new JpaTransactionManager(cafeLogEntityManagerFactory);
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages = "io.github.scndry.poc.repository.cafe",
            entityManagerFactoryRef = "cafeEntityManagerFactory",
            transactionManagerRef = "cafeTransactionManager")
    public class CafeJpaRepositoriesConfig {
    }

    @Configuration
    @EnableJpaRepositories(
            basePackages = "io.github.scndry.poc.repository.cafelog",
            entityManagerFactoryRef = "cafeLogEntityManagerFactory",
            transactionManagerRef = "cafeLogTransactionManager")
    public class CafeLogJpaRepositoriesConfig {
    }
}
