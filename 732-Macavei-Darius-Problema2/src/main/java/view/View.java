package main.java.view;

import main.java.controller.ProductControllerInterface;
import main.java.controller.OrderControllerInterface;
import main.java.model.Order;
import main.java.model.Product;

import java.util.*;


public class View {
    private OrderControllerInterface orderController;
    private ProductControllerInterface productController;

    public View(OrderControllerInterface orderController, ProductControllerInterface productController) {
        this.orderController = orderController;
        this.productController = productController;

        productController.addProduct(0, "Mar", 2);
        productController.addProduct(1, "Para", 5);

        orderController.addOrder(0, "2 Main Street", new ArrayList<>());
        orderController.addOrder(1, "3 Cluj Napoca", new ArrayList<>());

        orderController.addProductToOrder(0, 0);
        orderController.addProductToOrder(0, 1);
        orderController.addProductToOrder(1, 0);
    }


    public void run() {
        Scanner scanner = new Scanner(System.in);

        loop:
        while (true) {
            System.out.println("""
                     
                     0. Exit Program \r
                     1. Show all Orders \r
                     2. Show all Products \r
                     3. Add a Order \r
                     4. Add an Product \r
                     5. Remove a Order \r
                     6. Remove an Product \r
                     7. Update a Order \r
                     8. Update an Product \r
                     9. Add Product to Order \r
                     10. Get Orders sorted by total price \r
                     11. Get Orders that contain a product\r
                    """);
            System.out.println("Enter input: ");
            int variant = scanner.nextInt();
            System.out.println("You've entered: " + variant);
            switch (variant) {
                case 0:
                    break loop;
                case 1:
                    showOrders();
                    break;
                case 2:
                    showProducts();
                    break;
                case 3:
                    addOrder();
                    break;
                case 4:
                    addProduct();
                    break;
                case 5:
                    deleteOrder();
                    break;
                case 6:
                    deleteProduct();
                    break;
                case 7:
                    updateOrder();
                    break;
                case 8:
                    updateProduct();
                    break;
                case 9:
                    addProductToOrder();
                    break;
                case 10:
                    getSortedOrders();
                    break;
                case 11:
                    getFilteredOrders();
                    break;
            }

        }
    }

    private void showOrders() {
        System.out.println(orderController.getAll());
    }

    private void addOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You will need to write a few things that represent Order attributes.");
        System.out.println("Enter Order id:");
        try {
            int id = scanner.nextInt();
            System.out.println("Enter Order address:");
            scanner.nextLine(); //throw away the \n not consumed by nextInt()
            String address = scanner.nextLine();

            orderController.addOrder(id, address, new ArrayList<>());
        } catch (Exception e) {
            throw e;
        }
    }

    private void deleteOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order id:");
        int id = scanner.nextInt();
        orderController.deleteOrder(id);
    }

    private void updateOrder() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("You will need to write a few things that represent Order attributes.");
            System.out.println("Enter Order id:");
            int id = scanner.nextInt();
            System.out.println("Enter Order address:");
            scanner.nextLine(); //throw away the \n not consumed by nextInt()
            String address = scanner.nextLine();

            orderController.updateOrder(id, address, new ArrayList<>());
        } catch (Exception e) {
            throw e;
        }
    }

    private void showProducts() {
        System.out.println(productController.getAll());
    }

    private void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You will need to write a few things that represent Product attributes.");
        System.out.println("Enter Product id:");
        try {
            int id = scanner.nextInt();
            System.out.println("Enter Product name:");
            scanner.nextLine(); //throw away the \n not consumed by nextInt()
            String name = scanner.nextLine();
            System.out.println("Enter Product's price:");
            Integer price = scanner.nextInt();

            productController.addProduct(id, name, price);
        } catch (Exception e) {
            throw e;
        }
    }

    private void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Product id:");
        int id = scanner.nextInt();
        productController.deleteProduct(id);
    }

    private void updateProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("You will need to write a few things that represent Product attributes.");
        System.out.println("Enter Product id:");
        try {
            int id = scanner.nextInt();
            System.out.println("Enter Product name:");
            scanner.nextLine(); //throw away the \n not consumed by nextInt()
            String name = scanner.nextLine();
            System.out.println("Enter Product's price:");
            Integer price = scanner.nextInt();

            productController.updateProduct(id, name, price);
        } catch (Exception e) {
            throw e;
        }
    }

    private void addProductToOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Order id:");
        try {
            int orderId = scanner.nextInt();
            System.out.println("Enter Product id:");
            int productId = scanner.nextInt();
            orderController.addProductToOrder(orderId, productId);
        } catch (Exception e) {
            throw e;
        }
    }

    private void getSortedOrders(){
        List<Order> sortedOrders = orderController.sortByPrice();
        sortedOrders.forEach(order -> System.out.println(order + "\n"));
    }

    private void getFilteredOrders(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id:");
        try {
            int product = scanner.nextInt();
            List<Order> filteredOrders = orderController.filterByProduct(product);
            filteredOrders.forEach(order -> System.out.println(order + "\n"));
        } catch (Exception e) {
            throw e;
        }
    }
}
