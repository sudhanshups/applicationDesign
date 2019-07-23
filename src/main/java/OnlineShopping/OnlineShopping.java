package OnlineShopping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


class Account {
    private String id;
    private String password;
    private String name;
    //    private Address address;
    private String email;
    private String phone;

    public boolean addProduct(Product product) {
        return true;
    }

    public boolean addProductReview(ProductReview review) {
        return true;
    }

    //private AccountStatus status;
    boolean resetPassword() {
        return true;//should be implemented by different actors
    }
}

abstract class Customer {
    private ShoppingCart cart;
    private Order order;

    public ShoppingCart getShoppingCart() {
        return null;
    }

    public boolean addItemToCart(Item item) {
        return true;
    }

    public boolean removeItemFromCart(Item item) {
        return true;
    }

    boolean cancelOrder(Integer orderId) {
        return true;
    }

}

class Guest extends Customer {
    public boolean registerAccount() {
        return true;
    }
}

class Member extends Customer {
    Account account;
//  Order placeOrder(ShoppingCart cart, Address address) {
//      return new Order();
//  }

    Order placeOrder(Order order) {
        return null;
    }
}

class Address {

}


enum OrderStatus {
    PLACED, SHIPPED, CANCELLED;
}

enum Rating { //store count per rating
    One, Two, Three, Four, Five;
}

class ProductReview {
    private int rating;
    private String review;

    private Member reviewer;
}

interface search {
    List<Product> searchByName(String name);

    List<Product> searchByCategory(String name);
}

class Catalog implements search {
    Map<String, List<Product>> nameToProductMap;
    Map<String, List<Product>> categoryToProductMap;

    @Override
    public List<Product> searchByName(String name) {
        return nameToProductMap.get(name);
    }

    @Override
    public List<Product> searchByCategory(String name) {
        return categoryToProductMap.get(name);
    }
}

class Category {
    String name;
    String description;
}

class Product {
    //everything shoub be private and accessed by getters and setters
    String id;
    String name;
    double price;
    Category category;
    ProductReview review;
    Rating rating;

    int availableItemCount;
    Account seller;

//    public int getAvailableCount();
//    public boolean updatePrice(double newPrice);

}

class Item {
    private String productID;
    private int quantity;
    private double price;

    public boolean updateQuantity(int quantity) {
        return true;
    }
}

class ShoppingCart {
    private List<Item> items;

    public boolean addItem(Item item){return true;}

    public boolean removeItem(Item item){return true;}

    public boolean updateItemQuantity(Item item, int quantity){return true;}

    public List<Item> getItems(){return items;}

    public boolean checkout(){return true;}
}


class Order {
    Integer id;
    List<Product> products;
    String address;
    OrderStatus orderStatus;
}

abstract class Notification {
    private int notificationId;
    private Date createdOn;
    private String content;

    public abstract boolean sendNotification(Account account, String content);
}