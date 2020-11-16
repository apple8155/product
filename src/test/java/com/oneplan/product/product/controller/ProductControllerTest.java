package com.oneplan.product.product.controller;

import com.oneplan.product.product.ProductDetails;
import com.oneplan.product.product.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

@WebMvcTest
class ProductControllerTest {

  @MockBean ProductService productService;

  @Autowired MockMvc mockMvc;

  @Test
  void getProductDetails() throws Exception {
    Mockito.when(productService.getProductDetailByID(anyInt())).thenReturn(new ProductDetails());
    MvcResult mvcResult =
        mockMvc.perform(MockMvcRequestBuilders.get("/products/details/1")).andReturn();
    Mockito.verify(productService, times(1)).getProductDetailByID(anyInt());
  }
}
