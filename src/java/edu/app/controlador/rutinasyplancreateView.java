/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entities.Cliente;
import edu.app.entities.Instructor;
import edu.app.entities.Plannutricional;
import edu.app.entities.Rutina;
import edu.app.facade.ClienteFacadeLocal;
import edu.app.facade.InstructorFacadeLocal;
import edu.app.facade.PlannutricionalFacadeLocal;
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
@Named(value = "rutinasyplancreateView")
@ViewScoped
public class rutinasyplancreateView implements Serializable {

    /**
     * Creates a new instance of rutinasCreate
     */
    private Rutina objRutinas;
    private String mensajeAlert = "";
    private ArrayList<Rutina> listaRutinas = new ArrayList<>();
    private ArrayList<Plannutricional> listPlanesNutri = new ArrayList<>();
    int objCliee;
    private String tipoMensajeR = "";
    private Instructor objidIns = new Instructor();
    private Cliente objidClien = new Cliente();
    private int idIns;
    private int idClie;

    @EJB
    RutinaFacadeLocal rutinaFacadeLocal;
    ClienteFacadeLocal clienteFacadeLocal;
    InstructorFacadeLocal instructorFacadeLocal;
    PlannutricionalFacadeLocal PlannutricionalFacadeLocal;

    public rutinasyplancreateView() {
    }

    @PostConstruct
    public void cargaRutinas() {
        objRutinas = new Rutina();
        objRutinas.setClienteId(idClie);
        objRutinas.setInstructorId(idIns);

        listaRutinas.addAll(rutinaFacadeLocal.findAll());
        

    }

    public void crearRutina() {
        try {

            idIns = this.objidIns.getId();
            idClie = this.objidClien.getId();

            rutinaFacadeLocal.create(objRutinas);
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
            rutinaFacadeLocal.remove(rutiEliminar);

            listaRutinas.remove(rutiEliminar);

        } catch (Exception e) {

            System.out.println("edu.app.controlador.InstructorView.eliminarCliente()" + e.getMessage());

        }
    }

    public void actualizar() {

        try {
            rutinaFacadeLocal.edit(objRutinas);
            objRutinas = new Rutina();
            tipoMensajeR = "actualizado";
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect("../../instructor/rutina/index.xhtml");

        } catch (Exception e) {
            tipoMensajeR = "noActualizado";
            System.out.println("edu.app.controlador.ListaRutinasView.actualizar()" + e.getMessage());
        }
    }
    
       public void eliminarPlan(Plannutricional PlanEliminar) {
        try {
            PlannutricionalFacadeLocal.remove(PlanEliminar);

            listPlanesNutri.remove(PlanEliminar);

        } catch (Exception e) {

            System.out.println("edu.app.controlador.InstructorView.eliminarCliente()" + e.getMessage());

        }
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

    public String getTipoMensajeR() {
        return tipoMensajeR;
    }

    public void setTipoMensajeR(String tipoMensajeR) {
        this.tipoMensajeR = tipoMensajeR;
    }

    public Rutina getObjRutinas() {
        return objRutinas;
    }

    public void setObjRutinas(Rutina objRutinas) {
        this.objRutinas = objRutinas;
    }

    public Cliente getObjidClien() {
        return objidClien;
    }

    public void setObjidClien(Cliente objidClien) {
        this.objidClien = objidClien;
    }

    public int getIdIns() {
        return idIns;
    }

    public void setIdIns(int idIns) {
        this.idIns = idIns;
    }

    public int getIdClie() {
        return idClie;
    }

    public void setIdClie(int idClie) {
        this.idClie = idClie;
    }

    public Instructor getObjidIns() {
        return objidIns;
    }

    public void setObjidIns(Instructor objidIns) {
        this.objidIns = objidIns;
    }

    public ArrayList<Plannutricional> getListPlanesNutri() {
        return listPlanesNutri;
    }

    public void setListPlanesNutri(ArrayList<Plannutricional> listPlanesNutri) {
        this.listPlanesNutri = listPlanesNutri;
    }

}
