/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import tp3.gestionnaires.GestionnaireCompteBancaire;
import tp3.modeles.Adresse;
import tp3.modeles.Banque;
import tp3.modeles.CompteBancaire;
import tp3.modeles.Personne;

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
    
     public List<CompteBancaire>getComptesBancaires() {  
        return gestionnaireCompteBancaire.getAllComptesBancaires();  
    } 
    
     public CompteBancaire creerComptesTest(){
       
    Adresse ad1 = new Adresse(Long.MIN_VALUE, "bd wilson", 61, 06600, "Antibes", "France");
    Adresse ad2 = new Adresse(Long.MIN_VALUE, "r. gary", 35, 06300, "Nice", "France");
    
    
    
    Personne client = new Personne("thiaw", "mamadou", new java.util.Date(), "saadikh", "root", "etudiant", ad1);
    Banque banque = new Banque("BNP", ad2, new java.util.Date());
    
    CompteBancaire cpt = new CompteBancaire(2, client, 1000, new java.util.Date());
    
    return cpt;
     }
     
 
    
}
