/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.app.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



/**
 *
 * @author juanf
 */
public class Conexion {
    
    public static Connection conexion;
    private static final String host  ="jdbc:mysql://localhost:3306/gimnasio";
    
    public Connection abrirConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(host,"root","Neverbroke1212");
            
            if(conexion != null){
                System.out.println("Conexion TRUE");
            }
            return conexion;
        }catch(Exception e){
            System.out.println("Error en la Conexion " + e);
        }
        return conexion;
    }
    
}
