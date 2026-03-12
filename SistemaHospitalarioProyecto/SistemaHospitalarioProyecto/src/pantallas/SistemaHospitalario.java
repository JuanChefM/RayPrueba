package pantallas;

import java.util.Scanner;
import colas.ListaSQueue;
import listas.ListaDoble;
import listas.ListaSimple;
import listas.NodoDoble;
import pilas.ArrayPila;

public class SistemaHospitalario {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;

        ListaSQueue cola = new ListaSQueue();
        ListaSimple pacientesAtendidos = new ListaSimple();
        ArrayPila pilaAnalgesicos = new ArrayPila(50);
        ArrayPila pilaAntibioticos = new ArrayPila(50);
        ArrayPila pilaSueros = new ArrayPila(50);
        ListaDoble flujo = new ListaDoble();

        flujo.insertaFinal("PREPARACIÓN");
        flujo.insertaFinal("CIRUGÍA");
        flujo.insertaFinal("RECUPERACIÓN");
        flujo.insertaFinal("ALTA");

        NodoDoble etapaActual = (NodoDoble) flujo.getInicio();

        do {
            System.out.println("      HEALTHSYNC v2.0 - EMERGENCY MANAGEMENT");
            System.out.println("======================================================");
            System.out.println("[1] TRIAGE (Entrada de Pacientes - Colas)");
            System.out.println("[2] FARMACIA (Suministros - Pilas)");
            System.out.println("[3] EXPEDIENTES (Historiales - Listas Simples)");
            System.out.println("[4] QUIRÓFANOS (Seguimiento - Listas Dobles)");
            System.out.println("[5] REPORTE DE ESTADO GLOBAL");
            System.out.println("[6] SALIR");

            int opcion = entrada.nextInt();

            if (opcion == 6) {
                continuar = false;
                break;
            }

            switch (opcion) {

                case 1:
                    Triage.ejecutar(entrada, cola, pacientesAtendidos);
                    break;

                case 2:
                    Farmacia.ejecutar(entrada, pilaAnalgesicos, pilaAntibioticos, pilaSueros);
                    break;

                case 3:
                    Expedientes.ejecutar(entrada, pacientesAtendidos);
                    break;

                case 4:
                    etapaActual = Quirofanos.ejecutar(entrada, etapaActual);
                    break;

                case 5:
                    ReporteGlobal.ejecutar(entrada, cola, pilaAnalgesicos, pilaAntibioticos,
                            pilaSueros, pacientesAtendidos, etapaActual);
                    break;
            }

        } while (continuar);
    }
}
