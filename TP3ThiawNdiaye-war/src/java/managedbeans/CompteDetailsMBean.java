/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import tp3.gestionnaires.GestionnaireAgence;
import tp3.gestionnaires.GestionnaireCompteBancaire;
import tp3.gestionnaires.GestionnairePersonne;
import tp3.modeles.Agence;
import tp3.modeles.CompteBancaire;
import tp3.modeles.Personne;

/**
 *
 * @author thiaw
 */
@Named(value = "compteDetailsMBean")
@ViewScoped
public class CompteDetailsMBean implements Serializable {

    @EJB
    private GestionnaireAgence gestionnaireAgence;

    @EJB
    private GestionnaireCompteBancaire gestionnaireCompteBancaire;

    @EJB
    private GestionnairePersonne gestionnairePersonne;
    
    private Long idCompte;
    private CompteBancaire compteBancaire;


    public CompteDetailsMBean() {
    }

    /**
     * Creates a new instance of CompteDetailsMBean
     *
     * @return
     */
    public Long getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(Long idCompte) {
        this.idCompte = idCompte;
    }

    public CompteBancaire getCompte() {
        return compteBancaire;
    }

    public void setCompte(CompteBancaire cb) {
        this.compteBancaire = cb;
    }

    /**
     * Action handler - met à jour la base de données en fonction du client
     * passé en paramètres, et renvoie vers la page qui affiche la liste des
     * clients.
     *
     * @return
     */
    public String update() {
        compteBancaire = gestionnaireCompteBancaire.update(compteBancaire);
        return "printComptes?faces-redirect=true";
    }

    /**
     * Action handler - renvoie vers la page qui affiche la liste des clients
     *
     * @return
     */
    public String list() {
        return "printComptes?faces-redirect=true";
    }

    public void loadCompte() {
        this.compteBancaire = gestionnaireCompteBancaire.getCompteBancaireById(idCompte);
    }

    public List<Personne> getAllPersonnes() {
        return gestionnairePersonne.getAllPersonnes();
    }

    public List<Agence> getAllAgences() {
        return gestionnaireAgence.getAllAgences();
    }

    //pour convertir Personne en string
    public Converter getPersonneCodeConverter() {
        return personneCodeConverter;
    }

    private Converter personneCodeConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return new ConverterException("On verra la conversion String->Objet plus tard...");
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            Personne p = (Personne) value;
            return p.getPrenom() + p.getNom();
        }
    };

    //conversion de Agence en string
    public Converter getAgenceCodeConverter() {
        return agenceCodeConverter;
    }
    private Converter agenceCodeConverter = new Converter() {

        @Override
        public Object getAsObject(FacesContext context, UIComponent component, String value) {
            return new ConverterException("On verra la conversion String->Objet plus tard...");
        }

        @Override
        public String getAsString(FacesContext context, UIComponent component, Object value) {
            Agence ag = (Agence) value;
            return ag.getNomAgence() + ag.getAdresse().getVille();
        }
    };

}
