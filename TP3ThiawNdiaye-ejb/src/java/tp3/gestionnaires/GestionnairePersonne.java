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
import tp3.modeles.Personne;


@Stateless
@LocalBean
public class GestionnairePersonne {

    @PersistenceContext(unitName = "TP3ThiawNdiaye-ejbPU")
    private EntityManager em;
     public void persist(Object object) {
        em.persist(object);
    }
    
        public List<Personne> getAllPersonnes() {  
        Query query = em.createNamedQuery("Personne.findAll");  
        return query.getResultList();
    }  
      
        public Personne update(Personne personne) {  
        return em.merge(personne);  
    }  
  
    public Personne getCarte(int id) {  
        return em.find(Personne.class, id);  
}
}
