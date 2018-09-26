/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import tp3.gestionnaires.GestionnaireCompteBancaire;
import tp3.modeles.Adresse;
import tp3.modeles.Agence;
import tp3.modeles.CompteBancaire;
import tp3.modeles.Personne;


@Named(value = "gestionnaireCompteBancaireMBean")
@ViewScoped
public class GestionnaireCompteBancaireMBean implements Serializable{

    @EJB
    private GestionnaireCompteBancaire gestionnaireCompteBancaire;
    
    //private List<CompteBancaire> listComptes;
 
    private int idCompteBancaire;
    private CompteBancaire compteBancaire;

    public CompteBancaire getCompteBancaire() {
        return compteBancaire;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.compteBancaire = compteBancaire;
    }
    
    public CompteBancaire getDetails(){
        return this.compteBancaire;
    }
    
    public void loadCompte() {  
    this.compteBancaire = gestionnaireCompteBancaire.getCompteBancaire(idCompteBancaire);  
  } 
    
     /*public List<CompteBancaire> getComptes() {  
        if(listComptes == null){
            listComptes = gestionnaireCompteBancaire.getAllComptesBancaires();
        }
        return listComptes;  
    } */

    public int getIdCompteBancaire() {
        return idCompteBancaire;
    }

    public void setIdCompteBancaire(int idCompteBancaire) {
        this.idCompteBancaire = idCompteBancaire;
    }
    /**
     * Creates a new instance of GestionnaireCompteBancaireMBean
     */
    public GestionnaireCompteBancaireMBean() {
    }
    
    public List<CompteBancaire>getComptesBancaires() {  
        return gestionnaireCompteBancaire.getAllComptesBancaires();  
    } 
    
     public void creerComptesTest(){
    Adresse ad1 = new Adresse(Long.MIN_VALUE, "bd wilson", 61, 06600, "Antibes", "France");
    Adresse ad2 = new Adresse(Long.MIN_VALUE, "r. gary", 35, 06300, "Nice", "France");
  
    Personne client = new Personne("thiaw", "mamadou", new java.util.Date(), "saadikh", "root", "etudiant", ad1);
    Agence banque = new Agence("BNP", ad2, new java.util.Date());
    
    CompteBancaire cpt = new CompteBancaire(2, client, 1000, new java.util.Date());
    gestionnaireCompteBancaire.creerCompte(cpt);
    
     }
     
 
    
}
