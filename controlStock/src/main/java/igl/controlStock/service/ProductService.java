package igl.controlStock.service;

import igl.controlStock.model.Product;
import igl.controlStock.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    IProductRepository repoProduct;

    @Override
    public List<Product> getListProduct() {

        return repoProduct.findAll();
    }

    @Override
    public Product getProduct(Long id) {

        return repoProduct.findById(id).orElse(null);
    }

    @Override
    public void createProduct(Product product) {
        repoProduct.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        repoProduct.deleteById(id);
    }

    @Override
    public void editProduct(Product product) {
        repoProduct.save(product);
    }
}
