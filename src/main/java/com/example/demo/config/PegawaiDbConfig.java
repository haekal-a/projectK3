package com.example.demo.config;

import com.example.demo.domain.dbpegawai.PegawaiEntity;
import com.example.demo.repo.dbpegawai.PegawaiRepository;
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
        basePackages = {"com.example.demo.repo.dbpegawai"},
        entityManagerFactoryRef = "pegawaiDbEmFactory",
        transactionManagerRef = "pegawaiDSTransactionManager"
)
public class PegawaiDbConfig {

    @Bean
    @ConfigurationProperties("spring.datasource2")
    public DataSourceProperties pegawaiDbProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource pegawaiDs(@Qualifier("pegawaiDbProperties") DataSourceProperties pegawaiDbProperties) {
        return pegawaiDbProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean pegawaiDbEmFactory(@Qualifier("pegawaiDs") DataSource pegawaiDs, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(pegawaiDs).packages("com.example.demo.domain.dbpegawai").build();
    }

    @Bean
    public PlatformTransactionManager pegawaiDSTransactionManager( @Qualifier("pegawaiDbEmFactory") EntityManagerFactory factoryPegawai) {
        return new JpaTransactionManager(factoryPegawai);
    }
}
