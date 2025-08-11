package za.ac.cput.service;
/*
CartService.java
Cart service
Author: Bekithemba Mrwetyana (222706066)
Date: 06 July 2025
*/
import za.ac.cput.domain.Cart;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.CartRepository;

import java.util.List;

@Service
public class CartService implements ICartService{

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
