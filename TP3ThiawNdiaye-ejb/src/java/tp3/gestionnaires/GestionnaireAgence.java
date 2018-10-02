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
import tp3.modeles.Agence;


@Stateless
@LocalBean
public class GestionnaireAgence {

    @PersistenceContext(unitName = "TP3ThiawNdiaye-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }

    public List<Agence> getAllAgences() {
        Query query = em.createNamedQuery("Agence.findAll");
        return query.getResultList();
    }

    public Agence update(Agence ag) {
        return em.merge(ag);
    }

    public Agence getAgence(int idAgence) {
        return em.find(Agence.class, idAgence);
    }

    public void creerAgence(Agence ag) {
        em.persist(ag);
    }

    public void deleteAgence(Agence ag) {
        em.remove(em.merge(ag));
    }
}
