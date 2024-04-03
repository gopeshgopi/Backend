package com.restaruant.app.repository;

import com.restaruant.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository  extends JpaRepository<Product,Long> {

}
