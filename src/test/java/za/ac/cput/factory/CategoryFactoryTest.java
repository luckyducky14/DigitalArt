package za.ac.cput.factory;
/*
Category.java
Category FactoryTest
Author: Abethu Ngxitho 221297820
Date: 18 May 2025
*/

import za.ac.cput.domain.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CategoryFactoryTest {

    private static final Category category1 = CategoryFactory.createCategory("Potraits" , "Digital art showing a person's face or expression");

    private static final Category category2 = CategoryFactory.createCategory(null , "Digital art using shapes and colors");

    private static final Category category3 = CategoryFactory.createCategory("Wall Art" , "");

    @Test
    void createCategory() {
        assertNotNull(category1);
        System.out.println(category1);
    }

    @Test
    void createCategoryWithNullName() {
        assertNotNull(category2);
        System.out.println(category2);
    }

    @Test
    void createCategoryThatWillFail() {
        //fail();
        assertNotNull(category3);
        System.out.println(category3);
    }


}
