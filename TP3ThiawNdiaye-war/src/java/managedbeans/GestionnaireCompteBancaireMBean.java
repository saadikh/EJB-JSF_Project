/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import tp3.gestionnaires.GestionnaireCompteBancaire;
import tp3.modeles.CompteBancaire;

/**
 *
 * @author thiaw
 */
@Named(value = "gestionnaireCompteBancaireMBean")
@ViewScoped
public class GestionnaireCompteBancaireMBean {

    @EJB
    private GestionnaireCompteBancaire gestionnaireCompteBancaire;

    /**
     * Creates a new instance of GestionnaireCompteBancaireMBean
     */
    public GestionnaireCompteBancaireMBean() {
    }
    
 
    
}
