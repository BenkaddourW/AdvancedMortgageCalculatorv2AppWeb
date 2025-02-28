package edu.bdeb.dl;

import edu.bdeb.modele.Banque;
import edu.bdeb.modele.Produit;

import java.util.*;

public class InMemoryDataStore {

    private List<Banque> banques;
    private List<Produit> produits;
    private Map<Integer, List<Integer>> banqueProduits; // Relation many-to-many
    private static InMemoryDataStore datastore = null;

    // Constructeur privé pour initialiser les données
    private InMemoryDataStore() {

        // Initialisation des banques
        this.banques = new ArrayList<>(Arrays.asList(
                new Banque(1, "Banque Nationale", 0.05, 1.65),
                new Banque(2, "BMO", 0.06, 4.94),
                new Banque(3, "Banque Royale du Canada", 0.07, 4.89),
                new Banque(4, "Desjardins", 0.04, 6.39)
        ));

        // Initialisation des produits
        this.produits = new ArrayList<>(Arrays.asList(
                new Produit(1, "Mortgage", "Prêt à taux fixe pour une durée de 1 an."),
                new Produit(2, "Mortgage", "Prêt à taux fixe pour une durée de 3 ans."),
                new Produit(3, "Mortgage", "Prêt à taux fixe pour une durée de 5 ans."),
                new Produit(4, "Insurance", "Assurance vie à taux fixe."),
                new Produit(5, "Insurance", "Assurance maladie pour famille."),
                new Produit(6, "Savings Account", "Compte d'épargne à intérêt élevé."),
                new Produit(7, "Savings Account", "Compte d'épargne avec carte de débit."),
                new Produit(8, "Checking Account", "Compte courant sans frais mensuels."),
                new Produit(9, "Checking Account", "Compte courant avec carte de crédit.")
        ));

        // Initialisation des relations many-to-many (banque -> produits)
        this.banqueProduits = new HashMap<>();
        banqueProduits.put(1, Arrays.asList(1, 2, 4, 8)); // Banque Nationale
        banqueProduits.put(2, Arrays.asList(2, 5, 9)); // BMO
        banqueProduits.put(3, Arrays.asList(3, 6)); // Banque Royale du Canada
        banqueProduits.put(4, Arrays.asList(3, 7)); // Desjardins
    }

    // Méthode pour obtenir l'instance unique du datastore
    public static InMemoryDataStore getInstance() {
        if (datastore == null) {
            datastore = new InMemoryDataStore();
        }
        return datastore;
    }

    // Getter pour la liste des banques
    public List<Banque> getBanques() {
        return banques;
    }

    // Getter pour la liste des produits
    public List<Produit> getProduits() {
        return produits;
    }
// Dans InMemoryDataStore
public Map<Integer, List<Integer>> getBanqueProduits() {
    return banqueProduits;
}


}
