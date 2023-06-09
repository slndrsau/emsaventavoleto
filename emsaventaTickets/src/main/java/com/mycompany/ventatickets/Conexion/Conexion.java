/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventatickets.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Esta es la conexion
 * @author slndr
 */

public class Conexion {    
    private static String URL = "jdbc:postgresql://emsarodriguez.postgres.database.azure.com";
    private static String USER = "orodriguez";
    private static String PASSWORD = "527267Gs";
   // private static final String URL = "jdbc:postgresql://localhost:5432/tickets";
   // private static final String USER = "postgres";
   // private static final String PASSWORD = "andrea2911";
    
    
     /**
     * Constructor predeterminado de la clase Conexion.
     * Permite establecer una conexión a la base de datos.
     */
    public Conexion() {
        // Código del constructor
    }    
    
   /**
      *Obtiene una instancia de nuestra conexion
      *
      * @return la conexion.
      */
    public static Connection getConection(){
       try{
           Connection connection = DriverManager.getConnection(URL,USER, PASSWORD);            
           return connection;
       }
       catch (SQLException e) {
           System.out.println(e.toString());
           return null;
       }
    }
}
