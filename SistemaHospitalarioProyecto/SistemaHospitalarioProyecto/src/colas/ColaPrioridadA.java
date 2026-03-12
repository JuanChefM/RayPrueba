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
public class ColaPrioridadA implements Queue{
    protected ArrayList cola;
    
    
    public ColaPrioridadA(){
        cola = new ArrayList();
    }

    @Override
    public void enqueue(Object dato) {
        cola.add(dato);
        Collections.sort(cola);
    }

    @Override
    public Object dequeue() {
        return cola.remove(0);
    }

    @Override
    public int size() {
        return cola.size();
    }

    @Override
    public Object front() {
        return cola.get(0);
    }

    @Override
    public boolean isEmpty() {
    return cola.isEmpty();
    }
    
    public static void main(String[] args) {
        ColaPrioridadA colap =  new ColaPrioridadA();
        colap.enqueue(new NodoPrioridad(25,"Holaa1"));
        colap.enqueue(new NodoPrioridad(20,"Holaa2"));
        colap.enqueue(new NodoPrioridad(85,"Holaa3"));
        colap.enqueue(new NodoPrioridad(4,"Holaa4"));
        colap.enqueue(new NodoPrioridad(9,"Holaa5"));
        while(!colap.isEmpty())
            System.out.println(colap.dequeue());
    }
}
