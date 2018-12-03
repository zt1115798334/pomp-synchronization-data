package com.example.pompsynchronizationdata.config;


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
        entityManagerFactoryRef = "entityManagerFactorySource",
        transactionManagerRef = "transactionManagerSource",
        basePackages = {"com.example.pompsynchronizationdata.source.repo"}) //设置Repository所在位置
public class SourceConfig {

    @Resource
    @Qualifier("sourceDataSource")
    private DataSource sourceDataSource;

    @Primary
    @Bean(name = "entityManagerSource")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return Objects.requireNonNull(entityManagerFactorySource(builder).getObject()).createEntityManager();
    }

    @Resource
    private JpaProperties jpaProperties;

    private Map<String, Object> getVendorProperties() {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }

    /**
     * 设置实体类所在位置
     */
    @Primary
    @Bean(name = "entityManagerFactorySource")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySource(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(sourceDataSource)
                .packages("com.example.pompsynchronizationdata.source.entity")
                .persistenceUnit("sourcePersistenceUnit")
                .properties(getVendorProperties())
                .build();
    }

    @Primary
    @Bean(name = "transactionManagerSource")
    public PlatformTransactionManager transactionManagerSource(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(Objects.requireNonNull(entityManagerFactorySource(builder).getObject()));
    }


}
