package test.java.controller;

import main.java.controller.OrderController;
import main.java.controller.OrderControllerInterface;
import main.java.controller.ProductController;
import main.java.controller.ProductControllerInterface;
import main.java.model.Order;
import main.java.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {
    private OrderControllerInterface orderController;
    private ProductControllerInterface productController;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        productController = new ProductController();
        orderController = new OrderController(productController);

        productController.addProduct(0, "Mar", 2);
        productController.addProduct(1, "Para", 3);

        orderController.addOrder(0, "1 Main Street", new ArrayList<>());
        orderController.addOrder(1, "2 Cluj Napoca", new ArrayList<>());

        orderController.addProductToOrder(0, 0);
        orderController.addProductToOrder(0, 1);
        orderController.addProductToOrder(1, 0);
    }

    @org.junit.jupiter.api.Test
    void addProductToOrder() {
        orderController.addProductToOrder(1, 1);
        assertEquals(2, orderController.findById(1).getProductList().size());
    }

    @Test
    void getSortedOrders() {
        List<Order> orderList = orderController.sortByPrice();
        assertEquals(orderList.get(0).getId(), 1);
        assertEquals(orderList.get(1).getId(), 0);
    }

    @Test
    void getFilteredOrders() {
        List<Order> orderList = orderController.filterByProduct(1);
        assertEquals(orderList.get(0).getId(), 0);
        assertEquals(orderList.size(), 1);
    }
}