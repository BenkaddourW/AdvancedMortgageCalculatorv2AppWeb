/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.bdeb.dl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe pour gérer la connexion à la base de données MySQL.
 *
 * @author benka
 */
public class DBConnector {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "user";

    private Connection connection = null;

    // Instance unique pour le pattern Singleton
    private static DBConnector instance = null;

    // Méthode pour obtenir l'instance unique de la classe
    public static DBConnector getInstance() {
        if (DBConnector.instance == null) {
            DBConnector.instance = new DBConnector();
        }
        return DBConnector.instance;
    }

    // Constructeur privé pour empêcher l'instanciation directe
    private DBConnector() {
        try {
            // Charger explicitement le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion
            this.connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connexion réussie à la base de données.");
        } catch (ClassNotFoundException e) {
            System.err.println("Pilote JDBC introuvable !");
            throw new RuntimeException("Pilote JDBC introuvable", e);
        } catch (SQLException e) {
            System.err.println("Erreur lors de la connexion à la base de données !");
            throw new RuntimeException("Erreur de connexion à la base de données", e);
        }
    }

    // Méthode pour obtenir la connexion
    public Connection getConnection() {
        return this.connection;
    }

    // Méthode pour fermer la connexion
    public void closeConnection() {
        if (this.connection != null) {
            try {
                this.connection.close();
                System.out.println("Connexion fermée avec succès.");
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture de la connexion !");
            }
        }
    }

    // Méthode principale pour tester la connexion
    public static void main(String[] args) {
        DBConnector connector = DBConnector.getInstance();
        Connection connection = connector.getConnection();

        if (connection != null) {
            System.out.println("Test : connexion établie avec succès.");
        } else {
            System.err.println("Test : échec de la connexion.");
        }

        // Fermer la connexion après utilisation
        connector.closeConnection();
    }
}


//package edu.bdeb.dl;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DBConnector {
//
//    private final String DB_HOST = "mysql-wafaa.alwaysdata.net:3306";
//    private final String DB_NAME = "wafaa_a10bd";
//    private final String DB_USER = "wafaa_a10user";
//    private final String DB_PASSWORD = "A10BdeB2024";
//    private final String DB_URL = "jdbc:mariadb://" + DB_HOST + "/" +DB_NAME;
//    // ConnectionString: jdbc:mariadb://mysql-bdebuser.alwaysdata.net:3306/bdebuser_a10bd
//    private Connection connection = null;
//
//    private static DBConnector instance = null;
//
//    public static DBConnector getInstance() {
//        if (DBConnector.instance == null)
//            DBConnector.instance = new DBConnector();
//        return DBConnector.instance;
//    }
//
//    private DBConnector() {
//        //load connection infos from properties file
//        try {
//            this.connection = DriverManager.getConnection(this.DB_URL, this.DB_USER, this.DB_PASSWORD);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public Connection getConnection() {
//        return this.connection;
//    }
//}
//
