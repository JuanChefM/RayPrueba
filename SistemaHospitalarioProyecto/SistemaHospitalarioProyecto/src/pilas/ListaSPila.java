/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

import listas.ListaSimple;

/**
 *
 * @author jorge.reyes
 */
public class ListaSPila implements Pila{
    protected ListaSimple lista;
    protected int cont;
    
    
    public ListaSPila(){
        lista = new ListaSimple();
        cont = 0;
    }
    
    @Override
    public void push(Object x) {
        lista.insertaInicio(x);
        cont++;
    }

    @Override
    public Object pop() {
        if (lista.vacio()){
            System.out.println("Pila vacía");
            return null;
        }
        else{
            cont --;
            return lista.eliminaInicio();
        }
    }

    @Override
    public Object top() {
        if (lista.vacio()){
            System.out.println("Pila vacía");
            return null;
        }
        else{
            return lista.getInicio().getDato();
        }
    }

    @Override
    public int size() {
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return lista.vacio();
    }
    
    public static void main(String[] args) {
        ListaSPila pila = new ListaSPila();
        pila.push("Holaaaa");
        pila.push(5.2);
        pila.push(true);
        pila.push(60);
        while(!pila.isEmpty())
            System.out.println(pila.pop());
    }
}
