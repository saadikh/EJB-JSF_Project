/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.gestionnaires;

import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tp3.modeles.Login;
import tp3.modeles.Personne;

@Stateless
@LocalBean
public class LoginManager {

    @EJB
    private GestionnairePersonne gestionnairePersonne;

    @PersistenceContext(unitName = "TP3ThiawNdiaye-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public void creerUser(String name, String pwd) {
        Login user = new Login(name, pwd);
        em.persist(user);
    }

    public void deleteUser(Login user) {
        em.remove(user);
    }
    
    public void deleteByPwd(String pwd){
        List<Login> users = chercherParPassword(pwd);
        Login user = users.get(0);
        deleteUser(user);
    }

    public void updateUser(Login user) {
        em.merge(user);
    }

    public List<Login> getAllUsers() {
        Query query = em.createNamedQuery("Login.findAll");
        return query.getResultList();
    }

    public List<Login> getAllUsers(boolean forceRefresh) {
        Query query = em.createNamedQuery("Login.findAll");
        // Cette liste provient du cache de niveau 2 et 1
        // Si les données changent en insert/delete, la liste est à jour
        // Mais pas forcément les updates
        List<Login> liste = query.getResultList();

        // Force le refresh des valeurs
        if (forceRefresh) {
            for (Login user : liste) {
                // em.refresh force le rafraichissement des
                // attributs de l'objet en mémoire en fonction
                // des dernières valeurs pour cet objet, dans la base
                // (au plus près du dernier commit)
                em.refresh(user);
            }
        }

        return liste;
    }

    public List<Login> chercherParNom(String nom) {
        getAllUsers(true);
        Query query = em.createQuery("select l from Login l where l.name = '" + nom + "'");
        return query.getResultList();
    }
    
      public List<Login> chercherParPassword(String pwd) {
        getAllUsers(true);
        Query query = em.createQuery("select l from Login l where l.password = '" + pwd + "'");
        return query.getResultList();
    }

    public boolean isConnected(String nom) {
        Collection<Login> result = chercherParNom(nom);

        return !result.isEmpty();
    }

    //savoir si user est client ou conseille
    public boolean getValidation(String pwd) {
        List<Personne> personnes = gestionnairePersonne.getPersonneByPwd(pwd);
        return (personnes.size() == 1);
        
    }
// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")
}
