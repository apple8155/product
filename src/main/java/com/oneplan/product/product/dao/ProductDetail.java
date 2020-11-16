package com.oneplan.product.product.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("product_details")
public class ProductDetail {
  @PrimaryKey
  @Column("product_id")
  private int product_id;

  @Column("product_name")
  private String productName;

  @Column("vendor")
  private String vendorId;

  @Column("instock")
  private int inStock;

  @Column("vendor_contact")
  private int vendorPhoneNum;
}
