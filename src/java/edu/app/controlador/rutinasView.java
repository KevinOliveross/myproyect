/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;


import edu.app.entities.Rutina;
import edu.app.facade.ClienteFacadeLocal;
import edu.app.facade.RutinaFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author kevin
 */
@Named(value = "rutinasView")
@ViewScoped
public class rutinasView implements Serializable {

    private Rutina objRutina;

    private int idrutina;

    private String tipoMensajeR = "";

    private ArrayList<Rutina> listRutinas = new ArrayList<>();

    private int idClient;
    private Rutina actualizarRuti = new Rutina();

    /**
     * Creates a new instance of rutinasView
     */
    @EJB
    ClienteFacadeLocal ClienteFacadeLocal;

    @EJB
    RutinaFacadeLocal RutinaFacadeLocal;
    
    private int idCliente =1000121212;
   

    public rutinasView() {
    }

    @PostConstruct
    public void init() {
       
        listRutinas.addAll(RutinaFacadeLocal.findAll());

    }

    public void crearRutina() {
        try {

            RutinaFacadeLocal.create(objRutina);
            tipoMensajeR = "rutinaCreada";
             FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect("../../instructor/rutina/index.xhtml");


        } catch (Exception e) {
            tipoMensajeR = "rutinaNoCreada";
            System.out.println("edu.app.controlador.InstructorvView.crearRutina()" + e.getMessage());

        }

    }

    public void eliminarRutina(Rutina rutiEliminar) {
        try {
            RutinaFacadeLocal.remove(rutiEliminar);

            listRutinas.remove(rutiEliminar);

        } catch (Exception e) {

            System.out.println("edu.app.controlador.InstructorView.eliminarCliente()" + e.getMessage());

        }
    }

    public void actualizar() {

        try {
            RutinaFacadeLocal.edit(objRutina);
            objRutina = new Rutina();
            tipoMensajeR = "actualizado";
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect("../../instructor/rutina/index.xhtml");

        } catch (Exception e) {
            tipoMensajeR = "noActualizado";
            System.out.println("edu.app.controlador.ListaRutinasView.actualizar()" + e.getMessage());
        }
    }



    public Rutina getObjRutina() {
        return objRutina;
    }

    public void setObjRutina(Rutina objRutina) {
        this.objRutina = objRutina;
    }

    public String getTipoMensajeR() {
        return tipoMensajeR;
    }

    public void setTipoMensajeR(String tipoMensajeR) {
        this.tipoMensajeR = tipoMensajeR;
    }

    public ArrayList<Rutina> getListRutinas() {
        return listRutinas;
    }

    public void setListRutinas(ArrayList<Rutina> listRutinas) {
        this.listRutinas = listRutinas;
    }

    public int getIdrutina() {
        return idrutina;
    }

    public void setIdrutina(int idrutina) {
        this.idrutina = idrutina;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }


}
