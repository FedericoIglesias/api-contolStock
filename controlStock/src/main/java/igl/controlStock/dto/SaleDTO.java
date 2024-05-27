package igl.controlStock.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaleDTO {

    private Long idSaleDTO;
    private Double price;
    private Double stock;
    private String name;
    private String lastName;

    public SaleDTO() {
    }

    public SaleDTO(Long idSaleDTO, Double price, Double stock, String name, String lastName) {
        this.idSaleDTO = idSaleDTO;
        this.price = price;
        this.stock = stock;
        this.name = name;
        this.lastName = lastName;
    }
}

