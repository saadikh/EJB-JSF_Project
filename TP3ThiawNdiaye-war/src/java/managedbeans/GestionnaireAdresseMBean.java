/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import tp3.gestionnaires.GestionnaireAdresse;
import tp3.modeles.Adresse;

/**
 *
 * @author thiaw
 */
@Named(value = "gestionnaireAdresseMBean")
@Dependent
public class GestionnaireAdresseMBean {

    @EJB
    private GestionnaireAdresse gestionnaireAdresse;

    private int idAdresse;
    private Adresse adresse;

    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
    
    
    /**
     * Creates a new instance of GestionnaireAdresseMBean
     */
    public GestionnaireAdresseMBean() {
    }
    

     public List<Adresse> getComptesBancaires() {  
        return gestionnaireAdresse.getAllAdresses();  
    } 
     
     public Adresse getDetails(){
         return adresse;
     }
     
       public void loadCustomer() {  
    this.adresse = gestionnaireAdresse.getAdresse(idAdresse);  
  } 
}
