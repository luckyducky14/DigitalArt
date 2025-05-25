package repository;
/*
CartItemRepository.java
CartItemRepository POJO class
Author: Thandolwethu P Mseleku
Date: 25/05/2025
*/
import domain.Cart;
import domain.CartItem;
import domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

    List<CartItem> findByCart(Cart cart);


    List<CartItem>findByProduct(Product product);


    List<CartItem> findByQuantityGreaterThan(int quantity);
}
