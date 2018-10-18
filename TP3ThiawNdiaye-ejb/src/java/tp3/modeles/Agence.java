/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modeles;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name = "Agence.findAll", query = "SELECT a FROM Agence a")
    , @NamedQuery(name = "Agence.findByNomAgence", query = "SELECT a FROM Agence a WHERE a.nomAgence = :nomAgence")
    , @NamedQuery(name = "Agence.findById", query = "SELECT a FROM Agence a WHERE a.id = :id")
    , @NamedQuery(name = "Agence.findByNomVoie", query = "SELECT a.adresse.voie FROM Agence a")
    , @NamedQuery(name = "Agence.findByNumeroVoie", query = "SELECT a.adresse.numeroVoie FROM Agence a")
    , @NamedQuery(name = "Agence.findByVille", query = "SELECT a.adresse.ville FROM Agence a ")})
public class Agence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomAgence;
    @OneToOne
    private Adresse adresse;

    public Agence() {
    }
    
    public Agence(Long id){
        this.id = id;
    }

    public Agence(String nomAgence, Adresse adresse) {
        this.nomAgence = nomAgence;
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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
        if (!(object instanceof Agence)) {
            return false;
        }
        Agence other = (Agence) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "tp3.modeles.Agence[ id=" + id + " ]";
    }

    
}
