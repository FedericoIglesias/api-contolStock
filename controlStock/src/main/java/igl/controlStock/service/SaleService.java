package igl.controlStock.service;

import igl.controlStock.model.Sale;
import igl.controlStock.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements ISaleService{

    @Autowired
    ISaleRepository repoSale;

    @Override
    public List<Sale> getListSale() {

        return repoSale.findAll();
    }

    @Override
    public Sale getSale(Long id) {

        return repoSale.findById(id).orElse(null);
    }

    @Override
    public void createSale(Sale sale) {
        repoSale.save(sale);
    }

    @Override
    public void deleteSale(Long id) {
        repoSale.deleteById(id);
    }

    @Override
    public void editSale(Sale sale) {
        repoSale.save(sale);
    }
}
