/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import com.csvreader.CsvReader;
import edu.app.entities.Producto;
import edu.app.facade.ProductoFacadeLocal;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author kevin
 */
@Named(value = "registropro")
@ViewScoped
public class registropro implements Serializable {

    @EJB
    ProductoFacadeLocal productoFacadeLocal;
    private int idProducto;
    private int Precio;
    private UploadedFile file;
    private int idPro;
    private Producto actualizarPro = new Producto();
    private Producto ojbPro = new Producto();
    private ArrayList<Producto> Listaproducto = new ArrayList<>();
    private String tipoMensajePro = "";

    /**
     * Creates a new instance of registropro
     */
    public registropro() {
    }

    @PostConstruct
    public void init() {
        Listaproducto.addAll(productoFacadeLocal.findAll());
    }

    public Producto getOjbPro() {
        return ojbPro;
    }

    public void setOjbPro(Producto ojbPro) {
        this.ojbPro = ojbPro;
    }

    public ArrayList<Producto> getListaproducto() {
        return Listaproducto;
    }

    public void setListaproducto(ArrayList<Producto> Listaproducto) {
        this.Listaproducto = Listaproducto;
    }

    public String getTipoMensajePro() {
        return tipoMensajePro;
    }

    public void setTipoMensajePro(String tipoMensajePro) {
        this.tipoMensajePro = tipoMensajePro;
    }
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }
    public void registrarPro() {

        try {
            productoFacadeLocal.create(ojbPro);
            tipoMensajePro = "productoCreado";
        } catch (Exception e) {
            tipoMensajePro = "productoNoCreado";
            System.out.println("Error!");
        }
    }

    public void eliminarProd(Producto eliminarproducto) {
        try {
            productoFacadeLocal.remove(eliminarproducto);
            Listaproducto.remove(eliminarproducto);
        } catch (Exception e) {
            System.out.println("Error!");
        }

    }

    public void actualizar() {
        try {
            productoFacadeLocal.edit(ojbPro);
            ojbPro = new Producto();
            tipoMensajePro = "actualizadoP";

        } catch (Exception e) {
            tipoMensajePro = "noActualizadoP";
            System.out.println("edu.app.controlador.ListaRutinasView.actualizar()" + e.getMessage());
        }
    }

    public void actualizarPro() {
        try {
            idPro = this.ojbPro.getIdproducto();
            actualizarPro = productoFacadeLocal.find(idPro);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.getExternalContext().redirect("../../administracion/producto/index.xhtml");



            System.out.println("Producto Encontrado" + actualizarPro.getNombre());
            if (actualizarPro != null) {
                 actualizarPro.setIdproducto(this.ojbPro.getIdproducto());
                productoFacadeLocal.edit(actualizarPro);
                System.out.println("Producto Actualizado" + actualizarPro.getIdproducto());
                actualizarPro.setNombre(this.ojbPro.getNombre());
                productoFacadeLocal.edit(actualizarPro);
                System.out.println("Producto Actualizado" + actualizarPro.getNombre());
                actualizarPro.setPrecio(this.ojbPro.getPrecio());
                productoFacadeLocal.edit(actualizarPro);
                System.out.println("Producto Actualizado"+ actualizarPro.getPrecio());
                 actualizarPro.setCantidad(this.ojbPro.getCantidad());
                productoFacadeLocal.edit(actualizarPro);
                System.out.println("Producto Actualizado" + actualizarPro.getCantidad());
                
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }
    
    public void upload(){
        
        if(file!=null){
            
            
            try{
                
                System.out.println("");
                CsvReader leerProducto;
                leerProducto = new CsvReader(new InputStreamReader(file.getInputstream()));
                
                
                leerProducto.readHeaders();
                
                while(leerProducto.readRecord()){
                  
                    this.ojbPro = new Producto();
                    System.out.println("Este es el id del producto"+ idProducto);
                    System.out.println("Este es el precio del producto"+ Precio);
                    
                    this.ojbPro.setNombre(leerProducto.get(0));
                    this.ojbPro.setPrecio(leerProducto.get(1));
                    
                    productoFacadeLocal.create(ojbPro);
                    //usuariosFacade.create(usuarios);
                    
                }
                FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
             }   catch (IOException e) {
                e.printStackTrace();
            }
        }
}


}