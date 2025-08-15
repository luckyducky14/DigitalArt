package za.ac.cput.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Discount;
import za.ac.cput.service.DiscountService;

import java.util.List;

@RestController
@RequestMapping("/discount")
public class DiscountController {

    private final DiscountService service;

    public DiscountController(DiscountService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Discount create(@RequestBody Discount discount) {
        return service.create(discount);
    }

    @GetMapping("/read/{discountID}")
    public Discount read(@PathVariable Long discountID) {
        return service.read(discountID);
    }

    @PutMapping("/update")
    public Discount update(@RequestBody Discount discount) {
        return service.update(discount);
    }

    @DeleteMapping("/delete/{discountID}")
    public void delete(@PathVariable Long discountID) {
        this.service.delete(discountID);
    }

    @GetMapping("/getAll")
    public List<Discount> getAll() {
        return service.getAll();
    }
}
