package com.restaruant.app.controller;


import com.restaruant.app.entity.Product;
import com.restaruant.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }




    @PostMapping("/products")
    public Product  saveProducts(@RequestBody Product product)
    {
        return productRepository.save(product);
    }


    @DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
            throws Exception
    {
        Map<String,Boolean> response  = new HashMap<>();

            Product product = productRepository.findById(productId).
                    orElseThrow(() -> new Exception("Product Not found for this Id"));
           response.put("deleted", Boolean.TRUE);
           productRepository.delete(product);

        return response;

    }



}
