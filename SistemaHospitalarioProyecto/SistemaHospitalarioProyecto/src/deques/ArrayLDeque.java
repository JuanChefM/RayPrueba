/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deques;

import java.util.ArrayList;

/**
 *
 * @author jorge.reyes
 */
public class ArrayLDeque implements Deque{
    protected ArrayList deque;
    
    public ArrayLDeque(){
        deque = new ArrayList();
    }
    
    @Override
    public int size() {
        return deque.size();
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public void insertFirst(Object dato) {
        deque.add(0,dato);
    }

    @Override
    public void insertLast(Object dato) {
        deque.add(dato);
    }

    @Override
    public Object removeFirst() {
        if (!deque.isEmpty())
            return deque.remove(0);
        else{
            System.out.println("El deque está vacío");
            return null;
        }
    }

    @Override
    public Object removeLast() {
    if (!deque.isEmpty())
            return deque.remove(deque.size()-1);
        else{
            System.out.println("El deque está vacío");
            return null;
        }    
    }

    @Override
    public Object first() {
        if (!deque.isEmpty())
            return deque.get(0);
        else{
            System.out.println("El deque está vacío");
            return null;
        }}

    @Override
    public Object last() {
        if (!deque.isEmpty())
            return deque.get(deque.size()-1);
        else{
            System.out.println("El deque está vacío");
            return null;
        }}
    
    
    public static void main(String[] args) {
        ArrayLDeque deque = new ArrayLDeque();
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
