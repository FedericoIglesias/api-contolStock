package igl.controlStock.service;

import igl.controlStock.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getListProduct();

    Product getProduct(Long id);

    void createProduct(Product product);

    void deleteProduct(Long id);

    void editProduct(Product product);
}
