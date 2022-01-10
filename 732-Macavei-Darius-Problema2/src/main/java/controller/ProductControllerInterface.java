package controller;

import model.Product;

import java.util.List;

public interface ProductControllerInterface {

    /**
     * Adds an Product
     * @param id Integer
     * @param name String
     * @param price Integer
     * @return Product
     */
    Product addProduct(Integer id, String name, Integer price);

    /**
     * Deletes an Product
     * @param id Integer
     */
    void deleteProduct(Integer id);

    /**
     * Updates an Product
     * @param id Integer
     * @param name String
     * @param price Integer
     */
    void updateProduct(Integer id, String name, Integer price);

    /**
     * Get all Products
     */
    List<Product> getAll();

    /**
     * Finds an Product by a specified id
     * @param id Integer
     * @return Product
     */
    Product findById(Integer id);
}
