package igl.controlStock.controller;

import igl.controlStock.dto.SaleDTO;
import igl.controlStock.model.Product;
import igl.controlStock.model.Sale;
import igl.controlStock.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SaleController {

    @Autowired
    SaleService serviceSale;

    @GetMapping("/sales")
    public ResponseEntity<List<Sale>>  getListSales(){
        return  new ResponseEntity<>(serviceSale.getListSale(), HttpStatus.OK
        );
    }

    @GetMapping("sales/{id}")
    public ResponseEntity<Sale> getSale(@PathVariable Long id){
        return  new ResponseEntity<>(serviceSale.getSale(id),HttpStatus.OK);
    }

    @PostMapping("/sales/create")
    public ResponseEntity<String> createSale(@RequestBody Sale sale){

        serviceSale.createSale(sale);

        return  new ResponseEntity<>("Success to creating sale", HttpStatus.OK);
    }

    @DeleteMapping ("/sales/delete/{id}")
    public ResponseEntity<String> deleteSale(@PathVariable Long id){
        serviceSale.deleteSale(id);
        return  new ResponseEntity<>("Success to delete sale", HttpStatus.OK);
    }

    @PutMapping ("/sales/edit/{id}")
    public ResponseEntity<Sale> editSale(@RequestBody Sale sale, @PathVariable Long id){
        serviceSale.editSale(sale);
        return new ResponseEntity<>(serviceSale.getSale(id),HttpStatus.OK);
    }

    @GetMapping ("/sales/products/{id}") //return products from sale
    public ResponseEntity<List<Product>> getSaleProducts(@PathVariable Long id){
        return  new ResponseEntity<>(serviceSale.getSale(id).getListProduct(),HttpStatus.OK);
    }
    @GetMapping ("/sales/{date}") //value & amount of sale of date
    public ResponseEntity<String> getSaleDate (@PathVariable LocalDate date){
        Double value = 0.0;
        Integer amount = 0;
        for ( Sale sale  : serviceSale.getListSale()){
            if(sale.getDateSale() == date){
                value = value + sale.getPrice();
                ++amount;
            }
        }
        String msg = "Value: " + value.toString() + "- Amount: " + amount.toString();

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
    @GetMapping ("/sales/elderly_sale")
    public ResponseEntity<SaleDTO> getElderlySale(){
        Sale elderlySale = null;
        for(Sale sale :serviceSale.getListSale()){
            if(elderlySale == null){
                elderlySale = sale;
            } else if (sale.getPrice() > elderlySale.getPrice()) {
                elderlySale = sale;
            }
        }
        Double stock = 0.0;

        for (Product product: elderlySale.getListProduct()) {
            stock = stock + product.getCost();
        }

        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setIdSaleDTO(elderlySale.getIdSale());
        saleDTO.setName(elderlySale.getClient().getName());
        saleDTO.setStock(stock);
        saleDTO.setLastName(elderlySale.getClient().getLastName());
        saleDTO.setPrice(elderlySale.getPrice());


        return  new ResponseEntity<>(saleDTO, HttpStatus.OK);
    }

}
