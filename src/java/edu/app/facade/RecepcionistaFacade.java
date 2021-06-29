/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.facade;

import edu.app.entities.Recepcionista;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author kevin
 */
@Stateless
public class RecepcionistaFacade extends AbstractFacade<Recepcionista> implements RecepcionistaFacadeLocal {

    @PersistenceContext(unitName = "GymPeopleProyectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecepcionistaFacade() {
        super(Recepcionista.class);
    }

    @Override
    public Recepcionista validarRece(String emailRecep, String passwordRecep) {

        try {

            Query consulta = em.createQuery("SELECT r FROM Recepcionista r WHERE r.contrasenia = :passwordRecep AND r.correo = :emailRecep");
            consulta.setParameter("passwordRecep", passwordRecep);
            consulta.setParameter("emailRecep", emailRecep);
            return (Recepcionista) consulta.getSingleResult();

        } catch (Exception e) {
            System.out.println("El error en la validacion " + e.getMessage());
            return new Recepcionista();
        }

    }

}
