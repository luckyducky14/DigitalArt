package za.ac.cput.service;


import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;

import java.util.List;


public interface IProductService extends IService<Product, Long> {
    List<Product> getByCategory(Category category);

    List<Product> searchByTitle(String keyword);

    List<Product> filterByPrice(double minPrice, double maxPrice);

    List<Product> filterByMaxPrice(double maxPrice);
}
