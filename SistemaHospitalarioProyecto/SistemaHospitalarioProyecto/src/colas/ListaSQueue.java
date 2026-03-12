/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colas;

import listas.ListaSimple;

/**
 *
 * @author jorge.reyes
 */
public class ListaSQueue implements Queue{
    protected ListaSimple lista;
    protected int cont;
    
    public ListaSQueue(){
        lista = new ListaSimple();
        cont = 0;
    }
    
    @Override
    public void enqueue(Object dato) {
        lista.insertaFinal(dato);
        cont++;
    }

    @Override
    public Object dequeue() {
        if (lista.vacio()){
            System.out.println("Cola vacía");
            return null;
        }
        else{
            cont--;
            return lista.eliminaInicio();
        }
    }

    @Override
    public int size() {
        return cont;
    }

    @Override
    public Object front() {
        if (lista.vacio()){
            System.out.println("Cola vacía");
            return null;
        }
        else{
            return lista.getInicio().getDato();
        }
    }

    @Override
    public boolean isEmpty() {
        return lista.vacio();
    }
    
    public void imprimir(){
        lista.imprimir();
    }
    
    public static void main(String[] args) {
        ListaSQueue cola = new ListaSQueue();
        cola.enqueue("Holaaa");
        cola.enqueue(true);
        cola.enqueue(80000);
        cola.enqueue(6.8);
        while(!cola.isEmpty())
            System.out.println(cola.dequeue());           
    }
    
}
