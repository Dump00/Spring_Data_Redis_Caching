package com.cisco.dataredis.controller;


import com.cisco.dataredis.model.Product;
import com.cisco.dataredis.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@EnableCaching
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return repository.save(product);
    }

    @GetMapping
    public List<Product> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "#Product", unless = "#result.price > 500")
    public Product findById(@PathVariable int id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id", value = "#Product")
    public String delete(@PathVariable int id) {
        return repository.deleteById(id);
    }
}
