package za.ac.cput.repository;

import za.ac.cput.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


    List<OrderItem> findByOrderID(Long orderID);

    List<OrderItem> findByProductProductID(Long productID);

    List<OrderItem> findByQuantityGreaterThan(int quantity);

    List<OrderItem> findBySubTotalBetween(double minAmount, double maxAmount);
}
