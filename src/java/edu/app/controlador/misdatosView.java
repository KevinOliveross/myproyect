/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entities.Ordencompra;
import edu.app.facade.OrdencompraFacadeLocal;
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
@Named(value = "misdatosView")
@SessionScoped
public class misdatosView implements Serializable {

    @EJB
    OrdencompraFacadeLocal ordencomprafacadelocal;
    /**
     * Creates a new instance of misdatosView
     */
    public misdatosView() {
    }
    
    
    private ArrayList<Ordencompra> listaordenes = new ArrayList<>();
    
    @PostConstruct
    public void cargainicial(){
        listaordenes.addAll(ordencomprafacadelocal.findAll());
    }

    public ArrayList<Ordencompra> getListaordenes() {
        return listaordenes;
    }

    public void setListaordenes(ArrayList<Ordencompra> listaordenes) {
        this.listaordenes = listaordenes;
    }
    
    
}
