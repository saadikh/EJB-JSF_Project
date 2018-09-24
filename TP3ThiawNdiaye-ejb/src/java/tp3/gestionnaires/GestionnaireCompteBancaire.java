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
import tp3.modeles.CompteBancaire;

@Stateless
@LocalBean
public class GestionnaireCompteBancaire {

    @PersistenceContext(unitName = "TP3ThiawNdiaye-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     public List<CompteBancaire> getAllComptesBancaires() {  
        Query query = em.createNamedQuery("CompteBancaire.findAll");  
        return query.getResultList();  
    }  
  
    public CompteBancaire update(CompteBancaire compteBancaire) {  
        return em.merge(compteBancaire);  
    }  
  
    public CompteBancaire getCompte(int idCompteBancaire) {  
        return em.find(CompteBancaire.class, idCompteBancaire);  
    }
}
