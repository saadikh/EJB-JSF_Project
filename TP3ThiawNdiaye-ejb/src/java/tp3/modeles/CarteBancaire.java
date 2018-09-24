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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;


@Entity
@NamedQueries({
    @NamedQuery(name = "CarteBancaire.findAll", query = "SELECT c FROM CarteBancaire c")
    , @NamedQuery(name = "CarteBancaire.findByNumeroCarte", query = "SELECT c FROM CarteBancaire c WHERE c.numeroCarte = :numeroCarte")
    , @NamedQuery(name = "CarteBancaire.findByNomBanque", query = "SELECT c FROM CarteBancaire c WHERE c.nomBanque = :nomBanque")
    , @NamedQuery(name = "CarteBancaire.findByNomProprietaire", query = "SELECT c FROM CarteBancaire c WHERE c.nomProprietaire = :nomProprietaire")
    , @NamedQuery(name = "CarteBancaire.findByPrenomProprietaire", query = "SELECT c FROM CarteBancaire c WHERE c.prenomProprietaire = :prenomProprietaire")
    , @NamedQuery(name = "CarteBancaire.findBydateExpiration", query = "SELECT c FROM CarteBancaire c WHERE c.dateExpiration = :dateExpiration")})

public class CarteBancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int numeroCarte;
    @OneToOne
    private Banque banque;
    @OneToOne
    private Personne proprietaire;

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateExpiration;

    public CarteBancaire() {
    }

    public CarteBancaire(Long id, int numeroCarte, Banque banque, Personne proprietaire, Date dateExpiration) {
        this.id = id;
        this.numeroCarte = numeroCarte;
        this.dateExpiration = dateExpiration;
    }
    
    

    public int getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(int numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
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
        if (!(object instanceof CarteBancaire)) {
            return false;
        }
        CarteBancaire other = (CarteBancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tp3.modeles.CarteBancaire[ id=" + id + " ]";
    }
    
}
