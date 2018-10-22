/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import tp3.gestionnaires.GestionnaireOperationBancaire;
import tp3.modeles.Adresse;
import tp3.modeles.Agence;
import tp3.modeles.CarteBancaire;
import tp3.modeles.CompteBancaire;
import tp3.modeles.Personne;

/**
 *
 * @author thiaw
 */
@Named(value = "operationBancaireMBean")
@ViewScoped
public class OperationBancaireMBean {

    @EJB
    private GestionnaireOperationBancaire gestionnaireOperationBancaire;

    private int id;
    private CompteBancaire compteBancaire;
    private Personne personne;
    private CarteBancaire carteBancaire;
    private Agence agence;
    private Adresse adresse;

    /**
     * Creates a new instance of OperationBancaireMBean
     */
    public OperationBancaireMBean() {
    }

    //getters - setters
    public GestionnaireOperationBancaire getGestionnaireOperationBancaire() {
        return gestionnaireOperationBancaire;
    }

    public void setGestionnaireOperationBancaire(GestionnaireOperationBancaire gestionnaireOperationBancaire) {
        this.gestionnaireOperationBancaire = gestionnaireOperationBancaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public CarteBancaire getCarteBancaire() {
        return carteBancaire;
    }

    public void setCarteBancaire(CarteBancaire carteBancaire) {
        this.carteBancaire = carteBancaire;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    //traitement
    public void getOperationsCompte() {
        gestionnaireOperationBancaire.getOperationsCompte(true);
    }

    public void getOperationsCarte() {
        gestionnaireOperationBancaire.getOperationsCarte(true);
    }

    public void getOperationsPersonne() {
        gestionnaireOperationBancaire.getOperationsPersonne(true);
    }

    public void getOperationsAgence() {
        gestionnaireOperationBancaire.getOperationsAgence(true);
    }

    public void getOperationsAdresse() {
        gestionnaireOperationBancaire.getOperationsAdresse(true);
    }

}
