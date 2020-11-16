package com.oneplan.product.product.service;

import com.oneplan.product.product.ProductDetails;
import com.oneplan.product.product.dao.ProductDetail;
import com.oneplan.product.product.repository.ProductDetailsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

  @Autowired ProductDetailsRepository productDetailsRepository;

  public ProductDetails getProductDetailByID(int id) {
    ProductDetails productDetail = new ProductDetails();
    Optional<ProductDetail> productDetailOptional = productDetailsRepository.findById(id);
    if (productDetailOptional.isPresent()) {
      BeanUtils.copyProperties(productDetailOptional.get(), productDetail);
    }
    return productDetail;
  }

  public ProductDetails addProductDetails(ProductDetails productDetails) {
    ProductDetail productDetail = new ProductDetail();
    BeanUtils.copyProperties(productDetails, productDetail);
    productDetailsRepository.insert(productDetail);
    return productDetails;
  }

  public void deleteProductDetails(int productID) {
    productDetailsRepository.deleteById(productID);
  }
}
