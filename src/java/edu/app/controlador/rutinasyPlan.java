/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entities.Cliente;
import edu.app.entities.Plannutricional;
import edu.app.entities.Rutina;
import edu.app.facade.RutinaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author juanf
 */
@Named(value = "rutinasyPlan")
@SessionScoped
public class rutinasyPlan implements Serializable {

    @EJB
    private RutinaFacadeLocal rutinafacadelocal;
    private ArrayList<Rutina> listarutina = new ArrayList<>();
    private int idCliente = loginView.getIdCliente();
    private ArrayList<Plannutricional> listaPlan = new ArrayList<>();

    public rutinasyPlan() {

    }

    @PostConstruct
    public void cargarRyP() {
        listarutina.addAll(rutinafacadelocal.findRoutineById(idCliente));
        listaPlan.addAll(rutinafacadelocal.findPlanById(idCliente));
    }

    public void  mostrarRutinas(){
        
    }
    
    public ArrayList<Rutina> getListaru() {
        return listarutina;
    }

    public void setListaru(ArrayList<Rutina> listaru) {
        this.listarutina = listaru;
    }
    public ArrayList<Plannutricional> getPlannutricional(){
        return listaPlan;
    }
    public void setListaPlan(ArrayList<Plannutricional>listaPlann){
        this.listaPlan = listaPlann;
    }
}
