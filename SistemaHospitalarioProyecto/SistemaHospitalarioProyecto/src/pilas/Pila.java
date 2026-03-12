/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pilas;

/**
 *
 * @author jorge.reyes
 */
public interface Pila {
    public void push(Object x);
    public Object pop();
    public Object top();
    public int size();
    public boolean isEmpty();
}
