/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colas;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jorge.reyes
 */
public class NodoPrioridad implements Comparable{
    protected int prioridad;
    protected Object dato;

    public NodoPrioridad(int prioridad, Object dato) {
        this.prioridad = prioridad;
        this.dato = dato;
    }
    
    public String toString(){
        return prioridad + ":" + dato;
    }
    
    @Override
    public int compareTo(Object o) {
        if (this.prioridad < ((NodoPrioridad)o).prioridad)
            return -1;
        else if (this.prioridad > ((NodoPrioridad)o).prioridad) 
            return 1;
        else
            return 0;
    }

    /**
     * @return the prioridad
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }
    
    public static void main(String[] args) {
        ArrayList datos = new ArrayList();
        datos.add(new NodoPrioridad(25,"Holaa1"));
        datos.add(new NodoPrioridad(23,"Holaa2"));
        datos.add(new NodoPrioridad(5,"Holaa3"));
        datos.add(new NodoPrioridad(80,"Holaa4"));
        datos.add(new NodoPrioridad(4,"Holaa5"));
        Collections.sort(datos);
        System.out.println(datos);
    }
}
