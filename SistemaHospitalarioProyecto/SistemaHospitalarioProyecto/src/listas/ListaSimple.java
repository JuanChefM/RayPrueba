/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listas;

/**
 *
 * @author jorge.reyes
 */
public class ListaSimple extends Lista {

    @Override
    public void insertaInicio(Object dato) {
        if (vacio())
            inicio = ultimo = new Nodo(dato);
        else
            inicio = new Nodo(dato,inicio);
    }

    @Override
    public void insertaFinal(Object dato) {
        if (vacio()){
            inicio = ultimo = new Nodo(dato);
        }
        else{
            Nodo temp = new Nodo(dato);
            ultimo.setSiguiente(temp);
            ultimo = temp;
        }
    }

    @Override
    public Object eliminaInicio() {
    Object eliminado=null;
    if(vacio())
            System.out.println("La lista está vacía.");
    else
        if (inicio==ultimo){
            eliminado = inicio.getDato();
            inicio = ultimo = null;
        }
        else{
            eliminado = inicio.getDato();
            inicio = inicio.getSiguiente();
        }
            
    return eliminado;
    }

    @Override
    public Object eliminaFinal() {
    Object eliminado = null;
    if (vacio())
            System.out.println("La lista está vacía");
    else
        if (inicio==ultimo){
            eliminado = inicio.getDato();
            inicio = ultimo = null;
        }
        else{
            Nodo actual = inicio;
            while (actual.getSiguiente()!=ultimo)
                actual = actual.getSiguiente();
            eliminado = ultimo.getDato();
            actual.setSiguiente(null);
            ultimo = actual;
        }
    return eliminado;
    }
    
    public void insertaEnOrden(int dato){
        if (vacio())
            insertaInicio(dato);
        else
            if (inicio==ultimo){
                if (dato<(Integer)inicio.getDato())
                    insertaInicio(dato);
                else
                    insertaFinal(dato);
            }
            else{
                Nodo antes = null, despues = inicio;
                while(despues!=null && dato > (Integer)despues.getDato()){
                    antes = despues;
                    despues = despues.getSiguiente();
                }
                if (antes==null)
                    insertaInicio(dato);
                else
                    if (despues==null)
                        insertaFinal(dato);
                    else{
                        Nodo nuevo = new Nodo(dato,despues);
                        antes.setSiguiente(nuevo);
                    }
            }
        
        
    }
    
    
    public int size() {
    int contador = 0;
    Nodo aux = inicio;

    while (aux != null) {
        contador++;
        aux = aux.getSiguiente();
    }

    return contador;
}

    
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();
        /*lista.insertaInicio(7);
        lista.insertaInicio(true);
        lista.insertaInicio("algo");
        lista.insertaInicio('b');
        lista.insertaFinal("final");
        lista.imprimir();
        System.out.println("**Eliminaciones**");
        System.out.println("El elemento borrado de inicio es:"+lista.eliminaInicio());
        lista.imprimir();
        System.out.println("El elemento borrado del final es:"+lista.eliminaFinal());
        lista.imprimir();*/
        System.out.println("Probando inserción en orden");
        lista.insertaEnOrden(67);
        lista.insertaEnOrden(32);
        lista.insertaEnOrden(900);
        lista.insertaEnOrden(230);
        lista.insertaEnOrden(51);
        lista.insertaEnOrden(30);
        lista.imprimir();
    }
}
