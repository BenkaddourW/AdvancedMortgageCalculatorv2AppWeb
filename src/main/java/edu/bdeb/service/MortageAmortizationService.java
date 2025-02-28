package edu.bdeb.service;

import edu.bdeb.dal.IBanqueDAO;
import edu.bdeb.modele.Banque;
import java.util.ArrayList;
import java.util.List;

public class MortageAmortizationService {
    IBanqueDAO banqueDAO = null;

    public MortageAmortizationService(IBanqueDAO banqueDAO) {
        this.banqueDAO = banqueDAO;
    }

   public List<String> MeilleurOffre(double prixMaison, double apportInitial, int nombreAnneesPaiements) {
       List<String> resultats = new ArrayList<>();
    // Trouver la banque avec le taux d'intérêt le plus bas
    Banque banque = this.banqueDAO.trouverTauxInteretPlusBas();
    double montantPret = prixMaison - apportInitial;

    // Calcul du taux d'assurance personnalisé
    InsuranceRateService insuranceService = new InsuranceRateService(this.banqueDAO);
    double tauxAssuranceAnnuel = banque.getTauxAssuranceAnnuel();
    double tauxAssurancePersonnalise = insuranceService.CalculerTauxAssurance(montantPret, nombreAnneesPaiements, tauxAssuranceAnnuel);

    // Conversion des taux annuels en taux mensuels
    double tauxInteretMensuel = banque.getTauxInteretAnnuel() * 0.01 / 12;
    double tauxAssuranceMensuel = tauxAssurancePersonnalise * 0.001 / 12;

    // Calcul du nombre total de paiements (en mois)
    int nombreTotalPaiements = nombreAnneesPaiements * 12;

    // Calcul du paiement mensuel
    double tauxMensuelTotal = tauxInteretMensuel + tauxAssuranceMensuel;
    double facteurMensualite = Math.pow(1 + tauxMensuelTotal, nombreTotalPaiements);
    double paiementMensuel = (montantPret * tauxMensuelTotal * facteurMensualite) / (facteurMensualite - 1);

    // Calcul du coût total et des intérêts payés
    double montantTotalVerse = paiementMensuel * nombreTotalPaiements;
    double totalInteretsPayes = montantTotalVerse - montantPret;

    resultats.add("Montant du versement mensuel : " + String.format("%.2f", paiementMensuel) + " $");
    resultats.add("Total des intérêts payés : " + String.format("%.2f", totalInteretsPayes) + " $");

    return resultats;
}

}
