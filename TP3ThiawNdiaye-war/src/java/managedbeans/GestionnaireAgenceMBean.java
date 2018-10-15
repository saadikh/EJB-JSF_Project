/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import tp3.gestionnaires.GestionnaireAgence;
import tp3.modeles.Agence;

@Named(value = "gestionnaireAgenceMBean")
@Dependent
public class GestionnaireAgenceMBean {

    @EJB
    private GestionnaireAgence gestionnaireAgence;

    private int idAgence;
    private Agence agence;

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
    
    public Agence getDetails(){
        return agence;
    }
    /**
     * Creates a new instance of GestionnaireAgenceMBean
     */
    public GestionnaireAgenceMBean() {
    }
    
    public void loadCustomer() {  
        this.agence = gestionnaireAgence.getAgence(idAgence);  
  } 
    
      public List<Agence> getAgences() {  
        return gestionnaireAgence.getAllAgences();  
    } 
    
}
