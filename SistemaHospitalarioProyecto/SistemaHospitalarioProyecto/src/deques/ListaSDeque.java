/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deques;

import listas.ListaSimple;

/**
 *
 * @author jorge.reyes
 */
public class ListaSDeque implements Deque{
    protected ListaSimple lista;
    protected int cont;
    
    public ListaSDeque(){
        lista = new ListaSimple();
        cont = 0;
    }
    
    @Override
    public int size() {
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return lista.vacio();
    }

    @Override
    public void insertFirst(Object dato) {
        lista.insertaInicio(dato);
        cont++;
    }

    @Override
    public void insertLast(Object dato) {
        lista.insertaFinal(dato);
        cont++;
    }

    @Override
    public Object removeFirst() {
        if (lista.vacio()){
            System.out.println("Deque vacío");
            return null;
        }
        else{
            cont--;
            return lista.eliminaInicio();
        }
    }

    @Override
    public Object removeLast() {
        if (lista.vacio()){
            System.out.println("Deque vacío");
            return null;
        }
        else{
            cont--;
            return lista.eliminaFinal();
        }
    }

    @Override
    public Object first() {
    if (lista.vacio()){
            System.out.println("Deque vacío");
            return null;
        }
        else{
            return lista.getInicio().getDato();
        }
    }

    @Override
    public Object last() {
    if (lista.vacio()){
            System.out.println("Deque vacío");
            return null;
        }
        else{
            return lista.getUltimo().getDato();
        }    
    }
    
    public static void main(String[] args) {
     ListaSDeque deque = new ListaSDeque();
        deque.insertFirst("Hola 1");
        deque.insertFirst("Hola 2");
        deque.insertLast("Último");
        deque.insertLast("último último");
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        while(!deque.isEmpty())
            System.out.println(deque.removeFirst());   
    }    
}
