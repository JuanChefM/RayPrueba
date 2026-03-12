/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

/**
 *
 * @author jorge.reyes
 */
public class ListaSimpleC extends Lista{

    public void imprimir(){
        Nodo actual = inicio;
        if (!vacio())
            if (inicio==ultimo)
                System.out.println(actual.getDato());
            else
                do{
                    System.out.println(actual.getDato()+"->");
                    actual = actual.getSiguiente();
                }while(actual!=inicio);
    }
    
    @Override
    public void insertaInicio(Object dato) {
        if (vacio()){
            inicio = ultimo = new Nodo(dato);
            ultimo.setSiguiente(inicio);
        }
        else{
            inicio = new Nodo(dato,inicio);
            ultimo.setSiguiente(inicio);
        }
        
    }

    @Override
    public void insertaFinal(Object dato) {
        if(vacio()){
            inicio = ultimo = new Nodo(dato);
            ultimo.setSiguiente(inicio);
        }
        else{
            Nodo temp = new Nodo(dato);
            ultimo.setSiguiente(temp);
            ultimo = temp;
            ultimo.setSiguiente(inicio);
        }
    
    }

    @Override
    public Object eliminaInicio() {
        Object eliminado = null;
        if (vacio())
            System.out.println("La lista está vacía");
        else
        {
            if (inicio== ultimo){
                eliminado = inicio.getDato();
                inicio = ultimo =null;
            }
            else{
                eliminado = inicio.getDato();
                inicio = inicio.getSiguiente();
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
                Nodo actual = inicio;
                while(actual.getSiguiente()!= ultimo)
                    actual = actual.getSiguiente();
                eliminado = ultimo.getDato();
                actual.setSiguiente(inicio);
                ultimo = actual;
            }
        return eliminado;
    }
    
    public static void main(String[] args) {
        ListaSimpleC listaC =  new ListaSimpleC();
        listaC.insertaFinal("Hola!");
        listaC.insertaFinal(45);
        listaC.insertaFinal(3.8);
        listaC.insertaFinal(true);
        listaC.imprimir();
        System.out.println("Probando la eliminación");
        System.out.println("El último elemento de la lista que eliminaremos es: "+
                listaC.eliminaFinal());
        listaC.imprimir();
    }
}
