/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;


import java.util.Scanner;
import listas.NodoDoble;
import java.util.Scanner;
import colas.ListaSQueue;
import listas.ListaDoble;
import listas.ListaSimple;
import listas.NodoDoble;
import pilas.ArrayPila;

public class Quirofanos {

    public static NodoDoble ejecutar(Scanner entrada,
                                     NodoDoble etapaActual) {

        boolean continuarCase4 = true;

        do {
            System.out.println("\n--- FLUJO DE QUIRÓFANOS (DOUBLY LINKED LIST) ---");
            System.out.println("Ruta: [PREPARACIÓN] <-> [CIRUGÍA] <-> [RECUPERACIÓN] <-> [ALTA]");

            if (etapaActual == null) {
                System.out.println("etapaActual está en NULL");
            }

            System.out.println("Ubicación actual: " + etapaActual.getDato());

            System.out.println("[1] Avanzar paciente a siguiente etapa (Next)");
            System.out.println("[2] Retroceder paciente por complicación (Previous)");
            System.out.println("[3] Insertar etapa de emergencia (Insert entre nodos)");
            System.out.println("[4] Ver ubicación actual del paciente");
            System.out.println("[5] Volver al Menú Principal");

            int opcionCase4 = entrada.nextInt();

            if (opcionCase4 == 5) {
                continuarCase4 = false;
                break;
            }

            switch (opcionCase4) {

                case 1:
                    if (etapaActual != null && etapaActual.getSiguiente() != null) {
                        etapaActual = (NodoDoble) etapaActual.getSiguiente();
                        System.out.println("Paciente avanzando a : " + etapaActual.getDato());
                    } else {
                        System.out.println("El paciente ya esta en la ultima etapa. ");
                    }
                    break;

                case 2:
                    if (etapaActual != null && etapaActual.getAnterior() != null) {

                        NodoDoble etapaAnterior = etapaActual;
                        etapaActual = etapaActual.getAnterior();

                        System.out.println(" >> [SISTEMA]: El paciente ha sido devuelto de "
                                + etapaAnterior.getDato() + " a "
                                + etapaActual.getDato());

                        String prev = (etapaActual.getAnterior() != null)
                                ? etapaActual.getAnterior().getDato().toString()
                                : "NULL";

                        String next = (etapaActual.getSiguiente() != null)
                                ? etapaActual.getSiguiente().getDato().toString()
                                : "NULL";

                        System.out.println(" >> [INFO]: Apuntadores actualizados: Prev ("
                                + prev + ") , Next (" + next + ")");

                    } else {
                        System.out.println("El paciente ya esta en la primera etapa");
                    }

                    break;

                case 3:
                    if (etapaActual == null || etapaActual.getSiguiente() == null) {
                        System.out.println("No se puede insertar despues de la ultima etapa");
                        break;
                    }

                    NodoDoble siguiente =
                            (NodoDoble) etapaActual.getSiguiente();

                    NodoDoble nuevo =
                            new NodoDoble("ETAPA DE EMERGENCIA");

                    nuevo.setAnterior(etapaActual);
                    nuevo.setSiguiente(siguiente);

                    etapaActual.setSiguiente(nuevo);
                    siguiente.setAnterior(nuevo);

                    System.out.println("Se ha insertado ETAPA DE EMERGENCIA entre "
                            + etapaActual.getDato()
                            + " y "
                            + siguiente.getDato());
                    break;

                case 4:
                    if (etapaActual != null) {

                        String prev = (etapaActual.getAnterior() != null)
                                ? etapaActual.getAnterior().getDato().toString()
                                : "NULL";

                        String next = (etapaActual.getSiguiente() != null)
                                ? etapaActual.getSiguiente().getDato().toString()
                                : "NULL";

                        System.out.println("El paciente se encuentra actualmente en: "
                                + etapaActual.getDato());
                        System.out.println("INFO: Prev (" + prev + "), Next (" + next + ")");

                    } else {
                        System.out.println("No hay etapas registradas");
                    }

                    break;
            }

        } while (continuarCase4);

        return etapaActual;
    }
}

