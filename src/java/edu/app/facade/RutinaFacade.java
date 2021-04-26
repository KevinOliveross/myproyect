/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.facade;

import edu.app.entities.Plannutricional;
import edu.app.entities.Rutina;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kevin
 */
@Stateless
public class RutinaFacade extends AbstractFacade<Rutina> implements RutinaFacadeLocal {

    @PersistenceContext(unitName = "GymPeopleProyectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RutinaFacade() {
        super(Rutina.class);
    }
    
    
    public List<Rutina> findRoutineById(int idCliente) {
        try {
            Query qt = em.createQuery("SELECT c FROM Rutina c WHERE c.clienteId = :id");
            qt.setParameter("id",idCliente);
            List<Rutina> lista = qt.getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("El error para tener las rutinas -> " + e);
            return (List<Rutina>) new Rutina();
        }
    }
    
    public List<Plannutricional> findPlanById(int idCliente){
                try {
            Query qt = em.createQuery("SELECT c From Plannutricional c WHERE c.clienteId  = :id");
            qt.setParameter("id",idCliente);
            List<Plannutricional> lista = qt.getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("El error para tener las rutinas -> " + e);
            return (List<Plannutricional>) new Rutina();
        }
    }
    
}
