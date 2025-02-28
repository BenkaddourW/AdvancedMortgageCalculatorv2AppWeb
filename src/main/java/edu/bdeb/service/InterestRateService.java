package edu.bdeb.service;

import edu.bdeb.dal.IBanqueDAO;
import edu.bdeb.modele.Banque;

import java.util.List;

public class InterestRateService {
IBanqueDAO banqueDAO = null;

    public InterestRateService(IBanqueDAO banqueDAO) {
        this.banqueDAO = banqueDAO;
    }

public double trouverTauxParBanque(String nom) {
    double taux = this.banqueDAO.trouverTauxParBanque(nom);



    return taux;
}


    public Banque trouverTauxDInteretLePlusBas() {


        return this.banqueDAO.trouverTauxInteretPlusBas();
    }


    public List<Banque> trouverToutBanqueParType(String productType)
    {
      List<Banque> banque= banqueDAO.trouverToutBanqueParType(productType);

    return banque;
    }



}
