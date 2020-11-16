package com.oneplan.product.product.repository;

import com.oneplan.product.product.dao.ProductDetail;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDetailsRepository extends CassandraRepository<ProductDetail, Integer> {
  @Override
  Optional<ProductDetail> findById(Integer integer);

  @Override
  <S extends ProductDetail> S insert(S s);

  @Override
  void deleteById(Integer integer);
}
