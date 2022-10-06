package com.cisco.dataredis.repository;

import com.cisco.dataredis.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private static final String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate template;

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public Product findById(int id) {
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public List<Product> findAll() {
        return  template.opsForHash().values(HASH_KEY);
    }

    public String deleteById(int id) {
        template.opsForHash().delete(HASH_KEY, id);
        return String.format("product associated with id:%s is deleted", id);
    }


}
