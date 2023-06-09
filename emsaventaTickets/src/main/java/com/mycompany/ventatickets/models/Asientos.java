/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventatickets.models;

/**
 * clase para el modelo de asientos
 * @author slndr
 */
public class Asientos {
    private int id;
    private String file;
    private int column;
    private String lado;
    private int idSection;
    private boolean active;
    private Seccions section = new Seccions();
    
    
    public Asientos() {
    }

    
    public int getId() {
        return id;
    }

    /**
     * Asigna valor al Id
     * 
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    
    public String getFile() {
        return file;
    }

    
    public void setFile(String file) {
        this.file = file;
    }

    
    public int getColumn() {
        return column;
    }

    
    public void setColumn(int column) {
        this.column = column;
    }

    
    public String getLado() {
        return lado;
    }

    
    public void setLado(String lado) {
        this.lado = lado;
    }

   
    public int getIdSection() {
        return idSection;
    }

    
    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    
    public Seccions getSection() {
        return section;
    }

    
    public void setSection(Seccions section) {
        this.section = section;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
