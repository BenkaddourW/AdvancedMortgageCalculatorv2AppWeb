package edu.bdeb.dal;

import edu.bdeb.dl.DBConnector;
import edu.bdeb.modele.Banque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InDBBanqueDAO implements IBanqueDAO {
 DBConnector dbConnector;


    public InDBBanqueDAO() {

        this.dbConnector = DBConnector.getInstance();
    }

    @Override
    public double trouverTauxParBanque(String nom) {

        Banque banque=null;
        Connection conn = this.dbConnector.getConnection();
        String sql = QueryBox.TROUVER_TAUX_PAR_BANQUE;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nom);
            ResultSet cursor = pst.executeQuery();
            if(cursor.next()) {
                return cursor.getDouble("tauxInteretAnnuel");

            } else {
            return -1;
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public Banque trouverTauxInteretPlusBas() {
        Banque banque=null;
        Connection conn = this.dbConnector.getConnection();
        String sql = QueryBox.TROUVER_TAUX_INTERET_PLUS_BAS;
        try {
            Statement st = conn.createStatement();
            ResultSet cursor = st.executeQuery(sql);
            if(cursor.next()) {
                int id = cursor.getInt("id");
                String nom =cursor.getString("nom");
                double tauxAssuranceAnnuel=cursor.getDouble("tauxAssuranceAnnuel");
                 double tauxInteretAnnuel=cursor.getDouble("tauxInteretAnnuel");
                banque= new Banque(id,nom,tauxAssuranceAnnuel,tauxInteretAnnuel);

                return banque;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

 @Override
public List<Banque> trouverToutBanqueParType(String typeProduit) {
    List<Banque> banques = new ArrayList<>();
    Connection conn = this.dbConnector.getConnection();
    String sql = QueryBox.TROUVER_BANQUE_PAR_TYPE_PRODUIT; // Requête SQL pour trouver les banques par type de produit

    try (PreparedStatement pst = conn.prepareStatement(sql)) {
        pst.setString(1, typeProduit); // Associe le type du produit à la requête SQL
        try (ResultSet cursor = pst.executeQuery()) {
            while (cursor.next()) {
                // Récupération des données de la banque depuis le résultat SQL
                int id = cursor.getInt("id");
                String nom = cursor.getString("nom");
                double tauxAssuranceAnnuel = cursor.getDouble("tauxAssuranceAnnuel");
                double tauxInteretAnnuel = cursor.getDouble("tauxInteretAnnuel");

                // Création de l'objet Banque
                Banque banque = new Banque(id, nom, tauxInteretAnnuel, tauxAssuranceAnnuel);

                // Charge les produits associés à cette banque (facultatif selon la logique)
//                List<Produit> produits = this.produitDAO.trouverProduitsParBanque(id); // Trouve les produits de la banque
//                banque.setProduits(produits);

                // Ajout de la banque à la liste
                banques.add(banque);
            }
        }
    } catch (SQLException e) {
        throw new RuntimeException("Erreur lors de la récupération des banques pour le type de produit : " + typeProduit, e);
    }

    return banques; // Retourne la liste des banques
}


     @Override
    public double trouverTauxAssuranceParBanque(String nom) {

        Banque banque=null;
        Connection conn = this.dbConnector.getConnection();
        String sql = QueryBox.TROUVER_TAUX_PAR_BANQUE;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, nom);
            ResultSet cursor = pst.executeQuery();
            if(cursor.next()) {
                return cursor.getDouble("tauxAssuranceAnnuel");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //conn.close();

        return 0;
    }

    @Override
    public List<Banque> trouverToutBanque() {

    List<Banque> banques=new ArrayList<>();
        Connection conn = this.dbConnector.getConnection();
        String sql = QueryBox.TROUVER_TOUT_BANQUE;
        try {
            Statement st = conn.createStatement();
            ResultSet cursor = st.executeQuery(sql);
            while(cursor.next()) {

                int id = cursor.getInt("id");
                String nom =cursor.getString("nom");
                double tauxAssuranceAnnuel=cursor.getDouble("tauxAssuranceAnnuel");
                double tauxInteretAnnuel=cursor.getDouble("tauxInteretAnnuel");
               Banque banque= new Banque(id,nom,tauxAssuranceAnnuel,tauxInteretAnnuel);
               banques.add(banque);

            }
            return banques;
            } catch (SQLException e) {
            throw new RuntimeException("Error retrieving banque from the database", e);
        }

    }
}
