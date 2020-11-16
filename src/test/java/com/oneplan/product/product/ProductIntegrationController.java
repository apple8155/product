package com.oneplan.product.product;

import com.oneplan.product.product.config.CassandraTestConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductIntegrationController {

  @Autowired MockMvc mockMvc;

  @BeforeAll
  public static void init() {
    CassandraTestConfig.startCassandra();
  }

  @Test
  void getProductDetails() throws Exception {
    MvcResult mvcResult =
        mockMvc.perform(MockMvcRequestBuilders.get("/products/details/1")).andReturn();
    System.out.print(mvcResult);
  }
}
