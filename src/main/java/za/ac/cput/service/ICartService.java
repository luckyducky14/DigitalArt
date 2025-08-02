package za.ac.cput.service;
/*
ICartService.java
Cart service interface
Author: Bekithemba Mrwetyana (222706066)
Date: 05 July 2025
*/
import za.ac.cput.domain.Cart;

import java.util.List;

public interface ICartService extends IService <Cart, String>{

    List<Cart> getAll();
}
