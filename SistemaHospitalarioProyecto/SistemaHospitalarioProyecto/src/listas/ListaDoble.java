/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

/**
 *
 * @author jorge.reyes
 */
public class ListaDoble extends ListaD{

    @Override
    public void insertaInicio(Object dato) {
        if (vacio())
            inicio = ultimo = new NodoDoble(dato);
        else{
            NodoDoble nuevo = new NodoDoble(dato,inicio,null);
            inicio.setAnterior(nuevo);
            inicio = nuevo;
        }
        }

    @Override
    public void insertaFinal(Object dato) {
        if (vacio()){
            inicio = ultimo = new NodoDoble(dato);
        }
        else{
            NodoDoble nuevo = new NodoDoble(dato,null,ultimo);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }
    

    @Override
    public Object eliminaInicio() {
        Object eliminado = null;
        if (vacio())
            System.out.println("La lista está vacía");
        else
            if (inicio == ultimo){
                eliminado = inicio.getDato();
                inicio = ultimo = null;
            }
            else{
                eliminado = inicio.getDato();
                inicio = inicio.getSiguiente();
                inicio.setAnterior(null);
            }    
        return eliminado;
    }

    @Override
    public Object eliminaFinal() {
        Object eliminado = null;
        if (vacio())
            System.out.println("La lista está vacía");
        else
            if (inicio == ultimo){
                eliminado = ultimo.getDato();
                inicio = ultimo = null;
            }
            else{
                eliminado = ultimo.getDato();
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
            }
        return eliminado;
    }
    
    public static void main(String[] args) {
        ListaDoble listaD = new ListaDoble();
        listaD.insertaInicio("Holaaa!");
        listaD.insertaInicio(56);
        listaD.insertaInicio(78.9);
        listaD.insertaInicio(false);
        listaD.insertaFinal("último");
        System.out.println("Recorrido desde el inicio hasta el final...");
        listaD.imprimir();
        System.out.println("Recorrido desde el final hasta el inicio");
        listaD.imprimirAlReves(); 
        System.out.println("Probando las eliminaciones...");
        System.out.println("El primer elemento borrado de la lista es: "+
                listaD.eliminaInicio());
        listaD.imprimir();
        System.out.println("Ahora al revés");
        listaD.imprimirAlReves();
        System.out.println("El último elemento borrado de la lista es: "+
                listaD.eliminaFinal());
        listaD.imprimir();
        System.out.println("Impresión al revés");
        listaD.imprimirAlReves();
    }
    
}
