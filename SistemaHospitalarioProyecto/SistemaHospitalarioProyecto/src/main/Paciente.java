/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import listas.ListaSimple;

/**
 *
 * @author pootb
 */
public class Paciente {
    
    protected String nombre;
    protected int gravedad;
    protected ListaSimple  historial;

    public Paciente(String nombre, int gravedad) {
        this.nombre = nombre;
        this.gravedad = gravedad;
        this.historial = new ListaSimple();
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the gravedad
     */
    public int getGravedad() {
        return gravedad;
    }

    /**
     * @param gravedad the gravedad to set
     */
    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }
    

    /**
     * @return the historial
     */
    public ListaSimple getHistorial() {
        return historial;
    }

    /**
     * @param historial the historial to set
     */
    public void setHistorial(ListaSimple historial) {
        this.historial = historial;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + getNombre() + ", Gravedad: " + getGravedad();
        
    }
    
    
}
