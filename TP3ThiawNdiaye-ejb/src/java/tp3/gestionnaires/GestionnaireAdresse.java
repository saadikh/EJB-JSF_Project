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


@Stateless
@LocalBean
public class GestionnaireAdresse {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext(unitName = "TP3ThiawNdiaye-ejbPU") 
    private EntityManager em; 
     
 
        public List<CompteBancaire> getAllAdresses() {   
        Query query = em.createNamedQuery("Adresse.findAll");   
        return query.getResultList(); 
    }   
       
        public Adresse update(Adresse adresse) {   
        return em.merge(adresse);   
    }   
   
    public Adresse getAdresse(int id) {   
        return em.find(Adresse.class, id);   
    } 
 
    public void persist(Object object) { 
        em.persist(object); 
} 
}
