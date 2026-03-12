/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

/**
 *
 * @author jorge.reyes
 */
public class ListaDobleC extends ListaD{

    public void imprimir(){
        NodoDoble actual = inicio;
        if (!vacio())
            if (inicio == ultimo)
                System.out.println(actual.getDato());
            else{
            do{
                System.out.println(actual.getDato());
                actual = actual.getSiguiente();
            }
            while(actual!=inicio);
            }
    }
    public void imprimirAlReves(){
        NodoDoble actual = ultimo;
        if (!vacio())
            if (inicio == ultimo)
                System.out.println(actual.getDato());
            else{
            do{
                System.out.println(actual.getDato());
                actual = actual.getAnterior();
            }
            while(actual!=ultimo);
            }
    }
    
    @Override
    public void insertaInicio(Object dato) {
        if (vacio()){
            inicio = ultimo = new NodoDoble(dato);
            inicio.setSiguiente(ultimo);
            ultimo.setAnterior(inicio);
        }
        else{
            NodoDoble nuevo = new NodoDoble(dato, inicio, ultimo);
            inicio.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);
            inicio = nuevo;
        }
    }

    @Override
    public void insertaFinal(Object dato) {
        if (vacio()){
            inicio = ultimo = new NodoDoble(dato);
            inicio.setSiguiente(ultimo);
            ultimo.setAnterior(inicio);
        }
        else{
            NodoDoble nuevo = new NodoDoble(dato, inicio, ultimo);
            inicio.setAnterior(nuevo);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;        
        }            
    }

    @Override
    public Object eliminaInicio() {
        Object eliminado = null;
        if (vacio())
            System.out.println("Lista vacía");
        else{
            if (inicio == ultimo){
                eliminado = inicio.getDato();
                inicio = ultimo = null;
            }
            else{
                eliminado = inicio.getDato();
                inicio = inicio.getSiguiente();
                inicio.setAnterior(ultimo);
                ultimo.setSiguiente(inicio);
            }
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
                ultimo.setSiguiente(inicio);
                inicio.setAnterior(ultimo);
            }
        
        return eliminado;
    }
    
    public static void main(String[] args) {
        ListaDobleC listadc = new ListaDobleC();
        listadc.insertaInicio(":)");
        listadc.insertaInicio("Hola!");
        listadc.insertaInicio(36);
        listadc.insertaInicio(87.6);
        listadc.insertaInicio(false);
        listadc.insertaFinal("último");
        System.out.println("Impresión hacia adelante...");
        listadc.imprimir();
        System.out.println("Impresión hacia atrás...");
        listadc.imprimirAlReves();
        System.out.println("Probemos las eliminaciones...");
        System.out.println("El elemento del inicio de la lista(a eliminar) es:" +
                listadc.eliminaInicio());
        System.out.println("Impresión hacia adelante");
        listadc.imprimir();
        System.out.println("Impresión hacia atrás");
        listadc.imprimirAlReves();
        System.out.println("El elemento del final de la lista(a eliminar) es:" +
                listadc.eliminaFinal());
        System.out.println("Impresión hacia adelante");
        listadc.imprimir();
        System.out.println("Impresión hacia atrás");
        listadc.imprimirAlReves();
    }
    
}
