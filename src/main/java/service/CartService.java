package service;
/*
CartService.java
Cart service
Author: Bekithemba Mrwetyana (222706066)
Date: 06 July 2025
*/
import domain.Cart;
import org.springframework.stereotype.Service;
import repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    public static ICartService service;
    public CartRepository repository;


    public Cart create(Cart cart) {
        return repository.save(cart);
    }

    public Cart read(String cartID) {
        return repository.findById(cartID).orElse(null);
    }

    public Cart update(Cart cart) {
        return repository.save(cart);
    }

    public boolean delete(String cartID) {
        this.repository.deleteById(cartID);
        return true;
    }

    public List<Cart> getAll(){
        return repository.findAll();
    }
}
