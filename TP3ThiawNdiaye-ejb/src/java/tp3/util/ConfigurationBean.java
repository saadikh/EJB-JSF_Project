/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.util;

import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.validation.BootstrapConfiguration;
import javax.validation.Configuration;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.MessageInterpolator;
import javax.validation.ParameterNameProvider;
import javax.validation.TraversableResolver;
import javax.validation.ValidatorFactory;
import tp3.gestionnaires.LoginManager;

/**
 *
 * @author thiaw
 */
@Singleton
@Startup
public class ConfigurationBean implements Configuration {

    /*
    src: https://www.ibm.com/support/knowledgecenter/fr/SSAW57_9.0.0/com.ibm.websphere.nd.multiplatform.doc/ae/tejb_ssb.html
    */
    LoginManager loginManager = lookupLoginManagerBean();

    @PostConstruct
    public void initialize() {
        // 1. Créez la table d'une base de données si elle n'existe pas.
        // 2. Initialisez les paramètres à partir de la table d'une base de données.
        // 3. Chargez un cache.
        // 4. Initialisez un travail asynchrone (par exemple, un travail vers une file d'attente de messagerie ou pour
        //    appeler des méthodes de bean session asynchrone.

        System.out.println("######## Administrateur crée #######");
        loginManager.creerUser("admin", "admin");
        System.out.println("######## conseiller 1 crée #######");
        loginManager.creerUser("conseiller", "root");

    }

    // ...
    @Override
    public Configuration ignoreXmlConfiguration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Configuration messageInterpolator(MessageInterpolator interpolator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Configuration traversableResolver(TraversableResolver resolver) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Configuration constraintValidatorFactory(ConstraintValidatorFactory constraintValidatorFactory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Configuration parameterNameProvider(ParameterNameProvider parameterNameProvider) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Configuration addMapping(InputStream stream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Configuration addProperty(String name, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MessageInterpolator getDefaultMessageInterpolator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TraversableResolver getDefaultTraversableResolver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ConstraintValidatorFactory getDefaultConstraintValidatorFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ParameterNameProvider getDefaultParameterNameProvider() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BootstrapConfiguration getBootstrapConfiguration() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ValidatorFactory buildValidatorFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private LoginManager lookupLoginManagerBean() {
        try {
            Context c = new InitialContext();
            return (LoginManager) c.lookup("java:global/TP3ThiawNdiaye/TP3ThiawNdiaye-ejb/LoginManager!tp3.gestionnaires.LoginManager");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
