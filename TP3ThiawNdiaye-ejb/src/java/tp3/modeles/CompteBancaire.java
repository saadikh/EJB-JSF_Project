/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modeles;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
    @NamedQuery(name = "CompteBancaire.findAll", query = "SELECT c FROM CompteBancaire c")
    , @NamedQuery(name = "CompteBancaire.findByNumeroCompte", query = "SELECT c FROM CompteBancaire c WHERE c.numeroCompte = :numeroCompte")
    , @NamedQuery(name = "CompteBancaire.findBySoldeCompte", query = "SELECT c FROM CompteBancaire c WHERE c.soldeCompte = :soldeCompte")
    , @NamedQuery(name = "CompteBancaire.findByProprietaire", query = "SELECT c FROM CompteBancaire c WHERE c.proprietaire = :proprietaire")
    , @NamedQuery(name = "CompteBancaire.findByBanque", query = "SELECT c FROM CompteBancaire c WHERE c.banque = :banque")
    , @NamedQuery(name = "CompteBancaire.findByDateOuverture", query = "SELECT c FROM CompteBancaire c WHERE c.dateOuverture = :dateOuverture")})
public class CompteBancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    
    private Personne banque;
    private Adresse adresseBanque;
    private int numeroCompte;
    private Personne proprietaire;
    private Adresse adresseProprietaire;
    private int soldeCompte;
    private Date dateOuverture;
    
    public CompteBancaire(){
        
    }

    public CompteBancaire(Long id, Personne banque, Adresse adresseBanque, int numeroCompte, Personne proprietaire, Adresse adresseProprietaire, int soldeCompte, Date dateOuverture) {
        this.id = id;
        this.banque = banque;
        this.adresseBanque = adresseBanque;
        this.numeroCompte = numeroCompte;
        this.proprietaire = proprietaire;
        this.adresseProprietaire = adresseProprietaire;
        this.soldeCompte = soldeCompte;
        this.dateOuverture = dateOuverture;
    }

    public Personne getBanque() {
        return banque;
    }

    public void setBanque(Personne banque) {
        this.banque = banque;
    }

    public Adresse getAdresseBanque() {
        return adresseBanque;
    }

    public void setAdresseBanque(Adresse adresseBanque) {
        this.adresseBanque = adresseBanque;
    }

    public int getNumCompte() {
        return numeroCompte;
    }

    public void setNumCompte(int numCompte) {
        this.numeroCompte = numCompte;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Adresse getAdresseProprietaire() {
        return adresseProprietaire;
    }

    public void setAdresseProprietaire(Adresse adresseProprietaire) {
        this.adresseProprietaire = adresseProprietaire;
    }

    public int getSoldeCompte() {
        return soldeCompte;
    }

    public void setSoldeCompte(int soldeCompte) {
        this.soldeCompte = soldeCompte;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBancaire)) {
            return false;
        }
        CompteBancaire other = (CompteBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tp3.CompteBancaire[ id=" + id + " ]";
    }
    
}
