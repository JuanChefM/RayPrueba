package pantallas;

import java.util.Scanner;
import colas.ListaSQueue;
import listas.ListaSimple;
import java.util.Scanner;
import colas.ListaSQueue;
import listas.ListaDoble;
import listas.ListaSimple;
import listas.NodoDoble;
import pilas.ArrayPila;

public class Triage {

    public static void ejecutar(Scanner entrada, ListaSQueue cola,
                                 ListaSimple pacientesAtendidos) {

        boolean continuarCase1 = true;

        do {
            System.out.println("--- GESTIÓN DE TRIAJE (QUEUE) ---");
            System.out.println("Estado: " + cola.size() + " Pacientes esperando.");
            System.out.println("[1] Registrar llegada de paciente (Enqueue)");
            System.out.println("[2] Llamar a consulta/valoración (Dequeue)");
            System.out.println("[3] Ver quién es el siguiente en turno (Peek)");
            System.out.println("[4] Listar todos los pacientes en espera");
            System.out.println("[5] Volver al Menú Principal");

            int opcionCase1 = entrada.nextInt();

            if (opcionCase1 == 5) {
                continuarCase1 = false;
                break;
            }

            switch (opcionCase1) {

                case 1:
                    System.out.println("Nombre: ");
                    String nombre = entrada.next();
                    System.out.println("Gravedad: ");
                    int gravedad = entrada.nextInt();
                    cola.enqueue(new Paciente(nombre, gravedad));
                    System.out.println(" >> [Sistema]: Paciente " + nombre + " anadido a la cola");
                    break;

                case 2:
                    if (cola.isEmpty()) {
                        System.out.println("No hay ningun paciente en la cola");
                    } else {
                        System.out.println("El primer paciente de la cola sera atendido");
                        Paciente pacienteAtendido = (Paciente) cola.dequeue();
                        pacientesAtendidos.insertaFinal(pacienteAtendido);
                        System.out.println("Atendiendo ahora a: " + pacienteAtendido.getNombre());
                        SistemaHospitalario.abrirExpedientePaciente(pacienteAtendido, entrada);
                        break;
                    }

                case 3:
                    if (cola.isEmpty()) {
                        System.out.println("No hay ningun paciente en la cola");
                    } else {
                        System.out.println(cola.front());
                    }
                    break;

                case 4:
                    if (cola.isEmpty()) {
                        System.out.println("La cola esta vacia");
                    } else {
                        cola.imprimir();
                    }
                    break;
            }

        } while (continuarCase1);
    }
}
