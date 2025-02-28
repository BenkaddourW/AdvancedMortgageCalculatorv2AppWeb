package edu.bdeb.dal;

import edu.bdeb.modele.Banque;

import java.util.List;

public interface IBanqueDAO {
    public double trouverTauxParBanque(String nom);
    public Banque trouverTauxInteretPlusBas();
    public List<Banque> trouverToutBanqueParType(String type);
    public double trouverTauxAssuranceParBanque(String nom) ;
     public List<Banque> trouverToutBanque();
}
