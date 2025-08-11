package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartItem;
import za.ac.cput.repository.CartItemRepository;

/*
CartItemService.java
CartItem service
Author: Thandolwethu P MSELEKU(223162477)
Date: 03 August 2025
*/

import java.util.List;

@Service
public class CartItemService implements ICartItemService {
     private CartItemRepository cartItemRepository;

     @Autowired
     void cartItemService(CartItemRepository cartItemRepository){
         this.cartItemRepository = cartItemRepository;
     }


    @Override
    public CartItem create(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem read(Integer cartItemId) {
        return cartItemRepository.findById(cartItemId).orElse(null);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public List<CartItem> getAll() {
        return this.cartItemRepository.findAll();
    }
}
