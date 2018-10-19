/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//@Entity
//@NamedQueries({ 
//    @NamedQuery(name = "Operations.findAll", query = "SELECT o FROM Operations o")
//    , @NamedQuery(name = "Operations.findByAjout", query = "SELECT o.ajout  FROM Operations o WHERE o.ajout=ajout") 
//    , @NamedQuery(name = "Operations.findByRetrait", query = "SELECT o.retrait FROM Operations o WHERE o.retrait= retrait") 
//    , @NamedQuery(name = "Operations.findByVersement", query = "SELECT o.versement FROM Operations o WHERE o.versement= versement") 
//    , @NamedQuery(name = "Operations.findByVirement", query = "SELECT o.virement FROM Operations o WHERE o.virement = virement")}) 

public class Operations implements Serializable {
    
   
    
    @Id
    private int ajout;
    private int retrait;
    private int versement;
    private int virement;
    private int soldeCompte;

    public Operations() {
    }


    public Operations(int ajout, int retrait, int virement,int soldeCompte) {
        this.ajout = ajout;
        this.retrait = retrait;
        this.virement = virement;
        this.soldeCompte = soldeCompte;
    }

    public int getAjout() {
        return ajout;
    }

    public void setAjout(int ajout) {
        this.ajout = ajout;
    }

    public int getRetrait() {
        return retrait;
    }

    public void setRetrait(int retrait) {
        this.retrait = retrait;
    }

    public int getVersement() {
        return versement;
    }

    public void setVersement(int versement) {
        this.versement = versement;
    }

    public int getVirement() {
        return virement;
    }

    public void setVirement(int virement) {
        this.virement = virement;
    }

    public int getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(int soldeCompte) {
        this.soldeCompte = soldeCompte;
    }
    
    public void ajoutSomme (int montant)
    {
        montant= this.getSoldeCompte() + this.getAjout();
    }
     public void retraitSomme ( int montant){
         
         montant = this.getSoldeCompte() - this.getRetrait();
 
     }
    
     public void faireVirement(int montant){
     montant = this.getSoldeCompte() - this.getVirement();
     }
     
      public void faireVersement (int montant){
     montant = this.getSoldeCompte() + this.getVersement();
     }
    
    
}
