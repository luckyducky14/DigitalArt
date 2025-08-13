package za.ac.cput.repository;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.User;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findByUserID(User userID);
    List<Cart> findByCartID(Long cartID);
    List<Cart> findByCartItem(CartItem cartItem);

}
