package edu.bdeb.dal;

import edu.bdeb.dl.AppPersistenceUnit;
import edu.bdeb.modele.Banque;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
//import javax.persistence.EntityManager;

public class InDBBanqueDAOJPA implements IBanqueDAO{

    EntityManager em;

    public InDBBanqueDAOJPA() {
        PersistenceUnitInfo AppPUInfo = new AppPersistenceUnit();
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(AppPUInfo, new HashMap<>());
        this.em = emf.createEntityManager();
    }


@Override
public double trouverTauxParBanque(String nom) {
    try {

        Banque banque = this.em.createQuery(QueryBox.TROUVER_TAUX_PAR_BANQUES, Banque.class)
                               .setParameter("nom", nom)
                               .getSingleResult();
        return banque.getTauxInteretAnnuel();
    } catch (NoResultException e) {

        return -1;
    }
}

    @Override
    public Banque trouverTauxInteretPlusBas() {
        try {
        Banque banque = this.em.createQuery(QueryBox.TROUVER_TAUX_INTERETS_PLUS_BAS, Banque.class)
                .getSingleResult();
        em.close();
    return banque;
    } catch (NoResultException e) {

            return null;
        }
    }
@Override
public List<Banque> trouverToutBanqueParType(String type) {
    try {
        return this.em.createQuery(QueryBox.TROUVER_BANQUES_PAR_TYPE_PRODUIT, Banque.class)
                      .setParameter("type", type)
                      .getResultList();
    } catch (NoResultException e) {
        return Collections.emptyList(); // Renvoie une liste vide si aucun résultat n'est trouvé
    } catch (Exception e) {
        e.printStackTrace();
        return Collections.emptyList(); // Évitez de renvoyer `null` pour éviter les NullPointerException
    }
}


    @Override
    public double trouverTauxAssuranceParBanque(String nom) {
         try {

        Banque banque = this.em.createQuery(QueryBox.TROUVER_TAUX_PAR_BANQUE, Banque.class)
                               .setParameter(2, nom)
                               .getSingleResult();
        return banque.getTauxAssuranceAnnuel();
    } catch (NoResultException e) {

        return -1;
    }
}


    @Override
    public List<Banque> trouverToutBanque() {
     try {
        List<Banque> banques = this.em.createQuery(QueryBox.TROUVER_TOUT_BANQUES, Banque.class)
                                     .getResultList();
        return banques;
    } catch (NoResultException e) {

        return Collections.emptyList();
    } catch (Exception e) {

        e.printStackTrace();
        return null;
    }
}
}
