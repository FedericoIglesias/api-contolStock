package igl.controlStock.service;

import igl.controlStock.model.Sale;

import java.util.List;

public interface ISaleService {

    List<Sale> getListSale();

    Sale getSale(Long id);

    void createSale(Sale sale);

    void deleteSale(Long id);

    void editSale(Sale sale);
}
