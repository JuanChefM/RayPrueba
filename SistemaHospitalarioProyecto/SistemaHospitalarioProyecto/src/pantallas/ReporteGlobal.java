/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import java.util.Scanner;
import colas.ListaSQueue;
import pilas.ArrayPila;
import listas.ListaSimple;
import listas.NodoDoble;
import java.util.Scanner;
import colas.ListaSQueue;
import listas.ListaDoble;
import listas.ListaSimple;
import listas.NodoDoble;
import pilas.ArrayPila;

public class ReporteGlobal {

    public static void ejecutar(Scanner entrada,
                                 ListaSQueue cola,
                                 ArrayPila pilaAnalgesicos,
                                 ArrayPila pilaAntibioticos,
                                 ArrayPila pilaSueros,
                                 ListaSimple pacientesAtendidos,
                                 NodoDoble etapaActual) {

        System.out.println("======================================================");
        System.out.println("          REPORTE DE ESTADO HOSPITALARIO");
        System.out.println("======================================================");

        System.out.println("TRIAJE:");

        int pacientesEnEspera = cola.size();
        System.out.println("* Pacientes en espera: " + pacientesEnEspera);

        int tiempoEstimado = pacientesEnEspera * 5;
        System.out.println("* Tiempo estimado de espera: "
                + tiempoEstimado + " min.\n");

        System.out.println("FARMACIA:");

        if (pilaAnalgesicos.size() < 3) {
            System.out.println(
                    "* Alerta: Pila de Analgesicos con menos de 3 unidades.\n");
        } else {
            System.out.println("* Inventario estable.\n");
        }

        if (pilaAntibioticos.size() < 3) {
            System.out.println(
                    "* Alerta: Pila de Antibioticos con menos de 3 unidades.\n");
        } else {
            System.out.println("* Inventario estable.\n");
        }

        if (pilaSueros.size() < 3) {
            System.out.println(
                    "* Alerta: Pila de Sueros con menos de 3 unidades.\n");
        } else {
            System.out.println("* Inventario estable.\n");
        }

        System.out.println("PACIENTES ACTIVOS:");

        int totalDiagnosticos = pacientesAtendidos.size();
        System.out.println(
                "* Total de diagnósticos registrados hoy: "
                + totalDiagnosticos);

        if (etapaActual != null) {
            System.out.println("* Paciente actual en etapa: ["
                    + etapaActual.getDato() + "].");
        }

        System.out.println("\nPresione ENTER para continuar...");
        entrada.nextLine();
        entrada.nextLine();
    }
}
