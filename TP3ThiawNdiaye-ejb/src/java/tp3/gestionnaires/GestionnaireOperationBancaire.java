/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.gestionnaires;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tp3.modeles.Adresse;
import tp3.modeles.Agence;
import tp3.modeles.CarteBancaire;
import tp3.modeles.CompteBancaire;
import tp3.modeles.OperationBancaire;
import tp3.modeles.Personne;

/**
 *
 * @author thiaw
 */
@Stateless
@LocalBean
public class GestionnaireOperationBancaire {

    @PersistenceContext(unitName = "TP3ThiawNdiaye-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    public void creerOperationBancaire(OperationBancaire ob){
        em.persist(ob);
    }
    
    //creation des champs 
    public void creerCompteBancaire(CompteBancaire cb) {
        em.persist(cb);
    }

    public void creerCarteBancaire(CarteBancaire cb) {
        em.persist(cb);
    }

    public void creerPersonne(Personne p) {
        em.persist(p);
    }

    public void creerAgence(Agence ag) {
        em.persist(ag);
    }

    public void creerAdresse(Adresse adr) {
        em.persist(adr);
    }

    //update des champs
    public void updateCompteBancaire(CompteBancaire cb) {
        em.merge(cb);
    }

    public void updateCarteBancaire(CarteBancaire cb) {
        em.merge(cb);
    }

    public void updatePersonne(Personne p) {
        em.merge(p);
    }

    public void updateAgence(Agence ag) {
        em.merge(ag);
    }

    public void updateAdresse(Adresse adr) {
        em.merge(adr);
    }

    // suppression des champs
    public void deleteCompteBancaire(CompteBancaire cb) {
        em.remove(cb);
    }

    public void deleteCarteBancaire(CarteBancaire cb) {
        em.remove(cb);
    }

    public void deletePersonne(CompteBancaire p) {
        em.remove(p);
    }

    public void deleteAgence(Agence ag) {
        em.remove(ag);
    }

    public void deleteAdresse(Adresse adr) {
        em.remove(adr);
    }

    /** 
     * obtenir les champs en collection *************************************************
     *
     **/
    
    public List<CompteBancaire> getOperationsCompte(boolean forceRefresh) {
        Query query = em.createNamedQuery("SELECT ob.compteBancaire FROM OperationBancaire ob");
        // Cette liste provient du cache de niveau 2 et 1
        // Si les données changent en insert/delete, la liste est à jour
        // Mais pas forcément les updates
        List<CompteBancaire> liste = query.getResultList();

        // Force le refresh des valeurs
        if (forceRefresh) {
            for (CompteBancaire compte : liste) {
                // em.refresh force le rafraichissement des
                // attributs de l'objet en mémoire en fonction
                // des dernières valeurs pour cet objet, dans la base
                // (au plus près du dernier commit)
                em.refresh(compte);
            }
        }

        return liste;
    }

    public List<Personne> getOperationsPersonne(boolean forceRefresh) {
        Query query = em.createNamedQuery("SELECT ob.personne FROM OperationBancaire ob");
        // Cette liste provient du cache de niveau 2 et 1
        // Si les données changent en insert/delete, la liste est à jour
        // Mais pas forcément les updates
        List<Personne> liste = query.getResultList();

        // Force le refresh des valeurs
        if (forceRefresh) {
            for (Personne personne : liste) {
                // em.refresh force le rafraichissement des
                // attributs de l'objet en mémoire en fonction
                // des dernières valeurs pour cet objet, dans la base
                // (au plus près du dernier commit)
                em.refresh(personne);
            }
        }

        return liste;
    }

    public List<Agence> getOperationsAgence(boolean forceRefresh) {
        Query query = em.createNamedQuery("SELECT ob.agence FROM OperationBancaire ob");
        // Cette liste provient du cache de niveau 2 et 1
        // Si les données changent en insert/delete, la liste est à jour
        // Mais pas forcément les updates
        List<Agence> liste = query.getResultList();

        // Force le refresh des valeurs
        if (forceRefresh) {
            for (Agence ag : liste) {
                // em.refresh force le rafraichissement des
                // attributs de l'objet en mémoire en fonction
                // des dernières valeurs pour cet objet, dans la base
                // (au plus près du dernier commit)
                em.refresh(ag);
            }
        }

        return liste;
    }

    public List<Adresse> getOperationsAdresse(boolean forceRefresh) {
        Query query = em.createNamedQuery("SELECT ob.adresse FROM OperationBancaire ob");
        // Cette liste provient du cache de niveau 2 et 1
        // Si les données changent en insert/delete, la liste est à jour
        // Mais pas forcément les updates
        List<Adresse> liste = query.getResultList();

        // Force le refresh des valeurs
        if (forceRefresh) {
            for (Adresse adr : liste) {
                // em.refresh force le rafraichissement des
                // attributs de l'objet en mémoire en fonction
                // des dernières valeurs pour cet objet, dans la base
                // (au plus près du dernier commit)
                em.refresh(adr);
            }
        }

        return liste;
    }

    public List<CarteBancaire> getOperationsCarte(boolean forceRefresh) {
        Query query = em.createNamedQuery("SELECT ob.carteBancaire FROM OperationBancaire ob");
        // Cette liste provient du cache de niveau 2 et 1
        // Si les données changent en insert/delete, la liste est à jour
        // Mais pas forcément les updates
        List<CarteBancaire> liste = query.getResultList();

        // Force le refresh des valeurs
        if (forceRefresh) {
            for (CarteBancaire cb : liste) {
                // em.refresh force le rafraichissement des
                // attributs de l'objet en mémoire en fonction
                // des dernières valeurs pour cet objet, dans la base
                // (au plus près du dernier commit)
                em.refresh(cb);
            }
        }

        return liste;
    }
    
     /** 
     * obtenir les champs en collection (sans parametre*************************************************
     *
     **/

     
}
