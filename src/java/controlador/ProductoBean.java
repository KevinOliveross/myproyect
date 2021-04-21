/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ProductoDao;
import modelo.Producto;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Usuario
 */

@ManagedBean
@RequestScoped
public class ProductoBean {

    private BarChartModel barModel;
    private int Convertidor;
    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setPieModel(BarChartModel barModel) {
        this.barModel = barModel;
    }
    
    public void listar() throws SQLException, ClassNotFoundException{
        ProductoDao dao;
        List<Producto> lista;
        dao = new ProductoDao();
        lista = dao.listar();
        graficar(lista);
        try {
            
        } catch (Exception e) {
        }finally{
        }
    }
    
    public void graficar(List<Producto> lista){
        barModel = new BarChartModel();
        ChartSeries uno = new ChartSeries();
        for(Producto prod : lista){
            uno.set(prod.getNombre(), prod.getCodigo());
        }
        barModel.addSeries(uno);
        barModel.setTitle("Precios");
        barModel.setLegendPosition("e");
    }
    
}
