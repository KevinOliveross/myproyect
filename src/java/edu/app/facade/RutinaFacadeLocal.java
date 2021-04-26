/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.facade;

import edu.app.entities.Plannutricional;
import edu.app.entities.Rutina;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author kevin
 */
@Local
public interface RutinaFacadeLocal {

    void create(Rutina rutina);

    void edit(Rutina rutina);

    void remove(Rutina rutina);

    Rutina find(Object id);

    List<Rutina> findAll();

    List<Rutina> findRange(int[] range);

    int count();

    public List<Rutina> findRoutineById(int idCliente);

    public List<Plannutricional> findPlanById(int idCliente);
    
}
