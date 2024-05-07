package com.university.application;

import com.university.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.university")
public class AppConfig {
    @Bean
    ApplicationService applicationServiceImpl() { return new ApplicationServiceImpl(); }
    @Bean
    DepartmentRepository departmentRepositoryImpl() {
        return new DepartmentRepositoryImpl();
    }
}