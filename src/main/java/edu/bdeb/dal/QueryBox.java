package edu.bdeb.dal;

public class QueryBox {

        public static final String TROUVER_TAUX_PAR_BANQUE =
                "SELECT * " +
                "FROM Banque b " +
                "WHERE b.nom = ? ";

        public static final String TROUVER_TAUX_PAR_BANQUES =
                "SELECT b " +
                "FROM Banque b " +
                "WHERE b.nom = :nom";

        public static final String TROUVER_TAUX_INTERET_PLUS_BAS =
                "SELECT * " +
                "FROM Banque b " +
                "WHERE tauxInteretAnnuel = (SELECT MIN(tauxInteretAnnuel) FROM Banque) ";

        public static final String TROUVER_TAUX_INTERETS_PLUS_BAS =
                "SELECT b " +
                "FROM Banque b " +
                "WHERE tauxInteretAnnuel = (SELECT MIN(tauxInteretAnnuel) FROM Banque) ";

        public static final String TROUVER_BANQUE_PAR_TYPE_PRODUIT =
        "SELECT DISTINCT b.id, b.nom, b.tauxAssuranceAnnuel, b.tauxInteretAnnuel " +
        "FROM Banque b " +
        "JOIN Banque_Produit bp ON b.id = bp.banque_id " +
        "JOIN Produit p ON bp.produit_id = p.id " +
        "WHERE p.type = ? ";

        public static final String TROUVER_BANQUES_PAR_TYPE_PRODUIT =
            "SELECT b FROM Banque b JOIN b.produits p WHERE p.type = :type";

        public static final String TROUVER_TOUT_BANQUE =
                "SELECT * " +
                "FROM Banque b " ;

        public static final String TROUVER_TOUT_BANQUES =
                "SELECT b " +
                "FROM Banque b " ;



}
