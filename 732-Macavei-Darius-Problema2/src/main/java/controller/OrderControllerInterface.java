package main.java.controller;

import main.java.model.Product;
import main.java.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderControllerInterface {

    /**
     * Adds a new Order
     * @param address String
     * @param productList List of products
     * @return Order
     */
    Order addOrder(Integer id, String address, List<Product> productList);

    /**
     * Deletes a Order by id
     * @param id Integer
     */
    void deleteOrder(Integer id);

    /**
     * Update a Order
     * @param id Integer
     * @param address String
     * @param productList List of products
     */
    void updateOrder(Integer id, String address, List<Product> productList);

    /**
     * Gets all Orders
     * @return List<Order>
     */
    List<Order> getAll();

    /**
     * Sort all the orders by the total price of each order
     */
    List<Order> sortByPrice();

    /**
     * Gets the orders that contain a product
     */
    List<Order> filterByProduct(Integer productId);

    /**
     * Add a Product to an Order
     */
    void addProductToOrder(Integer orderId, Integer productId);

    /**
     * Find a Order by a specified Id
     * @param id Integer
     * @return Order
     */
    Order findById(Integer id);
}
