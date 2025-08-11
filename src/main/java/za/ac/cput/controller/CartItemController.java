package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.CartItem;
import za.ac.cput.service.CartItemService;
/*
CartItemController.java
CartItem controller
Author: Thandolwethu P MSELEKU(223162477)
Date: 03 August 2025
*/


import java.util.List;

@RestController
@RequestMapping("/CartItem")
public class CartItemController {

    private CartItemService service;

    @Autowired
    public CartItemController(CartItemService service) {
        this.service = service;}

    @PostMapping("/create")
    public CartItem create(@RequestBody CartItem cartItem) {
        return service.create(cartItem);
    }

    @GetMapping("/read/{cartItemId}")
    public CartItem read(@PathVariable int cartItemId) {return service.read(cartItemId);}

    @PutMapping("/update")
    public CartItem update(@RequestBody CartItem cartItem) {return service.update(cartItem);}

    @DeleteMapping("/delete/{cartItemId}")
    public boolean delete(@PathVariable int cartItemId) {return service.delete(cartItemId);}

    @GetMapping("/getAll")
    public List<CartItem> getAll() {return service.getAll();}

}


