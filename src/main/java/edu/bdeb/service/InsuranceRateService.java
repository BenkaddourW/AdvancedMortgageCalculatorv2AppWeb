package edu.bdeb.service;

import edu.bdeb.dal.IBanqueDAO;
import edu.bdeb.modele.Banque;

import java.util.ArrayList;
import java.util.List;

public class InsuranceRateService {

    IBanqueDAO banqueDAO = null;

    public InsuranceRateService(IBanqueDAO banqueDAO) {
        this.banqueDAO = banqueDAO;
    }

    public double CalculerTauxAssurance(double montantPret, int nombrePaiements, double tauxBanque) {

    // Utiliser le taux de base de la banque
    double tauxDeBase = tauxBanque;

    // Ajuster le taux en fonction du montant du prêt

    if (montantPret > 100000 && montantPret <= 300000) {
        tauxDeBase += 0.1;
    } else if (montantPret > 300000) {
        tauxDeBase += 0.2;
    }

    // Formule personnalisée
    double tauxPersonnalise = tauxDeBase + (0.01 * nombrePaiements);

    return tauxPersonnalise;
}
public List<String> calculerTauxPourChaqueBanque(double montantPret, int nombrePaiements) {
    // Récupérer la liste des banques
    List<Banque> banques = banqueDAO.trouverToutBanque();

    // Liste pour stocker les résultats
    List<String> resultats = new ArrayList<>();

    // Parcourir chaque banque
    for (Banque banque : banques) {
        double tauxPersonnalise = CalculerTauxAssurance(montantPret, nombrePaiements, banque.getTauxAssuranceAnnuel());

        String resultat = "Banque : " + banque.getNom() + ", taux d’assurance applicable : " + tauxPersonnalise;

        resultats.add(resultat);
    }

    return resultats;
}

public void afficherTauxParBanque(double montantPret, int nombrePaiements) {
    List<String> resultats = calculerTauxPourChaqueBanque(montantPret, nombrePaiements);

    // Afficher les résultats
    for (String resultat : resultats) {
        System.out.println(resultat);
    }
}

}
