/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deques;

/**
 *
 * @author jorge.reyes
 */
public interface Deque {
    public int size();
    public boolean isEmpty();
    public void insertFirst(Object dato);
    public void insertLast(Object dato);
    public Object removeFirst();
    public Object removeLast();
    public Object first();
    public Object last();
}
