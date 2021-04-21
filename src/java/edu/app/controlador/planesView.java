/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.entities.Cliente;
import edu.app.entities.Instructor;
import edu.app.entities.Plannutricional;
import edu.app.entities.PlannutricionalPK;
import edu.app.facade.ClienteFacadeLocal;
import edu.app.facade.PlannutricionalFacadeLocal;
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
@Named(value = "planesView")
@ViewScoped
public class planesView implements Serializable {

    /**
     * Creates a new instance of planesView
     */
    public planesView() {

    }

    private Plannutricional obDiaPlan;
    private Cliente objCliente;
    private Instructor objInstructor;
 private int objId; 
    private String tipoMensajeR = "";
    private ArrayList<Plannutricional> listPlanesNutri = new ArrayList<>();
    private int idCliente = 1000;
    private int idInst = 1000;
    private PlannutricionalPK objplanPK;

    @EJB

    PlannutricionalFacadeLocal PlannutricionalFacadeLocal;
    ClienteFacadeLocal ClienteFacadeLocal;

    @PostConstruct
    public void init() {
           
            
        
        obDiaPlan = new Plannutricional();
        objplanPK = new PlannutricionalPK();
        objplanPK.setClienteId(idCliente);
        objplanPK.setInstructorId(objId);
        listPlanesNutri.addAll(PlannutricionalFacadeLocal.findAll());
        
       
        

    }

    public void crearPlan() {
        try {
            
            
            PlannutricionalFacadeLocal.create(obDiaPlan);
            PlannutricionalFacadeLocal.create(objplanPK);
           
            tipoMensajeR = "planCreada";
            
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect("../../instructor/planes/index.xhtml");

        } catch (Exception e) {
            tipoMensajeR = "planNoCreada";
            System.out.println("edu.app.controlador.InstructorvView.crearRutina()" + e.getMessage());

        }

    }

    public void actualizar() {
        try {
            PlannutricionalFacadeLocal.edit(obDiaPlan);
            obDiaPlan = new Plannutricional();
            tipoMensajeR = "actualizadoP";
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect("../../instructor/planes/index.xhtml");

        } catch (Exception e) {
            tipoMensajeR = "noActualizadoP";
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

    public String getTipoMensajeR() {
        return tipoMensajeR;
    }

    public void setTipoMensajeR(String tipoMensajeR) {
        this.tipoMensajeR = tipoMensajeR;
    }

    public ArrayList<Plannutricional> getListPlanesNutri() {
        return listPlanesNutri;
    }

    public void setListPlanesNutri(ArrayList<Plannutricional> listPlanesNutri) {
        this.listPlanesNutri = listPlanesNutri;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public PlannutricionalPK getObjplanPK() {
        return objplanPK;
    }

    public void setObjplanPK(PlannutricionalPK objplanPK) {
        this.objplanPK = objplanPK;
    }

  

    public int getIdInst() {
        return idInst;
    }

    public void setIdInst(int idInst) {
        this.idInst = idInst;
    }

    public Cliente getObjCliente() {
        return objCliente;
    }

    public void setObjCliente(Cliente objCliente) {
        this.objCliente = objCliente;
    }

    public Instructor getObjInstructor() {
        return objInstructor;
    }

    public void setObjInstructor(Instructor objInstructor) {
        this.objInstructor = objInstructor;
    }

    public Plannutricional getObDiaPlan() {
        return obDiaPlan;
    }

    public void setObDiaPlan(Plannutricional obDiaPlan) {
        this.obDiaPlan = obDiaPlan;
    }

    public int getObjId() {
        return objId;
    }

    public void setObjId(int objId) {
        this.objId = objId;
    }

}
