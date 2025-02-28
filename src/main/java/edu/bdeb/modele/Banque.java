package edu.bdeb.modele;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Banque")

public class Banque {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;
    private double tauxAssuranceAnnuel;
    private double tauxInteretAnnuel;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "Banque_Produit",
    joinColumns=@JoinColumn(name="banque_id"),
    inverseJoinColumns = @JoinColumn(name="produit_id"))

    private List<Produit> produits;  // Liste des produits associés à cette banque

    // Constructor
    public Banque(int id, String nom, double tauxAssuranceAnnuel, double tauxInteretAnnuel) {
        this.id = id;
        this.nom = nom;
        this.tauxAssuranceAnnuel = tauxAssuranceAnnuel;
        this.tauxInteretAnnuel = tauxInteretAnnuel;
        this.produits = new ArrayList<Produit>();
    }

    public Banque() {

    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTauxAssuranceAnnuel() {
        return tauxAssuranceAnnuel;
    }

    public void setTauxAssuranceAnnuel(float tauxAssuranceAnnuel) {
        this.tauxAssuranceAnnuel = tauxAssuranceAnnuel;
    }

    public double getTauxInteretAnnuel() {
        return tauxInteretAnnuel;
    }

    public void setTauxInteretAnnuel(float tauxInteretAnnuel) {
        this.tauxInteretAnnuel = tauxInteretAnnuel;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

      // toString method
    @Override
    public String toString() {
        return String.format(
            "Banque {\n" +
            "    id = %d,\n" +
            "    nom = '%s',\n" +
            "    tauxAssuranceAnnuel = %.2f,\n" +
            "    tauxInteretAnnuel = %.2f,\n" +

            "}",
            this.id, this.nom, this.tauxAssuranceAnnuel, this.tauxInteretAnnuel
        );
    }
}



