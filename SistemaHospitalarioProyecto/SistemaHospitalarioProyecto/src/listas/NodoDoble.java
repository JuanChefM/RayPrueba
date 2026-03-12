/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

/**
 *
 * @author jorge.reyes
 */
public class NodoDoble extends Nodo{
    protected NodoDoble siguiente;
    protected NodoDoble anterior;

    public NodoDoble(){}
    
    public NodoDoble(Object dato, NodoDoble siguiente, NodoDoble anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }
    
    public NodoDoble(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    /**
     * @return the siguiente
     */
    public NodoDoble getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * @return the anterior
     */
    public NodoDoble getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "NodoDoble{" + "siguiente=" + siguiente + ", anterior=" + anterior + '}';
    }
    
    
    
}
