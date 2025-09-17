package com.san.simpleweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.san.simpleweb.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer>
{

}
