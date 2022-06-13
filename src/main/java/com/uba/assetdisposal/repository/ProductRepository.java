package com.uba.assetdisposal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uba.assetdisposal.model.Product;

@Repository
public interface ProductRepository extends CrudRepository< Product, Long> {

}
