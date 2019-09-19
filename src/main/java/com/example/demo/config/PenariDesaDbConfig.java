package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
        basePackages = {"com.example.demo.repo.dbpenaridesa"},
        entityManagerFactoryRef = "penariDesaDbEmFactory",
        transactionManagerRef = "penariDesaDSTransactionManager"
)
public class PenariDesaDbConfig {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource1")
    public DataSourceProperties penariDesaDbProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource penariDesaDs(@Qualifier("penariDesaDbProperties") DataSourceProperties penariDesaDbProperties) {
        return penariDesaDbProperties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean penariDesaDbEmFactory(@Qualifier("penariDesaDs") DataSource penariDesaDs, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(penariDesaDs).packages("com.example.demo.domain.dbpenaridesa").build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager penariDesaDSTransactionManager(@Qualifier("penariDesaDbEmFactory") EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }
}
