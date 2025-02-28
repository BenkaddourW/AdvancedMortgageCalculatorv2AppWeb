Description :
Le projet AdvancedMortgageCalculator (MC) est une application web Java complète permettant de calculer les versements mensuels d'un prêt hypothécaire en fonction du prix de la maison, de l'apport initial, de la durée du prêt (en mois) et du taux d'intérêt. L'application est conçue avec une architecture modulaire, utilisant des services distincts pour gérer les taux d'intérêt, les taux d'assurance et les calculs d'amortissement. Elle propose une interface utilisateur web développée avec Servlet, JSP (JavaServer Pages) et déployée sur un serveur Apache Tomcat.

Services Principaux :

    InterestRateService (IRS)

        Fonctionnalités :

            Obtenir le taux d'intérêt annuel d'une banque spécifique.

            Trouver la banque offrant le taux d'intérêt le plus bas.

            Lister les banques proposant un type de produit spécifique (prêt hypothécaire, assurance, compte épargne, etc.).

    InsuranceRateService (ACS)

        Fonctionnalités :

            Calculer le taux d'assurance applicable en fonction du montant du prêt et de la durée de remboursement.

    MortgageAmortizationService (MAS)

        Fonctionnalités :

            Calculer le meilleur taux hypothécaire, le montant du versement mensuel et le total des intérêts payés en fonction du prix de la maison, de l'apport initial et de la durée du prêt.

            Ce service communique avec IRS et ACS pour obtenir les taux d'intérêt et d'assurance.

Technologies Utilisées :

    Langage de programmation : Java

    Environnement de développement : NetBeans

    Base de données : MySQL

    ORM : Hibernate

    API de persistance : JPA (Java Persistence API)

    Langage de requête : JPQL (Java Persistence Query Language)

    Technologies web : Servlet, JSP (JavaServer Pages)

    Serveur d'application : Apache Tomcat

Fonctionnalités de l'Application Web :

    Interface utilisateur interactive via des pages JSP pour saisir les détails du prêt (prix de la maison, apport initial, durée, etc.).

    Traitement des requêtes via des Servlets pour interagir avec les services backend (IRS, ACS, MAS).

    Affichage des résultats (versements mensuels, taux d'intérêt, amortissement) dans une interface web conviviale.

    Gestion des données via une base de données MySQL et Hibernate pour la persistance des informations.

Objectif :
L'objectif de ce projet est de fournir une solution complète et modulaire pour le calcul des prêts hypothécaires, en combinant une interface utilisateur web intuitive avec des services backend robustes et une gestion efficace des données.
