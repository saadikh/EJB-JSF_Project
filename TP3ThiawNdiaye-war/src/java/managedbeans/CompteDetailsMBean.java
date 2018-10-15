/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import tp3.gestionnaires.GestionnaireCompteBancaire;
import tp3.modeles.CompteBancaire;

/**
 *
 * @author thiaw
 */
@Named(value = "compteDetailsMBean")
@ViewScoped
public class CompteDetailsMBean implements Serializable{

    @EJB
    private GestionnaireCompteBancaire gestionnaireCompteBancaire;
    
    private int idCompte;
    private CompteBancaire compteBancaire;

    /**
     * Creates a new instance of CompteDetailsMBean
     */
    public CompteDetailsMBean() {
    }

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire getDetails() {
        return compteBancaire;
    }
  
  
  public void loadCompte() {  
    this.compteBancaire = gestionnaireCompteBancaire.getCompteBancaire(idCompte);
  } 
    
}
