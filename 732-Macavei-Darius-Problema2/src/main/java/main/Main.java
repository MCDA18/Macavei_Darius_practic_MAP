package main;

import controller.ProductController;
import controller.ProductControllerInterface;
import controller.OrderController;
import controller.OrderControllerInterface;
import view.View;

public class Main {
    public static void main(String[] args) {

        ProductControllerInterface productController = (ProductControllerInterface) new ProductController();
        OrderControllerInterface orderController = new OrderController(productController);
        View view = new View(orderController, productController);
        view.run();
    }
}
