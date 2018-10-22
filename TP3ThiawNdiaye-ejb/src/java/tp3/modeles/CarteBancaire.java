/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modeles;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
@NamedQueries({
    @NamedQuery(name = "CarteBancaire.findAll", query = "SELECT c FROM CarteBancaire c")
    , @NamedQuery(name = "CarteBancaire.findById", query = "SELECT c FROM CarteBancaire c WHERE c.id = :id")
    , @NamedQuery(name = "CarteBancaire.findByIdAgence", query = "SELECT c.agence.id FROM CarteBancaire c")
    , @NamedQuery(name = "CarteBancaire.findByVoieAgence", query = "SELECT c.agence.adresse.voie FROM CarteBancaire c")
    , @NamedQuery(name = "CarteBancaire.findByVilleAgence", query = "SELECT c.agence.adresse.ville FROM CarteBancaire c")
    , @NamedQuery(name = "CarteBancaire.findByNumeroVoieAgence", query = "SELECT c.agence.adresse.numeroVoie FROM CarteBancaire c")
    , @NamedQuery(name = "CarteBancaire.findByNomAgence", query = "SELECT c.agence.nomAgence FROM CarteBancaire c")
    , @NamedQuery(name = "CarteBancaire.findByNomProprietaire", query = "SELECT c.proprietaire.nom FROM CarteBancaire c")
    , @NamedQuery(name = "CarteBancaire.findByPrenomProprietaire", query = "SELECT c.proprietaire.prenom FROM CarteBancaire c")
    , @NamedQuery(name = "CarteBancaire.findByDateCreation", query = "SELECT c FROM CarteBancaire c WHERE c.dateCreation = :dateCreation")
    , @NamedQuery(name = "CarteBancaire.findByDateExpiration", query = "SELECT c FROM CarteBancaire c WHERE c.dateExpiration = :dateExpiration")})

public class CarteBancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateExpiration;
    @OneToOne
    private Agence agence;
    @OneToOne
    private Personne proprietaire;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Collection<OperationBancaire> operations = new ArrayList<>();

    public Collection<OperationBancaire> getOperations() {
        return operations;
    }

    public void setOperations(Collection<OperationBancaire> operations) {
        this.operations = operations;
    }

    public Agence getAgence() {
        return agence;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public Personne getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Personne proprietaire) {
        this.proprietaire = proprietaire;
    }

    public CarteBancaire() {
    }

    public CarteBancaire(Long id) {
        this.id = id;
    }

    public CarteBancaire(Date dateCreation, Date dateExpiration, Agence agence, Personne proprietaire) {
        this.dateCreation = dateCreation;
        this.dateExpiration = dateExpiration;
        this.proprietaire = proprietaire;
        OperationBancaire op = new OperationBancaire();
        op.setDescription("Création carte");
        operations.add(op); 
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "tp3.modeles.CarteBancaire[ id=" + id + " ]";
    }

}
