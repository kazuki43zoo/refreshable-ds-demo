package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("refreshable-ds")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RefreshableDsDemoApplicationTests {

  @Autowired
  TestRestTemplate testRestTemplate;

  @Test
  void contextLoads() {
    String body = testRestTemplate.getForObject("/settings", String.class);
    Assertions.assertThat(body).isEqualTo("[{\"KEY\":\"name\",\"VALUE\":\"demo\"},{\"KEY\":\"version\",\"VALUE\":\"1.0.0\"}]");
  }

}
