package igl.controlStock.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity @Setter @Getter
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idSale;
    private LocalDate dateSale;
    private Double price;
    @ManyToMany
    private List<Product> listProduct;
    @ManyToOne
    @JoinColumn(name="idSale",insertable = false, updatable = false)
    //@Column(insertable=false, updatable=false)
    private Client client;

    public Sale() {
    }

    public Sale(Long idSale, LocalDate dateSale, Double price, List<Product> listProduct, Client client) {
        this.idSale = idSale;
        this.dateSale = dateSale;
        this.price = price;
        this.listProduct = listProduct;
        this.client = client;
    }
}
