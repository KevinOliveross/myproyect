/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDao {

    public List<Producto> listar() throws SQLException, ClassNotFoundException {
        List<Producto> lista = null;
        Connection cn = null;
        ResultSet rs;
        try {
            Class.forName("com.mysql.jdbc.Driver");
             cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimnasio","root","24112000");
             PreparedStatement st = cn.prepareStatement("select idproducto,nombre,cantidad from producto");
            rs = st.executeQuery();
            lista = new ArrayList();
            System.out.println("Conexion exitosa");
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setCodigo(rs.getInt("idproducto"));
                pro.setNombre(rs.getString("nombre"));
                pro.setCantidad(rs.getString("cantidad"));
                lista.add(pro);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println("Conexion fallida");
        } finally {
            if (cn != null) {
                cn.close();
            }
        }
        return lista;
    }
}
