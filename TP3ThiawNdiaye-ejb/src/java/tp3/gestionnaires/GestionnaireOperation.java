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
import tp3.modeles.Operations;

@Stateless
@LocalBean
public class GestionnaireOperation {

    @PersistenceContext(unitName = "TP3ThiawNdiaye-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    
    
    
        public List<Operations> getAllOperation() {
        Query query = em.createNamedQuery("Operations.findAll");
        return query.getResultList();
    }
    
     public Operations depotSomme (Operations operations) {
        return em.merge(operations);
    }
     
     public Operations retraitSomme (Operations operations) {
        return em.merge(operations);
       
    }
     
      public Operations virement (Operations operations) {
        return em.merge(operations);
    }
      
       public Operations versement (Operations operations) {
        return em.merge(operations);
    }
 
} 
     

    
    

