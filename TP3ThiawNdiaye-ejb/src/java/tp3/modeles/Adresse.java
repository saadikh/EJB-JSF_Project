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

/**
 *
 * @author thiaw
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Adresse.findAll", query = "SELECT a FROM Adresse a")
    , @NamedQuery(name = "Adresse.findByNumeroVoie", query = "SELECT a FROM Adresse a WHERE a.numeroVoie = :numeroVoie")
    , @NamedQuery(name = "Adresse.findByVoie", query = "SELECT a FROM Adresse a WHERE a.voie = :voie")
    , @NamedQuery(name = "Adresse.findByCodePostal", query = "SELECT a FROM Adresse a WHERE a.codePostal = :codePostal")
    , @NamedQuery(name = "Adresse.findByVille", query = "SELECT a FROM Adresse a WHERE a.ville = :ville")
    , @NamedQuery(name = "Adresse.findByPays", query = "SELECT a FROM Adresse a WHERE a.pays = :ville")})
public class Adresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String voie;
    private int numeroVoie;
    private int codePostal;
    private String ville;
    private String pays;

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public int getNumeroVoie() {
        return numeroVoie;
    }

    public void setNumeroVoie(int numeroVoie) {
        this.numeroVoie = numeroVoie;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
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
        if (!(object instanceof Adresse)) {
            return false;
        }
        Adresse other = (Adresse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tp3.modeles.Adresse[ id=" + id + " ]";
    }
    
}
