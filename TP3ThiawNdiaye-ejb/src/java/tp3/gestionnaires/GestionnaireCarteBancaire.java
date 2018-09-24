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
import tp3.modeles.CarteBancaire;


@Stateless
@LocalBean
public class GestionnaireCarteBancaire {

     @PersistenceContext(unitName = "TP3ThiawNdiaye-ejbPU")
    private EntityManager em;
     public void persist(Object object) {
        em.persist(object);
    }
     
        public List<CompteBancaire> getAllCartesBancaires() {   
        Query query = em.createNamedQuery("CarteBancaire.findAll");   
        return query.getResultList(); 
    }   
       
        public CarteBancaire update(CarteBancaire carteBancaire) {   
        return em.merge(carteBancaire);   
    }   
   
    public CarteBancaire getCarte(int idCarteBancaire) {   
        return em.find(CarteBancaire.class, idCarteBancaire);   
} 
}
