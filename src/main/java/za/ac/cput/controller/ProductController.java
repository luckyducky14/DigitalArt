package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Category;
import za.ac.cput.domain.Product;
import za.ac.cput.service.IProductService;


import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {

    private final IProductService service;

    @Autowired
    public ProductController(IProductService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        return service.create(product);
    }

    @GetMapping("/read/{id}")
    public Product read(@PathVariable Long id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product product) {
        return service.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/getAll")
    public List<Product> getAll() {
        return service.getAll();
    }

    // Custom queries

    @GetMapping("/category")
    public List<Product> getByCategory(@PathVariable Category category) {
        return service.getByCategory(category);
    }

    @GetMapping("/search")
    public List<Product> searchByTitle(@RequestParam String keyword) {
        return service.searchByTitle(keyword);
    }

    @GetMapping("/price")
    public List<Product> filterByPrice(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return service.filterByPrice(minPrice, maxPrice);
    }

    @GetMapping("/belowPrice")
    public List<Product> filterByMaxPrice(@RequestParam double maxPrice) {
        return service.filterByMaxPrice(maxPrice);

    }
}