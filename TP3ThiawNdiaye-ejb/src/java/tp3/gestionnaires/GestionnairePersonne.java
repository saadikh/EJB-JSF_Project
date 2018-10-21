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
import tp3.modeles.Personne;

@Stateless
@LocalBean
public class GestionnairePersonne {

    @EJB
    private LoginManager loginManager;

    @PersistenceContext(unitName = "TP3ThiawNdiaye-ejbPU")
    private EntityManager em;

    
    public void persist(Object object) {
        em.persist(object);
    }

    public void creerPersonne(Personne personne) {
        //en creant personne, on crée aussi ses identifiant
        String login = personne.getStatut();
        String pwd = personne.getPassword();
        loginManager.creerUser(login, pwd);
        em.persist(personne);
    }

    public List<Personne> getAllPersonnes() {
        Query query = em.createNamedQuery("Personne.findAll");
        return query.getResultList();
    }

    public Personne update(Personne personne) {
        return em.merge(personne);
    }

    public void deletePersonne(Personne personne) {
        em.remove(personne);
    }

    public Personne getPersonne(int id) {
        return em.find(Personne.class, id);
    }
    
    //utile pour la partie connexion
    public List<Personne> getPersonneByPwd(String pwd){
        //raffraichir les caches 1 et 2 d'abord
        //getAllPersonnes(true);
        Query query = em.createQuery("select p from Personne p where p.password = '" + pwd + "'");
        return query.getResultList();    
    }
    
       public List<Personne> getAllPersonnes(boolean forceRefresh) {
        Query query = em.createNamedQuery("Personne.findAll");
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
       
       public List<CompteBancaire> getMesComptes(Personne p){
           return p.getCompteBancaires();
       }
}
