package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class RefreshableDsDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(RefreshableDsDemoApplication.class, args);
  }

  @RestController
  static class SettingsController {
    private final JdbcOperations operations;

    SettingsController(JdbcOperations operations) {
      this.operations = operations;
    }

    @GetMapping("/settings")
    public List<Map<String, Object>> getSettings() {
      return operations.queryForList("select * from settings order by key");
    }
  }

}
