package igl.controlStock.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter @Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProduct;
    private String name;
    private String brand;
    private Double cost;
    private Integer stock;
    @ManyToMany (mappedBy = "listProduct")
    private List<Sale> listSale;

    public Product() {
    }

    public Product(Long idProduct, String name, String brand, Double cost, Integer stock) {
        this.idProduct = idProduct;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.stock = stock;
    }
}
