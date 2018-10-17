/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modeles;

public class Operations {
    
    private int ajout;
    private int retrait;
    private int versement;
    private int virement;
    private int soldeCompte;


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
