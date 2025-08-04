package za.ac.cput.service;

import za.ac.cput.domain.CartItem;

/*
ICartItemService.java
ICartItem service
Author: Thandolwethu P MSELEKU(223162477)
Date: 03 August 2025
*/

import java.util.List;

public interface ICartItemService extends IService<CartItem,Integer>{
    List<CartItem> getAll();
}
