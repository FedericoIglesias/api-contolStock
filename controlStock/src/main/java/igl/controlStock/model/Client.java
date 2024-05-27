package igl.controlStock.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter @Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idClient;
    private String name;
    private String lastName;
    private String dni;
    @OneToMany(mappedBy = "client")
    private List<Sale> listSale;

    public Client() {
    }

    public Client(Long idClient, String name, String lastName, String dni, List<Sale> listSale) {
        this.idClient = idClient;
        this.name = name;
        this.lastName = lastName;
        this.dni = dni;
        this.listSale = listSale;
    }
}
