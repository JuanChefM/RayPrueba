/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package colas;

/**
 *
 * @author jorge.reyes
 */
public interface Queue {
    public void enqueue(Object dato);
    public Object dequeue();
    public int size();
    public Object front();
    public boolean isEmpty();
}
