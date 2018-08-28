package io.github.scndry.poc.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("application.datasource.cafe")
    public DataSourceProperties cafeDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("application.datasource.cafe.hikari")
    public HikariDataSource cafeDataSource() {
        return cafeDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean
    @ConfigurationProperties("application.datasource.cafelog")
    public DataSourceProperties cafeLogDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("application.datasource.cafelog.hikari")
    public HikariDataSource cafeLogDataSource() {
        return cafeLogDataSourceProperties().initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
}
