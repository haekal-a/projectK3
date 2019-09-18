package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = {"com.example.demo.repo.dbsimakbmn"},
        entityManagerFactoryRef = "simakBmnDbEmFactory",
        transactionManagerRef = "simakBmnDSTransactionManager"
)
public class SimakBmnDbConfig {

    @Bean
    @ConfigurationProperties("spring.datasource3")
    public DataSourceProperties simakBmnDbProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource simakBmnDs(@Qualifier("simakBmnDbProperties") DataSourceProperties simakBmnDbProperties) {
        return simakBmnDbProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean simakBmnDbEmFactory(@Qualifier("simakBmnDs") DataSource simakBmnDs, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(simakBmnDs).packages("com.example.demo.domain.dbsimakbmn").build();
    }

    @Bean
    public PlatformTransactionManager simakBmnDSTransactionManager( @Qualifier("simakBmnDbEmFactory") EntityManagerFactory factorysimakBmn) {
        return new JpaTransactionManager(factorysimakBmn);
    }
}
