/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;


import java.util.Scanner;
import listas.ListaSimple;
import java.util.Scanner;
import colas.ListaSQueue;
import listas.ListaDoble;
import listas.ListaSimple;
import listas.NodoDoble;
import pilas.ArrayPila;

public class Expedientes {

    public static void ejecutar(Scanner entrada,
                                ListaSimple pacientesAtendidos) {

        System.out.println("--- BUSCADOR DE EXPEDIENTES ---");

        if (pacientesAtendidos.vacio()) {
            System.out.println(">> [Sistema]: No hay pacientes registrados en el historial todavía.");
        } else {

            System.out.print("Ingrese el nombre del paciente: ");
            String nombreBuscado = entrada.next();

            listas.Nodo aux = pacientesAtendidos.getInicio();
            Paciente encontrado = null;

            while (aux != null) {
                Paciente p = (Paciente) aux.getDato();
                if (p.getNombre()
                        .equalsIgnoreCase(nombreBuscado)) {
                    encontrado = p;
                    break;
                }
                aux = aux.getSiguiente();
            }

            if (encontrado != null) {
                SistemaHospitalario
                        .abrirExpedientePaciente(encontrado, entrada);
            } else {
                System.out.println(
                        ">> [Error]: Paciente no encontrado en el historial.");
            }
        }
    }
}
