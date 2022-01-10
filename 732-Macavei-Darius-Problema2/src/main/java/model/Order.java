package model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Order {
    private Integer id;
    private String address;
    private List<Product> productList;

    public Order(Integer id, String address, List<Product> productList) {
        this.id = id;
        this.address = address;
        this.productList = productList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public int getTotalPrice() {
        return productList.stream().map(Product::getPrice).reduce(0, Integer::sum);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", productList=" + productList +
                '}';
    }
}
