package main.java.main;

import main.java.controller.ProductController;
import main.java.controller.ProductControllerInterface;
import main.java.controller.OrderController;
import main.java.controller.OrderControllerInterface;
import main.java.view.View;

public class Main {
    public static void main(String[] args) {

        ProductControllerInterface productController = new ProductController();
        OrderControllerInterface orderController = new OrderController(productController);
        View view = new View(orderController, productController);
        view.run();
    }
}
