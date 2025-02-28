package edu.bdeb.dl;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AppPersistenceUnit implements PersistenceUnitInfo {

    @Override
    public String getPersistenceUnitName() {
        return "AppPersistenceUnitInfo";
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {
        return null;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return List.of();
    }

    @Override
    public List<URL> getJarFileUrls() {
        return List.of();
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        List<String> managedClasses = new ArrayList<>();
        managedClasses.add("edu.bdeb.modele.Banque");
        managedClasses.add("edu.bdeb.modele.Produit");
        return managedClasses;
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        Properties props = new Properties();

        // connection directives
        props.setProperty("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        props.setProperty("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/mysql?useSSL=false&serverTimezone=UTC");
        props.setProperty("javax.persistence.jdbc.user", "root");
        props.setProperty("javax.persistence.jdbc.password", "user");
        props.setProperty("javax.persistence.schema-generation.database.action", "update");  // Pour générer ou mettre à jour le schéma automatiquement
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

//        props.setProperty("javax.persistence.jdbc.password", "A10BdeB2024");
//        props.setProperty("javax.persistence.jdbc.url", "jdbc:mariadb://mysql-wafaa.alwaysdata.net:3306/wafaa_a10bd");
//        props.setProperty("javax.persistence.jdbc.user", "wafaa_a10user");
//        props.setProperty("javax.persistence.jdbc.driver", "org.mariadb.jdbc.Driver");
//        props.setProperty("javax.persistence.schema-generation.database.action", "update");
//        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        // Hibernate directives
        props.setProperty("hibernate.format_sql", "false");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.use_sql_comments", "false");
        props.setProperty("hibernate.ejb.interceptor", "org.hibernate.ejb.interceptor.EmptyInterceptor");

        return props;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return "";
    }

    @Override
    public ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    @Override
    public void addTransformer(ClassTransformer classTransformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
