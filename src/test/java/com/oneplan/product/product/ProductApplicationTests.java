package com.oneplan.product.product;

import com.oneplan.product.product.config.CassandraTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {CassandraTestConfig.class})
class ProductApplicationTests {

  @Test
  void contextLoads() {}
}
