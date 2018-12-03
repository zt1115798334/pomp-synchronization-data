package com.example.pompsynchronizationdata.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;
import java.util.Objects;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/16 11:29
 * description:
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryTarget",
        transactionManagerRef = "transactionManagerTarget",
        basePackages = {"com.example.pompsynchronizationdata.target.repo"})
public class TargetConfig {

    @Resource
    @Qualifier("targetDataSource")
    private DataSource targetDataSource;

    @Bean(name = "entityManagerTarget")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return Objects.requireNonNull(entityManagerFactoryTarget(builder).getObject()).createEntityManager();
    }

    @Resource
    private JpaProperties jpaProperties;

    private Map<String, Object> getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }


    @Bean(name = "entityManagerFactoryTarget")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryTarget(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(targetDataSource)
                .packages("com.example.pompsynchronizationdata.target.entity")
                .persistenceUnit("targetPersistenceUnit")
                .properties(getVendorProperties())
                .build();
    }

    @Bean(name = "transactionManagerTarget")
    PlatformTransactionManager transactionManagerTarget(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactoryTarget(builder).getObject()));
    }

}
