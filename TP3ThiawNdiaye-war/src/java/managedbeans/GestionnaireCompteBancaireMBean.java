/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import tp3.gestionnaires.GestionnaireCompteBancaire;
import tp3.modeles.Adresse;
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
    
    Adresse ad1 = new Adresse(Long.MIN_VALUE, "bd wilson", 61, 06600, "Antibes", "France");
    Adresse ad2 = new Adresse(Long.MIN_VALUE, "r. gary", 35, 06300, "Nice", "France");
    
    /**
     * Creates a new instance of GestionnaireCompteBancaireMBean
     */
    public GestionnaireCompteBancaireMBean() {
    }
    
     public List<CompteBancaire>getCustomers() {  
        return gestionnaireCompteBancaire.getAllComptesBancaires();  
    } 
    
     
 
    
}
