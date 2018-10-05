/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.modeles;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p") 
    , @NamedQuery(name = "Personne.findByNom", query = "SELECT p FROM Personne p WHERE p.nom = :nom") 
    , @NamedQuery(name = "Personne.findByPrenom", query = "SELECT p FROM Personne p WHERE p.prenom = :prenom") 
    , @NamedQuery(name = "Personne.findByDateNaissance", query = "SELECT p FROM Personne p WHERE p.dateNaissance = :dateNaissance") 
    , @NamedQuery(name = "Personne.findByLogin", query = "SELECT p FROM Personne p WHERE p.login = :login") 
    , @NamedQuery(name = "Personne.findByMotDePasse", query = "SELECT p FROM Personne p WHERE p.motDePasse = :motDePasse") 
    , @NamedQuery(name = "Personne.findByProfession", query = "SELECT p FROM Personne p WHERE p.profession = :profession") 
     , @NamedQuery(name = "Personne.findByVoie", query = "SELECT p.adresse.voie FROM Personne p ") 
    , @NamedQuery(name = "Personne.findByVille", query = "SELECT p.adresse.ville FROM Personne p") 
    , @NamedQuery(name = "Personne.findByNumeroVoie", query = "SELECT p.adresse.numeroVoie FROM Personne p")}) 
public class Personne implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private static final long serialVersionUID = 1L;

    private String nom;
    private String prenom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    private String login;
    private String motDePasse;
    private String profession;
    @OneToOne
    private Adresse adresse;

    @OneToMany(mappedBy = "proprietaire")
    private List<CompteBancaire> compteBancaires;

    public List<CompteBancaire> getCompteBancaires() {
        return compteBancaires;
    }

    public void setCompteBancaires(List<CompteBancaire> compteBancaires) {
        this.compteBancaires = compteBancaires;
    }
    
    

    public Personne() {
    }

    public Personne(String nom, String prenom, Date dateNaissance, String login, String motDePasse, String profession, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.login = login;
        this.motDePasse = motDePasse;
        this.profession = profession;
        this.adresse = adresse;
    }

    public Personne(String nom, String prenom, Date dateNaissance, Adresse adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "tp3.modeles.Personne[ id=" + id + " ]";
    }

}
