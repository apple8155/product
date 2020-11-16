package com.oneplan.product.product.controller;

import com.oneplan.product.product.ProductDetails;
import com.oneplan.product.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class ProductController {

  @Autowired ProductService productService;

  @RequestMapping(path = "details/{id}", method = RequestMethod.GET, produces = "application/json")
  public ProductDetails getProductDetails(@PathVariable("id") int id) {
    return productService.getProductDetailByID(id);
  }

  @RequestMapping(
      path = "details/add",
      method = RequestMethod.POST,
      produces = "application/json",
      consumes = "application/json")
  public ProductDetails addProductDetails(@RequestBody ProductDetails productDetails) {
    return productService.addProductDetails(productDetails);
  }

  @RequestMapping(
      path = "details/{id}",
      method = RequestMethod.DELETE,
      produces = "application/json")
  public void deleteProductDetails(@PathVariable("id") int id) {
    productService.deleteProductDetails(id);
  }
}
