package igl.controlStock.controller;

import igl.controlStock.model.Product;
import igl.controlStock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService serviProducts;


    @PostMapping("/products/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        serviProducts.createProduct(product);
        return new ResponseEntity<>("Success to create Product", HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getListProducts() {
        return new ResponseEntity<>(serviProducts.getListProduct(), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        return new ResponseEntity<>(serviProducts.getProduct(id), HttpStatus.OK);
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<String> deleteProducts(@PathVariable Long id) {
        serviProducts.deleteProduct(id);
        return new ResponseEntity<>("Success to delete Product", HttpStatus.OK);
    }

    @PutMapping("/products/edit/{id}")
    public ResponseEntity<Product> editProduct(@RequestBody Product product, @PathVariable Long id) {
        serviProducts.editProduct(product);
        return new ResponseEntity<>(serviProducts.getProduct(id), HttpStatus.OK);
    }

    @GetMapping ("/products/stock_outed") //return(if sotck <= 5)
    public ResponseEntity<List<Product>> getListStockOuted(){
        List listProductsOuted = new ArrayList();
        for(Product product : serviProducts.getListProduct()){
            if(product.getStock() <= 5){
                listProductsOuted.add(product);
            }
        }

        return new ResponseEntity<>(listProductsOuted,HttpStatus.OK);
    }
}
