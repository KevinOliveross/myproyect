/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.conexion;

import edu.app.model.Rutina;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class RutinaConexion {
    
     public List<Rutina> listar() throws SQLException, ClassNotFoundException{
        List<Rutina> lista =null;
        Connection cn=null;
        ResultSet rs;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gimnasio","root","Neverbroke1212");
            PreparedStatement st = cn.prepareStatement("select idrutina, idcliente, temaRutina from rutina");
            rs=st.executeQuery();
            lista =new ArrayList();
            while(rs.next()){
                Rutina pro = new Rutina();
                pro.setIdrutina(rs.getInt("idrutina"));
                
                pro.setIdcliente(rs.getInt("idcliente"));
                pro.setTemaRutina(rs.getString("temaRutina"));
                lista.add(pro);
                
            }
            rs.close();
            
            
        } catch (Exception e) {
            
        } finally {
            if (cn != null){
                cn.close();
            }
        }
        
        
        
        
            
                
                
                
         return lista;       
    }
    
    
}
