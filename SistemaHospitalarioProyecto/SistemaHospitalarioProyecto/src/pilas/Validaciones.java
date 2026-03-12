/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

/**
 *
 * @author jorge.reyes
 */
public class Validaciones {
    protected ArrayLPila pila;
    
    public Validaciones(){
        pila = new ArrayLPila();
    }
    
    public boolean parentesis(String cadena){
        for (int i=0;i<cadena.length();i++){
            if (cadena.charAt(i)=='(')
                pila.push('(');
            else
                if (cadena.charAt(i)==')' && !pila.isEmpty())
                    pila.pop();
                else
                    return false;
        }
        return pila.isEmpty();
    }
    
    
    public boolean palindromo(String cadena){
    int inicio;
        for (int i=0;i<cadena.length()/2;i++)
            pila.push(cadena.charAt(i));
        if (cadena.length()%2!= 0) //Es impar
            inicio = cadena.length()/2 + 1;
        else
            inicio = cadena.length()/2;
        for (int i= inicio;i<cadena.length();i++){
            char elemento = (char)pila.pop();
            if (elemento!= cadena.charAt(i))
                return false;
        }
        return pila.isEmpty();
    }
    
    
    public static void main(String[] args) {
        Validaciones valida = new Validaciones();
        /*if (valida.parentesis("()"))
            System.out.println("La cadena está bien formada");
        else
            System.out.println("La cadena no está bien formada");
            */
        if (valida.palindromo("anitalavalatina"))
            System.out.println("Sí es un palíndromo");
        else
            System.out.println("No es un palíndromo");
}
}
