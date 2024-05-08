package org.escuelaing.convocatoriaadmin.config.database;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "db1ManagerFactory",
        transactionManagerRef = "db1TransactionManager",
        basePackages = {
                "org.escuelaing.convocatoriaadmin.domain.repositories.convocatorias"
        }
)
public class DBRegistro {
    private final Environment environment;

    public DBRegistro(Environment environment) {
        this.environment = environment;
    }

    @Bean(name = "db1DataSource")
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(environment.getProperty("db.datasource.jdbc.url"))
                .driverClassName(environment.getProperty("db.datasource.driver-class-name"))
                .username(environment.getProperty("db.datasource.username"))
                .password(environment.getProperty("db.datasource.password"))
                .build();
    }

    @Bean(name = "db1ManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("org.escuelaing.convocatoriaadmin.domain.entities.convocatorias");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.dialect", environment.getProperty("db.jpa.properties.hibernate.dialect"));
        factoryBean.setJpaPropertyMap(properties);
        return factoryBean;
    }

    @Bean(name = "db1TransactionManager")
    public PlatformTransactionManager platformTransactionManager(
            @Qualifier(value = "db1ManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
