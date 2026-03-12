/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colas;

import java.util.ArrayList;

/**
 *
 * @author jorge.reyes
 */
public class ArrayLQueue implements Queue{
    protected ArrayList cola;
    
    public ArrayLQueue(){
        cola = new ArrayList();
    }
    
    @Override
    public void enqueue(Object dato) {
        cola.add(dato);
    }

    @Override
    public Object dequeue() {
        if (cola.isEmpty()){
            System.out.println("Cola vacía");
            return null;
        }
        else
            return cola.remove(0);
    }

    @Override
    public int size() {
        return cola.size();
    }

    @Override
    public Object front() {
        if (cola.isEmpty()){
            System.out.println("Cola vacía");
            return null;
        }
        else
            return cola.get(0);
    }

    @Override
    public boolean isEmpty() {
        return cola.isEmpty();
        }
    
    public static void main(String[] args) {
        ArrayLQueue cola = new ArrayLQueue();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);
        cola.enqueue(true);
        cola.enqueue(":)");
        while(!cola.isEmpty())
            System.out.println(cola.dequeue());
    }
    
}
