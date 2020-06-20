package com.example.demo;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

@Profile("refreshable-ds")
@Configuration
public class RefreshScopeDataSourceConfig {

  @Bean
  @RefreshScope
  DataSource dataSource(DataSourceProperties properties) {
    HikariDataSource dataSource = properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    if (StringUtils.hasText(properties.getName())) {
      dataSource.setPoolName(properties.getName());
    }
    return dataSource;
  }

}
