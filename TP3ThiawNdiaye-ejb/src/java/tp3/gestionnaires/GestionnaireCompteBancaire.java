/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.gestionnaires;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tp3.modeles.CompteBancaire;
import tp3.modeles.OperationBancaire;
import tp3.modeles.Personne;

@Stateless
@LocalBean
public class GestionnaireCompteBancaire {

    @EJB
    private GestionnaireOperationBancaire gestionnaireOperationBancaire;

    @PersistenceContext(unitName = "TP3ThiawNdiaye-ejbPU")
    private EntityManager em;

    
    public List<CompteBancaire> getAllComptesBancaires() {
        Query query = em.createNamedQuery("CompteBancaire.findAll");
        return query.getResultList();
    }

    public CompteBancaire update(CompteBancaire compteBancaire) {
        OperationBancaire op = new OperationBancaire();
        op.setDescription("Update compteBancaire");
        op.setCompteBancaire(compteBancaire);
        gestionnaireOperationBancaire.creerOperationBancaire(op); // ici on ajoute la relation  
        return em.merge(compteBancaire);
    }

    public void persist(Object object) {
        em.persist(object);
    }

    public CompteBancaire getCompteBancaireById(Long id) {
        return em.find(CompteBancaire.class, id);
    }

    public void creerCompte(CompteBancaire compteBancaire) {
        OperationBancaire op = new OperationBancaire();
        op.setDescription("Création compteBancaire");
        op.setCompteBancaire(compteBancaire);
        gestionnaireOperationBancaire.creerOperationBancaire(op); // ici on ajoute la relation 
        em.persist(compteBancaire);
    }

    public void deleteCompte(CompteBancaire c) {
        OperationBancaire op = new OperationBancaire();
        op.setDescription("Suppression compteBancaire");
        op.setCompteBancaire(c);
        gestionnaireOperationBancaire.creerOperationBancaire(op); // ici on ajoute la relation 
        em.remove(em.merge(c));
    }

    public List<CompteBancaire> getAllComptesBancaires(boolean forceRefresh) {
        Query query = em.createNamedQuery("CompteBancaire.findAll");
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

    public List<CompteBancaire> getComptesByPwd(String pwd) {
        Query query = em.createQuery("SELECT c.proprietaire.password FROM CompteBancaire c where c.proprietaire.password = '" + pwd + "'");
        List<Personne> personnes = query.getResultList();
        // password unique pour chaque user, donc pas besoin de verifier le size()
        return personnes.get(0).getCompteBancaires();

    }

}
