package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.repository.WishlistRepository;

import java.util.List;

@Service
public class WishlistService implements IWishlistService {

    private final WishlistRepository repository;


    public WishlistService(WishlistRepository repository) {
        this.repository = repository;
    }

    @Override
    public Wishlist create(Wishlist wishlist) {
        return repository.save(wishlist);
    }

    @Override
    public Wishlist read(Long wishlistID) {
        return repository.findById(wishlistID).orElse(null);
    }

    @Override
    public Wishlist update(Wishlist wishlist) {
        return repository.save(wishlist);
    }

    @Override
    public void delete(Long wishlistID) {repository.deleteById(wishlistID);
    }

    @Override
    public List<Wishlist> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Wishlist> getUserWishList(User userId) {
        return repository.findByUser(userId);
    }

    @Override
    public List<Wishlist> getUserWishList(Long UserId) {
        return List.of();
    }
}


