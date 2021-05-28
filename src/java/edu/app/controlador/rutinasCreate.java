/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entities.Cliente;
import edu.app.entities.Rutina;
import edu.app.facade.ClienteFacadeLocal;
import edu.app.facade.RutinaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author kevin
 */
@Named(value = "rutinasCreate")
@ViewScoped
public class rutinasCreate implements Serializable{

    /**
     * Creates a new instance of rutinasCreate
     */
    
    
    private Rutina objRutinas;
    private String mensajeAlert ="";
    private ArrayList<Rutina> listaRutinas = new ArrayList<>();
    
    @EJB
    RutinaFacadeLocal rutinaFacadeLocal;
    ClienteFacadeLocal clienteFacadeLocal;
    
    
    public rutinasCreate() {
    }
    
    @PostConstruct
    public void cargaRutinas(){
        listaRutinas.addAll(rutinaFacadeLocal.findAll());
       
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    public Rutina getObjRutinas() {
        return objRutinas;
    }

    public void setObjRutinas(Rutina objRutinas) {
        this.objRutinas = objRutinas;
    }

    public String getMensajeAlert() {
        return mensajeAlert;
    }

    public void setMensajeAlert(String mensajeAlert) {
        this.mensajeAlert = mensajeAlert;
    }

    public ArrayList<Rutina> getListaRutinas() {
        return listaRutinas;
    }

    public void setListaRutinas(ArrayList<Rutina> listaRutinas) {
        this.listaRutinas = listaRutinas;
    }
    
}
