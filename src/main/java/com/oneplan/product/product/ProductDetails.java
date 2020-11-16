package com.oneplan.product.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDetails {
  private int product_id;
  private String productName;
  private String vendorId;
  private int inStock;
  private int vendorPhoneNum;
}
