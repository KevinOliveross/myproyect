/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import edu.app.conexion.RutinaConexion;
import edu.app.model.Rutina;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author kevin
 */
@Named(value = "graficaRutina")
@RequestScoped
public class graficaRutina {

    /**
     * Creates a new instance of graficaRutina
     */
    
    private PieChartModel pieModel;
    
    public graficaRutina() {
    }
    
    
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }
    
    
    public void listar() throws SQLException, ClassNotFoundException{
        RutinaConexion dao;
        List<Rutina> lista;
        dao = new RutinaConexion();
        lista = dao.listar();
        graficar(lista);
        try{
            
        }catch(Exception e){
            
        } finally{
            
        }
        
        
        
    }
    
    public void graficar (List<Rutina> lista){
        pieModel = new PieChartModel();
        
        for (Rutina prod : lista){
            pieModel.set(prod.getTemaRutina(), prod.getIdcliente());
            
        }
        
        pieModel.setTitle("Rutinas");
        pieModel.setLegendPosition("e");
        pieModel.setFill(false);
        pieModel.setShowDataLabels(true);
        pieModel.setDiameter(150);
    }
    
}
