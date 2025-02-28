package edu.bdeb.modele;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String description;

    @ManyToMany(mappedBy="produits", fetch= FetchType.EAGER)

    private List<Banque> banques;

    public Produit(int id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.banques = new ArrayList<Banque>();
    }

    public Produit() {

    }

    public List<Banque> getBanques() {
        return banques;
    }

    public void setBanques(List<Banque> banques) {
        this.banques = banques;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

@Override
public String toString() {
    return String.format(
        "Produit {\n" +
        "    id = %d,\n" +
        "    type = '%s',\n" +
        "    description = '%s'\n" +
        "}",
        this.id, this.type, this.description
    );
}

}
