/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import tp3.gestionnaires.GestionnaireAdresse;
import tp3.gestionnaires.GestionnaireAgence;
import tp3.gestionnaires.GestionnaireCarteBancaire;
import tp3.gestionnaires.GestionnaireCompteBancaire;
import tp3.gestionnaires.GestionnairePersonne;
import tp3.modeles.Adresse;
import tp3.modeles.Agence;
import tp3.modeles.CompteBancaire;
import tp3.modeles.Personne;

/**
 *
 * @author thiaw
 */
@Named(value = "indexMBean")
@Dependent
public class IndexMBean {

        @EJB
    private GestionnaireAdresse gestionnaireAdresse;

    @EJB
    private GestionnaireAgence gestionnaireAgence;

    @EJB
    private GestionnairePersonne gestionnairePersonne;

    @EJB
    private GestionnaireCarteBancaire gestionnaireCarteBancaire;

    @EJB
    private GestionnaireCompteBancaire gestionnaireCompteBancaire;
    
    private GestionnaireCompteBancaireMBean gestionnaireCompteBancaireMBean;
    
    
    /**
     * Creates a new instance of IndexMBean
     */
    public IndexMBean() {
    }
    
    /* id, num et solde*/
    
    public void creerComptesTests() throws ParseException{
    
        Adresse adr = new Adresse(61, "bd wilson", "Antibes");
        gestionnaireAdresse.creerAdresse(adr);
                
        Agence ag = new Agence(2827, "borriglionne", adr);
        gestionnaireAgence.creerAgence(ag);
        
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dfm.parse("2018-10-02");
        
        Personne p = new Personne("thiaw", "mamadou", date, adr);
        gestionnairePersonne.creerPersonne(p);
                
        CompteBancaire cptb = new CompteBancaire(12233, ag, p, 0, date);
        gestionnaireCompteBancaire.creerCompte(cptb);
    }
    
    public List<CompteBancaire> getComptes(){
        return gestionnaireCompteBancaire.getAllComptesBancaires();
    }
    
     public String showDetails(int compteId) {  
        return "CompteDetails?idCompte=" + compteId;    
     
     }
}
