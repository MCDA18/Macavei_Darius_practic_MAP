package controller;

import model.Product;
import model.Order;

import java.util.*;
import java.util.stream.Collectors;

public class OrderController implements OrderControllerInterface {
    private final List<Order> orderList;
    private ProductControllerInterface productController;

    public OrderController(ProductControllerInterface productController) {
        this.orderList = new ArrayList<>();
        this.productController = productController;
    }

    @Override
    public Order addOrder(Integer id, String address, List<Product> productList) {
        Order tempOrder = new Order(id, address, productList);
        orderList.add(tempOrder);
        return tempOrder;
    }

    @Override
    public void deleteOrder(Integer id) {
        orderList.removeIf(order -> Objects.equals(order.getId(), id));
    }

    @Override
    public void updateOrder(Integer id, String address, List<Product> productList) {
        for (Order order :
                orderList) {
            if (Objects.equals(order.getId(), id)) {
                order.setAddress(address);
                order.setProductList(productList);
            }
        }
    }

    @Override
    public void addProductToOrder(Integer orderId, Integer productId) {
        orderList.stream()
                .filter(order -> Objects.equals(order.getId(), orderId))
                .map(order -> {
                    List<Product> productList = order.getProductList();
                    if (productList == null) {
                        productList = new ArrayList<>();
                    }
                    productList.add(productController.findById(productId));
                    order.setProductList(productList);
                    return order;
                }).collect(Collectors.toList());
    }

    @Override
    public List<Order> getAll() {
        return orderList;
    }

    @Override
    public List<Order> sortByPrice() {
        return orderList.stream().sorted(Comparator.comparingInt(Order::getTotalPrice)).toList();
    }

    public List<Order> filterByProduct(Integer productId) {
        return orderList.stream().filter((Order) -> Order.getProductList().stream().anyMatch((Product) -> Product.getId().equals(productId))).toList();
    }

    @Override
    public Order findById(Integer id) {
        for (Order order :
                orderList) {
            if(Objects.equals(order.getId(), id))
                return order;
        }
        return null;

    }


}
