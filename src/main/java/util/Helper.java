package util;

public class Helper {
    public static boolean isValidCartItemID(int cartItemID) {
        return cartItemID >= 0;
    }

    public static boolean isValidCartID(int cartID) {
        return cartID >= 0;
    }

    public static boolean isValidProductID(int productID) {
        return productID >0;
    }

    public static boolean isValidQuantity(int quantity) {
        return quantity >0;
    }
}
