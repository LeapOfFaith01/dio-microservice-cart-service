package com.challenges.redis.controller;

import com.challenges.redis.model.Cart;
import com.challenges.redis.model.Item;
import com.challenges.redis.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartRepository _repository;

    @PostMapping("/{id}")
    public Cart post(@PathVariable Integer id, @RequestBody Item item){
        Optional<Cart> savedCart = _repository.findById(id);
        Cart cart;
        if(savedCart.equals(Optional.empty())){
            cart = new Cart(id,new ArrayList<>());
        }
        else{
            cart = savedCart.get();
        }
        cart.getItems().add(new Item(item.getProductId(),item.getAmount()));
        return _repository.save(cart);
    }

    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable Integer id){
        return _repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void clear(@PathVariable Integer id){
        _repository.deleteById(id);
    }
}
