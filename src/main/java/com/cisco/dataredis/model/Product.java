package com.cisco.dataredis.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("Product")
public class Product {
    @Id
    private int id;
    private String name;
    private int qty;
    private long price;
}
