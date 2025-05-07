package domain;
/*
CartItem.java
CartItem POJO class
Author: Thandolwethu P Mseleku
Date: 07 May 2025
*/
public class CartItem {
 private int cartItemID;
 private int cartID;
 private int productID;
 private int quantity;

 private CartItem() {
 }

 public CartItem(Builder builder){
  this.cartItemID=builder.cartItemID;
  this.cartID=builder.cartID;
  this.productID=builder.productID;
  this.quantity=builder.quantity;
 }

 public int getCartItemID() {
  return cartItemID;
 }

 public int getCartID() {
  return cartID;
 }

 public int getProductID() {
  return productID;
 }

 public int getQuantity() {
  return quantity;
 }

 public static class Builder{
  private int cartItemID;
  private int cartID;
  private int productID;
  private int quantity;

  public Builder setCartItemID(int cartItemID) {
   this.cartItemID = cartItemID;
   return this;
  }

  public Builder setQuantity(int quantity) {
   this.quantity = quantity;
   return this;
  }

  public Builder setProductID(int productID) {
   this.productID = productID;
   return this;
  }

  public Builder setCartID(int cartID) {
   this.cartID = cartID;
   return this;
  }

  public Builder copy(CartItem cartItem){
   this.cartItemID=cartItem.cartItemID;
   this.cartID=cartItem.cartID;
   this.productID=cartItem.productID;
   this.quantity=cartItem.quantity;
   return this;

  }
  public CartItem build(){
   return new CartItem(this);
  }
 }
}
