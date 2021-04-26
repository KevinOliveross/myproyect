/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.controlador;

import com.csvreader.CsvReader;
import com.mysql.jdbc.PreparedStatement;
import edu.app.entities.Producto;
import edu.app.facade.ProductoFacadeLocal;
import edu.app.services.Conexion;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author juanf
 */
@Named(value = "productocsv")
@SessionScoped
public class productocsv implements Serializable {

    @EJB
    ProductoFacadeLocal productofacadelocal;

    Producto producto = new Producto();

    public productocsv() {
    }

    public void importarCsvs() {
        List<Producto> producto = new ArrayList<Producto>();

        producto = importarCsv();

        insertarMYSQL(producto);
    }

    public static List<Producto> importarCsv() {

        List<Producto> productos = new ArrayList<Producto>();
        try {
            CsvReader leerProducto = new CsvReader("C:\\Users\\juanf\\OneDrive\\Desktop\\gimnasioproyect\\producto.csv");
            leerProducto.readHeaders();
            while (leerProducto.readRecord()) {
                String precio = leerProducto.get(1);
                String nombre = leerProducto.get(0);
                int cantidad = Integer.parseInt(leerProducto.get(2));

                productos.add(new Producto(precio, nombre, cantidad));
            }

            leerProducto.close();

            System.out.println("Lista de productos");
            for (Producto pro : productos) {
                System.out.println(pro.getIdproducto() + " " + pro.getNombre() + " " + pro.getPrecio());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erro en importar -> " + e);
        } catch (IOException e) {
            System.out.println("Error IOE " + e);
        }
        return productos;
    }

    public static void insertarMYSQL(List<Producto> producto) {

        Conexion con = new Conexion();
        Connection cn = con.abrirConexion();
        String query = "INSERT INTO producto(nombre,precio,cantidad) VALUES (?,?,?)";
        try {
            PreparedStatement ps = (PreparedStatement) cn.prepareStatement(query);
            for (int i = 0; i < producto.size(); i++) {
                ps.setString(1, producto.get(i).getNombre());
                ps.setString(2, producto.get(i).getPrecio());
                ps.setInt(3, producto.get(i).getCantidad());

                ps.executeUpdate();

                System.out.println("Se incerto " + (1 + i) + " / " + producto.size());
            }
            ps.close();
            cn.close();
        } catch (SQLException e) {

        }
    }

}
