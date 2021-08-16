package com.challenges.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Integer id;

    private List<Item> items;

}
