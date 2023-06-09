/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventatickets;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

/**
 *
 * @author slndr
 */
public class Validations {    
    
    /**
     * metodo para validar campos de tipo texto
     * 
     * @param texto campo de tipo texto a validar
     * @param mensaje mensaje de error
     * @return retorna el campo validado
     */
    public static String ValidarCampo(String texto, String mensaje){
        if (!texto.isBlank() && !texto.isEmpty() && !texto.equals("")) {
            return texto;
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
            return "";
        }   
    }
    
    /**
     * metodo para validar campos de tipo texto
     * 
     * @param texto campo de tipo texto a validar
     * @param mensaje mensaje de error
     * @return retorna el campo validado
     */
    public static double ValidarDouble(String texto, String mensaje){
        if (!texto.isBlank() && !texto.isEmpty() && !texto.equals("")) {
            try {
                double valor = Double.valueOf(texto);
                if (valor <= 0) {
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText(mensaje);
                    alert.initStyle(StageStyle.UTILITY);
                    alert.showAndWait();                   
                }
                return valor;
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(e.toString());
                alert.initStyle(StageStyle.UTILITY);
                alert.showAndWait();
                return 0;
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
            return 0;
        }   
    }
    
    /**
     * metodo para validar horas
     * 
     * @param hora recibe la hora en un texto
     * @param mensaje recibe el mensaje de error
     * @return retorna la hora en un string
     */
    public static String ValidarHora(String hora, String mensaje){
        String regex = "^([01]\\d|2[0-3]):([0-5]\\d)$";
        
        boolean isValid = Pattern.matches(regex, hora);
        
        if (isValid) {
            return hora;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
            return "";
        }
    }
    
    /**
     * metodo para validar fechas
     * 
     * @param fecha recibe un parametro de tipo LocalDate que representa la fecha
     * @param mensaje recibe un mensaje de error
     * @return retorna la fecha en string formato dd/MM/yyyy
     */
    public static String ValidarFecha(LocalDate fecha, String mensaje){
        if (fecha == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
            return "";
        }
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fecha.format(format);
    }
    
    /**
     * metodo para validar campos de tipo entero
     * 
     * @param numero el campo de tipo numero a validar
     * @param mensaje mensaje de error
     * @return el campo validado
     */
    public static int ValidarCampo(int numero, String mensaje){
        if (numero == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
            return 0;
        }else{
            return numero;
        }   
    }
    
    /**
     * metodo para validar campos de tipo correo
     * 
     * @param correo el campo de tipo numero a validar
     * @param mensaje mensaje de error
     * @return el campo validado
     */
    public static String ValidarCorreo(String correo, String mensaje){
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(correo);
        if (!matcher.matches()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.initStyle(StageStyle.UTILITY);
            alert.showAndWait();
            return "";
        }else{
            return correo;
        }   
    }
    
    /**
     * metodo para validar para generar alertas
     * 
     * @param mensaje recibe el mensaje que mostraremos en la alerta
     * @param tipo recibe el tipo de alerta 
     * @param titulo recibe el titulo de la alerta
     */
    public static void AlertMessage(String mensaje, AlertType tipo, String titulo){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.initStyle(StageStyle.UTILITY);
        alert.showAndWait();    
    }
}
