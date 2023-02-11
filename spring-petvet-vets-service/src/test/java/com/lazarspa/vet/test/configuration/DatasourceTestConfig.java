package com.lazarspa.vet.test.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@PropertySource({"classpath:application-test.yaml"})
@ActiveProfiles("test")
@ComponentScan("com.lazarspa.vet")
public class DatasourceTestConfig {



//    @Value("classpath:import.sql")
//    private Resource dataScript;
//
//    @Value("${datasource.url}")
//    private String url;
//
//    @Value("${datasource.driverClassName}")
//    private String driverClassName;
//
//    @Value("${datasource.username}")
//    private String username;
//
//    @Value("${datasource.password}")
//    private String password;
//
//    @Primary
//    @Bean
//    public DataSource dataSourceForTest() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        DatabasePopulatorUtils.execute(databasePopulator(), dataSource);
//        return dataSource;
//    }
//    private DatabasePopulator databasePopulator() {
//        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//		populator.addScript(dataScript);
//        return populator;
//    }
}
