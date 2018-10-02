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

    public void persist(Object object) {
        em.persist(object);
    }

    public void creerAdresse(Adresse adr) {
        em.persist(adr);
    }

    public List<Adresse> getAllAdresses() {
        Query query = em.createNamedQuery("Adresse.findAll");
        return query.getResultList();
    }

    public Adresse update(Adresse adresse) {
        return em.merge(adresse);
    }

    public void deleteAdresse(Adresse adr) {
        em.remove(em.merge(adr));
    }

    public Adresse getAdresse(int id) {
        return em.find(Adresse.class, id);
    }

}
