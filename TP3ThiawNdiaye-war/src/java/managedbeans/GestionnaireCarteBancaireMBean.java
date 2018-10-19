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
import tp3.gestionnaires.GestionnaireCarteBancaire;
import tp3.modeles.CarteBancaire;


@Named(value = "gestionnaireCarteBancaireMBean")
@Dependent
public class GestionnaireCarteBancaireMBean {

    @EJB
    private GestionnaireCarteBancaire gestionnaireCarteBancaire;
    
    private CarteBancaire carteBancaire;
    private int idCarteBancaire;

    public CarteBancaire getCarteBancaire() {
        return carteBancaire;
    }

    public void setCarteBancaire(CarteBancaire carteBancaire) {
        this.carteBancaire = carteBancaire;
    }

    public int getIdCarteBancaire() {
        return idCarteBancaire;
    }

    public void setIdCarteBancaire(int idCarteBancaire) {
        this.idCarteBancaire = idCarteBancaire;
    }

   
    public GestionnaireCarteBancaireMBean() {
    }
    
     public List<CarteBancaire> getCartesBancaires() {  
        return gestionnaireCarteBancaire.getAllCartesBancaires();  
    } 
     
     public CarteBancaire getDetails(){
         return carteBancaire;
     }
     
       public void loadCustomer() {  
    this.carteBancaire = gestionnaireCarteBancaire.getCarte(idCarteBancaire);  
  } 
}
