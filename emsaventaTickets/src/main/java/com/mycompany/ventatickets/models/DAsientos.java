/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventatickets.models;

import com.mycompany.ventatickets.Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * clase que manipula la data de los asientos
 * @author slndr
 */
public class DAsientos {
    
     /**
     * constructor por defecto de la clase DAsientos 
     * 
     */
    public DAsientos(){
    
    }
    
        /**
     * Devuelve una lista de asientos basada en las columnas y el lado especificados.
     * 
     * @param columns Las columnas de los asientos a buscar.
     * @param lado El lado de los asientos a buscar.
     * @return Una lista de asientos que coinciden con los criterios especificados.
     */
    public ArrayList<Asientos> ListAsientos(String columns, String lado){
        
         ArrayList<Asientos> listAsientos = new ArrayList<>();
         
         try (Connection conn = Conexion.getConection()) {
             
             StringBuilder query = new StringBuilder();
             query.append("select * from asientos as a ");
             query.append("inner join secciones as s ");
             query.append("on a.idseccion = s.idseccion ");
             query.append(String.format("where fila in (%s) and lado = ? order by fila, lado", columns));

             PreparedStatement sql = conn.prepareStatement(query.toString());
             sql.setString(1, lado);
     
             ResultSet resultado = sql.executeQuery();
             
             while(resultado.next()){
                Asientos asientos = new Asientos();
                Seccions section = new Seccions(); 
                asientos.setId(resultado.getInt("idasiento"));
                asientos.setFile(resultado.getString("fila"));  
                asientos.setColumn(resultado.getInt("columna"));
                asientos.setLado(resultado.getString("lado"));
                asientos.setIdSection(resultado.getInt("idseccion"));
                asientos.setActive(resultado.getBoolean("activo"));
                section.setId(resultado.getInt("idseccion"));
                section.setDescription(resultado.getString("descripcion"));
                asientos.setSection(section);                 
                 
                listAsientos.add(asientos);
             }
             
         } catch (SQLException ex) { 
             System.out.println("hubo un error" + ex.toString());
         }      
         
         return listAsientos;
    }
    
    public ArrayList<Asientos> ListAsientos(){
        
         ArrayList<Asientos> listAsientos = new ArrayList<>();
         
         try (Connection conn = Conexion.getConection()) {
             
             StringBuilder query = new StringBuilder();
             query.append("select * from asientos as a ");
             query.append("inner join secciones as s ");
             query.append("on a.idseccion = s.idseccion ");
             query.append("order by fila, lado");

             PreparedStatement sql = conn.prepareStatement(query.toString());
     
             ResultSet resultado = sql.executeQuery();
             
             while(resultado.next()){
                Asientos asientos = new Asientos();
                Seccions section = new Seccions(); 
                asientos.setId(resultado.getInt("idasiento"));
                asientos.setFile(resultado.getString("fila"));  
                asientos.setColumn(resultado.getInt("columna"));
                asientos.setLado(resultado.getString("lado"));
                asientos.setIdSection(resultado.getInt("idseccion"));
                asientos.setActive(resultado.getBoolean("activo"));
                section.setId(resultado.getInt("idseccion"));
                section.setDescription(resultado.getString("descripcion"));
                asientos.setSection(section);                 
                 
                listAsientos.add(asientos);
             }
             
         } catch (SQLException ex) { 
             System.out.println("hubo un error" + ex.toString());
         }      
         
         return listAsientos;
    }
    
     public boolean ModifyAsiento(Asientos asiento){
        boolean results = false;
        
         try (Connection conn = Conexion.getConection()) {
             StringBuilder query = new StringBuilder();
             query.append("update asientos set fila = ?, columna = ?, lado = ?, idseccion = ?, activo = ? ");
             query.append("where idasiento = ?");
             
             PreparedStatement sql = conn.prepareStatement(query.toString());
             sql.setString(1, asiento.getFile());
             sql.setInt(2, asiento.getColumn());
             sql.setString(3,asiento.getLado());
             sql.setInt(4, asiento.getIdSection());
             sql.setBoolean(5, asiento.isActive());
             sql.setInt(6, asiento.getId());            
             
             int rowAffected = sql.executeUpdate();
             
             results = rowAffected != 0;
             
         } catch (SQLException ex) { 
             System.out.println("hubo un error " + ex.toString());
         }      
         
         return results;        
    }
}
