/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Named;
import tp3.gestionnaires.GestionnaireAdresse;
import tp3.gestionnaires.GestionnaireAgence;
import tp3.gestionnaires.GestionnaireCompteBancaire;
import tp3.gestionnaires.GestionnairePersonne;
import tp3.modeles.Agence;
import tp3.modeles.CompteBancaire;
import tp3.modeles.Personne;
import tp3.gestionnaires.GestionnaireOperation;
import tp3.modeles.Adresse;
import tp3.modeles.Operations;


/**
 *
 * @author thiaw
 */
@Named(value = "compteDetailsMBean")
@SessionScoped
public class CompteDetailsMBean implements Serializable {

    @EJB
    private GestionnaireAgence gestionnaireAgence;

    @EJB
    private GestionnaireCompteBancaire gestionnaireCompteBancaire;
    private List<CompteBancaire> listeCompte = new ArrayList();
    private int id;
    private int montant;
    private String message;

 
    @EJB
    private GestionnairePersonne gestionnairePersonne;
    private int idCompte;
    private CompteBancaire compteBancaire;
    private Personne personne;

    @EJB
    private GestionnaireAdresse gestionnaireAdresse;

    
    @EJB
    private GestionnaireOperation gestionnaireOperation;
    private Operations operations;

    /**
     * Creates a new instance of CompteDetailsMBean
     *
     * @return
     */
    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire getCompte() {
        return compteBancaire;
    }

    public void setCompte(CompteBancaire cb) {
        this.compteBancaire = cb;
    }

    public Personne getPersonne() {
        return personne;
    }


    /**
     * Action handler - met à jour la base de données en fonction du client
     * passé en paramètres, et renvoie vers la page qui affiche la liste des
     * clients.
     *
     * @return
     */
    public String update() {
        System.out.println("###UPDATE###");
        compteBancaire = gestionnaireCompteBancaire.update(compteBancaire);
        return "printComptes";
    }

    public String creer() {
        //creation adresses
        Adresse adr = new Adresse(61, "bd gambetta", "nice");
        gestionnaireAdresse.creerAdresse(adr);
        // creation agences
        Agence ag = new Agence("borriglionne", adr);
        gestionnaireAgence.creerAgence(ag);
        //creation date
        Date date = new Date();

        compteBancaire = new CompteBancaire(ag, personne, idCompte, date);
        System.out.println("###CREATE###");
        gestionnaireCompteBancaire.creerCompte(compteBancaire);
        return "printComptes?faces-redirect=true";
    }

    /**
     * Action handler - renvoie vers la page qui affiche la liste des clients
     *
     * @return
     */
    public String list() {
        System.out.println("###LIST###");
        return "printComptes?faces-redirect=true";
    }

    public String retirer() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("RETIER sur compte" + id + "le montant : " + montant);
        try {

            gestionnaireCompteBancaire.retirer(montant);
            message = " operation effectué";

        } catch (Exception e) {
            System.out.println("LE COMPTE n'existe pas");
            message = "Le compte bancaire " + id + ",'existe pas";
        }

        context.addMessage(null, new FacesMessage("Succesful", "Your message: " + message));
        return "Index?faces-redirect=true";
    }

    public String deposer() {
        FacesContext context = FacesContext.getCurrentInstance();
        System.out.println("DEPOSER sur compte" + id + "le montant : " + montant);
        try {
            gestionnaireCompteBancaire.deposer(montant);
            message = " operation effectué";

        } catch (Exception e) {
            System.out.println("LE COMPTE n'existe pas");
            message = "Le compte bancaire " + id + ",'existe pas";
        }

        context.addMessage(null, new FacesMessage("Succesful", "Your message:" + message));
        return "Index?faces-redirect=true";
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public void loadCompte() {
        this.compteBancaire = gestionnaireCompteBancaire.getCompteBancaireById(id);
    }

    public List<Personne> getAllPersonnes() {
        return gestionnairePersonne.getAllPersonnes();
    }

    public List<Agence> getAllAgences() {
        return gestionnaireAgence.getAllAgences();
    }

    //pour convertir Personne en string
    public Converter getPersonneCodeConverter() {
        return personneCodeConverter;
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
    
    

    private Converter personneCodeConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return new ConverterException("On verra la conversion String->Objet plus tard...");
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            Personne p = (Personne) value;
            return p.getPrenom() + p.getNom();
        }
    };

    //conversion de Agence en string
    public Converter getAgenceCodeConverter() {
        return agenceCodeConverter;
    }
    private Converter agenceCodeConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return new ConverterException("On verra la conversion String->Objet plus tard...");
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            Agence ag = (Agence) value;
            return ag.getNomAgence() + ag.getAdresse().getVille();
        }
    };

}
