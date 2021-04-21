/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.facade;

import edu.app.entities.Plannutricional;
import edu.app.entities.PlannutricionalPK;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kevin
 */
@Stateless
public class PlannutricionalFacade extends AbstractFacade<Plannutricional> implements PlannutricionalFacadeLocal {

    @PersistenceContext(unitName = "GymPeopleProyectPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlannutricionalFacade() {
        super(Plannutricional.class);
    }

    @Override
    public void create(PlannutricionalPK objplanPK) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
