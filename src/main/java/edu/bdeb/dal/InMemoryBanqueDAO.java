package edu.bdeb.dal;

import edu.bdeb.dl.InMemoryDataStore;
import edu.bdeb.modele.Banque;
import edu.bdeb.modele.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InMemoryBanqueDAO implements IBanqueDAO {

    InMemoryDataStore datastore;

    public InMemoryBanqueDAO() {
        this.datastore = InMemoryDataStore.getInstance();

    }
@Override
    public double trouverTauxParBanque(String nom) {
        List<Banque> banques = this.datastore.getBanques();
        for (Banque banque : banques) {
            if (banque.getNom().equalsIgnoreCase(nom)) {
                return banque.getTauxInteretAnnuel();
            }
        }
        return -1;

    }


   @Override
public Banque trouverTauxInteretPlusBas() {
    List<Banque> banques = this.datastore.getBanques();

    if (banques == null || banques.isEmpty()) {
        throw new IllegalStateException("Aucune banque n'est disponible.");
    }

    Banque banqueAvecTauxLePlusBas = null;
    double tauxLePlusBas = Float.MAX_VALUE;

    for (Banque banque : banques) {
        double tauxInteret = banque.getTauxInteretAnnuel();
        if (tauxInteret < tauxLePlusBas) {
            tauxLePlusBas = tauxInteret;
            banqueAvecTauxLePlusBas = banque;
        }
    }

    return banqueAvecTauxLePlusBas;
}

@Override
public List<Banque> trouverToutBanqueParType(String type) {

    List<Banque> result = new ArrayList<>();
    Map<Integer, List<Integer>> banqueProduits = this.datastore.getBanqueProduits();

    for (Map.Entry<Integer, List<Integer>> entry : banqueProduits.entrySet()) {
        Integer idBanque = entry.getKey();
        List<Integer> idsProduits = entry.getValue();

        for (Integer idProduit : idsProduits) {
            Produit produit = this.datastore.getProduits().stream()
                                      .filter(p -> p.getId() == idProduit)
                                      .findFirst()
                                      .orElse(null);
            if (produit != null && produit.getType().equalsIgnoreCase(type)) {
                Banque banque = this.datastore.getBanques().stream()
                                       .filter(b -> b.getId() == idBanque)
                                       .findFirst()
                                       .orElse(null);
                if (banque != null && !result.contains(banque)) {
                    result.add(banque);
                }
                break;
            }
        }
    }

    return result;
}



    @Override
    public double trouverTauxAssuranceParBanque(String nom) {
        List<Banque> banques = this.datastore.getBanques();
        for (Banque banque : banques) {
            if (banque.getNom().equalsIgnoreCase(nom)) {
                return banque.getTauxAssuranceAnnuel();
            }
        }
        return 0;
    }

    @Override
    public List<Banque> trouverToutBanque() {
         List<Banque> banques = this.datastore.getBanques();
        return banques;
    }
}
