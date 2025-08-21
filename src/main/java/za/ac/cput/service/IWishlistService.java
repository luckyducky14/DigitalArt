package za.ac.cput.service;
import za.ac.cput.domain.Wishlist;
import java.util.List;

public interface IWishlistService extends IService<Wishlist, Long> {
 List<Wishlist> getUserWishList(Long UserId);
}
