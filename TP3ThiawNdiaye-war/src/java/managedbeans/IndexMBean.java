/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import tp3.gestionnaires.GestionnaireAdresse;
import tp3.gestionnaires.GestionnaireAgence;
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
@ViewScoped
public class IndexMBean implements Serializable {

    @EJB
    private GestionnaireAdresse gestionnaireAdresse;

    @EJB
    private GestionnaireAgence gestionnaireAgence;

    @EJB
    private GestionnairePersonne gestionnairePersonne;

    //@EJB
    //private GestionnaireCarteBancaire gestionnaireCarteBancaire;
    @EJB
    private GestionnaireCompteBancaire gestionnaireCompteBancaire;

    //private GestionnaireCompteBancaireMBean gestionnaireCompteBancaireMBean;
    private List<CompteBancaire> compteList = null;

    /**
     * Creates a new instance of IndexMBean
     */
    public IndexMBean() {
    }

    /* id, num et solde*/
    public void creerComptesTests() throws ParseException {

        //creation adresses
        Adresse adr = new Adresse(61, "bd gambetta", "nice");
        Adresse adr1 = new Adresse(61, "bd wilson", "Antibes");

        gestionnaireAdresse.creerAdresse(adr);
        gestionnaireAdresse.creerAdresse(adr1);

        // creation agences
        Agence ag = new Agence("borriglionne", adr);
        Agence ag1 = new Agence("antibes", adr);
        gestionnaireAgence.creerAgence(ag);
        gestionnaireAgence.creerAgence(ag1);

        //creation date
        DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dfm.parse("2018-10-02");

        //creation personnes
        Personne p = new Personne("thiaw", "mamadou", date, "mamadou", "conseiller", adr);
        Personne p1 = new Personne("diouf", "awa", date, "awa", "client", adr);
        gestionnairePersonne.creerPersonne(p);
        gestionnairePersonne.creerPersonne(p1);

        //creation comptes
        CompteBancaire cptb = new CompteBancaire(ag, p, 0, date);
        CompteBancaire cptb1 = new CompteBancaire(ag1, p1, 0, date);

        gestionnaireCompteBancaire.creerCompte(cptb);
        gestionnaireCompteBancaire.creerCompte(cptb1);

    }
    
    /*public void creerCompte(Personne p, Agence ag, int solde, Date dateOuverture){
        gestionnairePersonne.creerPersonne(p);
        gestionnaireAgence.creerAgence(ag);
        
    }*/
    

    public List<CompteBancaire> getComptes() {
        refreshListOfCompteFromDatabase();
        return compteList;
    }

    public String showDetails(int compteId) {
        return "CompteDetails?idCompte=" + compteId;

    }

    public void deleteCompte(CompteBancaire cb) {
        gestionnaireCompteBancaire.deleteCompte(cb);
    }

    public void preRenderView() {
        // Hack pour éviter l'erreur Cannot create a session after the response 
        // has been committed des datatables PrimeFaces

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        refreshListOfCompteFromDatabase();
    }

    public void refreshListOfCompteFromDatabase() {
        // true force le refresh depuis la base
        compteList = gestionnaireCompteBancaire.getAllComptesBancaires(true);

    }

    public List<CompteBancaire> getComptesClient(Personne p){
        return gestionnairePersonne.getMesComptes(p);
    }
}
