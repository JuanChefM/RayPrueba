/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;
/**
 *
 * @author jorge.reyes
 */
public class ArrayPila implements Pila {

    protected Object[] pila;
    protected int tope;
    protected int capacidad;
    
    
    public ArrayPila(int capacidad) {
        this.capacidad = capacidad;
        this.pila = new Object[capacidad];
        this.tope = -1;
    }
    
    
    public ArrayPila() {
        this(100); 
    }
    
    @Override
    public void push(Object x) {
        if (tope == capacidad - 1) {
            System.out.println("Error: La pila está llena (Overflow)");
            return;
        }
        tope++;
        pila[tope] = x;
    }

    @Override
    public Object pop() {
        if (isEmpty()){
            System.out.println("La pila está vacía");
            return null;
        }
        Object valor = pila[tope];
        pila[tope] = null; 
        tope--;
        return valor;
    }

    @Override
    public Object top() {
        if (isEmpty()){
            System.out.println("La pila está vacía");
            return null;
        }
        return pila[tope];
    }

    @Override
    public int size() {
        return tope + 1;
    }

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }
    
    public static void main(String[] args) {
        
        ArrayPila pila = new ArrayPila(10); 
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(5);
        pila.push("Hola");
        pila.push(8.6);
        
        while(!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
}
