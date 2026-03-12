/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import java.util.Scanner;
import pilas.ArrayPila;
import java.util.Scanner;
import colas.ListaSQueue;
import listas.ListaDoble;
import listas.ListaSimple;
import listas.NodoDoble;
import pilas.ArrayPila;
import main.Medicamento;

public class Farmacia {

    public static void ejecutar(Scanner entrada,
                                 ArrayPila pilaAnalgesicos,
                                 ArrayPila pilaAntibioticos,
                                 ArrayPila pilaSueros) {

        boolean continuarCase2 = true;

        do {
            System.out.println("--- INVENTARIO DE FARMACIA (STACKS) ---");
            System.out.println("[Pila Analgésicos: " + pilaAnalgesicos.size()+ " ]"
                    + " | [Pila Antibióticos: " + pilaAntibioticos.size()
                    + " ] | [Pila Sueros: " + pilaSueros.size() + " ]");

            System.out.println("[1] Abastecer medicamento (Push)");
            System.out.println("[2] Despachar medicamento de la cima (Pop)");
            System.out.println("[3] EXTRAER ESPECÍFICO (Uso de Pila Auxiliar)");
            System.out.println("[4] Ver stock actual (Peek)");
            System.out.println("[5] Volver al Menú Principal");

            int opcionCase2 = entrada.nextInt();

            if (opcionCase2 == 5) {
                continuarCase2 = false;
                break;
            }

            ArrayPila pilaSeleccionada = null;
            int tipoPila = 0;

            if (opcionCase2 >= 1 && opcionCase2 <= 4) {
                System.out.println("Seleccione la categoria de la pila");
                System.out.println("1. Analgesicos");
                System.out.println("2. Antibioticos");
                System.out.println("3. Sueros");
                tipoPila = entrada.nextInt();
            }

            if (tipoPila == 1) {
                pilaSeleccionada = pilaAnalgesicos;
            } else if (tipoPila == 2) {
                pilaSeleccionada = pilaAntibioticos;
            } else if (tipoPila == 3) {
                pilaSeleccionada = pilaSueros;
            } else {
                System.out.println("Seleccione una opcion valida");
                continue;
            }

            switch (opcionCase2) {

                case 1:
                    System.out.println("Nombre del medicamento: ");
                    String nombreMed = entrada.next();
                    pilaSeleccionada.push(new Medicamento(nombreMed));
                    System.out.println("Medicamento ingresado a la pila");
                    break;

                case 2:
                    if (pilaSeleccionada.isEmpty()) {
                        System.out.println("La pila esta vacia");
                    } else {
                        System.out.println("El sistema se despacho: "
                                + pilaSeleccionada.pop());
                    }
                    break;

                case 3:
                    if (pilaSeleccionada.isEmpty()) {
                        System.out.println("La pila esta vacia");
                        break;
                    }

                    System.out.println("Ingrese el medicamento a buscar: ");
                    entrada.nextLine();
                    String buscando = entrada.nextLine();

                    ArrayPila pilaAuxiliar = new ArrayPila(50);
                    int elementosMovidos = 0;
                    boolean encontrado = false;

                    while (!pilaSeleccionada.isEmpty()) {

                        Medicamento actual =
                                (Medicamento) pilaSeleccionada.pop();

                        if (actual.getNombreLote()
                                .equalsIgnoreCase(buscando)) {
                            encontrado = true;
                            break;
                        } else {
                            pilaAuxiliar.push(actual);
                            elementosMovidos++;
                        }
                    }

                    System.out.println("Medicamento buscado: " + buscando);
                    System.out.println(" >> [Sistema]: Moviendo "
                            + elementosMovidos
                            + " elementos a Pila Auxiliar...");

                    if (encontrado) {
                        System.out.println(
                                " >> [Sistema]: Elemento encontrado y despachado.");
                    } else {
                        System.out.println(
                                " >> [Sistema]: Elemento no encontrado");
                    }

                    while (!pilaAuxiliar.isEmpty()) {
                        pilaSeleccionada.push(pilaAuxiliar.pop());
                    }

                    System.out.println(
                            " >> [Sistema]: Regresando elementos restantes a la Pila Principal.");
                    break;

                case 4:
                    if (pilaSeleccionada.isEmpty()) {
                        System.out.println("La pila esta vacia");
                    } else {
                        System.out.println("En la cima esta: "
                                + pilaSeleccionada.top());
                    }
                    break;
            }

        } while (continuarCase2);
    }
}
