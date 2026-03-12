/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;
import colas.ListaSQueue;
import listas.ListaDoble;
import listas.ListaSimple;
import listas.NodoDoble;
import pilas.ArrayPila;


/**
 *
 * @author pootb
 */
public class SistemaHospitalario {

    public static void main(String[] args) {
        

        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        boolean continuarCase1 = true;
        boolean continuarCase2 = true;
        boolean continuarCase4 = true;
        ListaSQueue cola = new ListaSQueue();
        ListaSimple pacientesAtendidos = new ListaSimple();
        ArrayPila pilaAnalgesicos = new ArrayPila(50);
        ArrayPila pilaAntibioticos = new ArrayPila(50);
        ArrayPila pilaSueros = new ArrayPila(50);
        
        ListaDoble flujo = new ListaDoble();

        flujo.insertaFinal("PREPARACIÓN");
        //System.out.println("Inicio después de insertar: " + flujo.getInicio());
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
            
            
            switch(opcion){
                
                case 1:
                   do{
                       System.out.println("--- GESTIÓN DE TRIAJE (QUEUE) ---");
                       System.out.println("Estado: " + cola.size() + " Pacientes esperando.");
                       System.out.println("[1] Registrar llegada de paciente (Enqueue)");
                       System.out.println("[2] Llamar a consulta/valoración (Dequeue)");
                       System.out.println("[3] Ver quién es el siguiente en turno (Peek)");
                       System.out.println("[4] Listar todos los pacientes en espera");
                       System.out.println("[5] Volver al Menú Principal");
                       int opcionCase1 = entrada.nextInt();
                       if(opcionCase1 == 5){
                           continuarCase1 = false;
                           break;
                       }
                       
                       switch(opcionCase1){
                           
                           case 1:
                               System.out.println("Nombre: ");
                               String nombre = entrada.next();
                               System.out.println("Gravedad: ");
                               int gravedad = entrada.nextInt();
                               cola.enqueue(new Paciente(nombre, gravedad));
                               System.out.println(" >> [Sistema]: Paciente " + nombre + " anadido a la cola");
                               break;
                           case 2:
                               if(cola.isEmpty()){
                                   System.out.println("No hay ningun paciente en la cola");
                               }
                               else{
                                   System.out.println("El primer paciente de la cola sera atendido");
                                   Paciente pacienteAtendido = (Paciente)cola.dequeue();
                                   pacientesAtendidos.insertaFinal(pacienteAtendido);
                                   System.out.println("Atendiendo ahora a: " + pacienteAtendido.getNombre());
                                   abrirExpedientePaciente(pacienteAtendido, entrada);
                                   break;
                                   
                               }
                               
                           case 3:
                               if(cola.isEmpty()){
                                   System.out.println("No hay ningun paciente en la cola");
                               }
                               else{
                                   System.out.println(cola.front());
                               }
                               break;
                           case 4:
                               if(cola.isEmpty()){
                                   System.out.println("La cola esta vacia");
                               }
                               else{
                                   cola.imprimir();
                               }
                               break;
                               
                           
                       }
                   }while(continuarCase1);
                    
                   break;
                    
                case 2:
                    
                    do{
                        System.out.println("--- INVENTARIO DE FARMACIA (STACKS) ---");
                        System.out.println("[Pila Analgésicos: " + pilaAnalgesicos.size()+ " ]" + " | [Pila Antibióticos: " + pilaAntibioticos.size() + " ] | [Pila Sueros: " + pilaSueros.size() + " ]");
                        
                        System.out.println("[1] Abastecer medicamento (Push)");
                        System.out.println("[2] Despachar medicamento de la cima (Pop)");
                        System.out.println("[3] EXTRAER ESPECÍFICO (Uso de Pila Auxiliar)");
                        System.out.println("[4] Ver stock actual (Peek)");
                        System.out.println("[5] Volver al Menú Principal");
                        int opcionCase2 = entrada.nextInt();
                        if(opcionCase2 == 5){
                            continuarCase2 = false;
                            break;
                        }
                        
                        ArrayPila pilaSeleccionada = null;
                        int tipoPila = 0;
                        
                        if(opcionCase2 >=1 && opcionCase2 <=4){
                            System.out.println("Seleccione la categoria de la pila");
                            System.out.println("1. Analgesicos");
                            System.out.println("2. Antibioticos");
                            System.out.println("3. Sueros");
                            tipoPila = entrada.nextInt();
                        }
                        
                        if(tipoPila ==1){
                            pilaSeleccionada = pilaAnalgesicos;
                        }
                        else if(tipoPila == 2){
                            pilaSeleccionada = pilaAntibioticos;
                        }
                        else if(tipoPila == 3){
                            pilaSeleccionada = pilaSueros;
                        }
                        else{
                            System.out.println("Seleccione una opcion valida");
                            continue;
                        }
                        
                        switch(opcionCase2){
                            case 1:
                                System.out.println("Nombre del medicamento: ");
                                String nombreMed = entrada.next();
                                pilaSeleccionada.push(new Medicamento(nombreMed));
                                System.out.println("Medicamento ingresado a la pila");
                                break;
                                
                            case 2:
                                if(pilaSeleccionada.isEmpty()){
                                    System.out.println("La pila esta vacia");
                                }
                                else{
                                    System.out.println("El sistema se despacho: " + pilaSeleccionada.pop());
                                }
                                break;
                                
                            case 3:
                                if(pilaSeleccionada.isEmpty()){
                                    System.out.println("La pila esta vacia");
                                break;
                                }
                                
                                System.out.println("Ingrese el medicamento a buscar: ");
                                entrada.nextLine();
                                String buscando = entrada.nextLine();
                                ArrayPila pilaAuxiliar = new ArrayPila(50);
                                int elementosMovidos = 0;
                                boolean encontrado = false;
                                
                                while(!pilaSeleccionada.isEmpty()){
                                    
                                    Medicamento actual = (Medicamento) pilaSeleccionada.pop();
                                    
                                    if(actual.getNombreLote().equalsIgnoreCase(buscando)){
                                        encontrado = true;
                                        break;
                                    }
                                    else{
                                        pilaAuxiliar.push(actual);
                                        elementosMovidos++;
                                    }
                                }
                                System.out.println("Medicamento buscado: " +  buscando);
                                System.out.println(" >> [Sistema]: Moviendo " + elementosMovidos + " elementos a Pila Auxiliar...");
                                if(encontrado){
                                    System.out.println(" >> [Sistema]: Elemento encontrado y despachado.");
                                }
                                else{
                                    System.out.println(" >> [Sistema]: Elemento no encontrado");
                                }
                                
                                while(!pilaAuxiliar.isEmpty()){
                                    pilaSeleccionada.push(pilaAuxiliar.pop());
                                }
                                System.out.println(" >> [Sistema]: Regresando elementos restantes a la Pila Principal.");
                                break;
                                
                            case 4:
                                if(pilaSeleccionada.isEmpty()){
                                    System.out.println("La pila esta vacia");
                                }
                                else{
                                    System.out.println("En la cima esta: " + pilaSeleccionada.top() );
                                }
                                break;
                                
                                
                        }
                        
                        
                        
                    }while(continuarCase2);
                    
                  
                    break;
                    
                case 3:
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
                            if (p.getNombre().equalsIgnoreCase(nombreBuscado)) {
                                encontrado = p;
                                break;
                            }
                            aux = aux.getSiguiente();
                        }

                        if (encontrado != null) {
                            abrirExpedientePaciente(encontrado, entrada);
                        } else {
                            System.out.println(">> [Error]: Paciente no encontrado en el historial.");
                        }
                    }
                    break;
                    
                case 4:
                    
                    do{
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
                        if(opcionCase4 == 5){
                            continuarCase4 = false;
                            break;
                        }
                        
                        switch(opcionCase4){
                            
                            case 1:
                                if(etapaActual !=null && etapaActual.getSiguiente() !=null){
                                    etapaActual = (NodoDoble) etapaActual.getSiguiente();
                                    System.out.println("Paciente avanzando a : " + etapaActual.getDato());
                                    
                                }
                                else{
                                    System.out.println("El paciente ya esta en la ultima etapa. ");
                                }
                                break;
                                
                            case 2:
                                if(etapaActual !=null && etapaActual.getAnterior() !=null){
                                    
                                    NodoDoble etapaAnterior = etapaActual;
                                    etapaActual = etapaActual.getAnterior();
                                    System.out.println(" >> [SISTEMA]: El paciente ha sido devuelto de "+etapaAnterior.getDato() + " a " + etapaActual.getDato());
                                    
                                    String prev = (etapaActual.getAnterior() !=null)
                                            ? etapaActual.getAnterior().getDato().toString() : "NULL";
                                    
                                    String next = (etapaActual.getSiguiente() !=null)
                                            ? etapaActual.getSiguiente().getDato().toString() : "NULL";
                                    
                                    System.out.println(" >> [INFO]: Apuntadores actualizados: Prev ("+ prev + ") , Next (" + next + ")");
                                }
                                else{
                                    System.out.println("El paciente ya esta en la primera etapa");
                                }
                                
                                break;
                            case 3:
                                if(etapaActual == null || etapaActual.getSiguiente() ==null){
                                    System.out.println("No se puede insertar despues de la ultima etapa");
                                    break;
                                }
                                
                                NodoDoble siguiente = (NodoDoble) etapaActual.getSiguiente();
                                NodoDoble nuevo = new NodoDoble("ETAPA DE EMERGENCIA");
                                
                                nuevo.setAnterior(etapaActual);
                                nuevo.setSiguiente(siguiente);
                                etapaActual.setSiguiente(nuevo);
                                siguiente.setAnterior(nuevo);
                                
                                System.out.println("Se ha insertado ETAPA DE EMERGENCIA entre "+ etapaActual.getDato() + " y " + siguiente.getDato());
                                break;
                                
                            case 4:
                                if(etapaActual != null){
                                    
                                    String prev = (etapaActual.getAnterior() != null)
                                            ? etapaActual.getAnterior().getDato().toString() : "NULL";
                                    
                                    String next = (etapaActual.getSiguiente() != null)
                                            ? etapaActual.getSiguiente().getDato().toString() : "NULL";
                                    
                                    System.out.println("El paciente se encuentra actualmente en: " + etapaActual.getDato());
                                    System.out.println("INFO: Prev (" + prev + "), Next (" + next + ")");
                                
                                }
                                else{
                                    System.out.println("No hay etapas registradas");
                                }
                                
                                break;
                                
                        }
                        
                    
                        
                        
                    }while(continuarCase4);
                    
                   
                case 5:
                    
                                System.out.println("======================================================");
                    System.out.println("          REPORTE DE ESTADO HOSPITALARIO");
                    System.out.println("======================================================");

                    System.out.println("TRIAJE:");

                    int pacientesEnEspera = cola.size();
                    System.out.println("* Pacientes en espera: " + pacientesEnEspera);

                    int tiempoEstimado = pacientesEnEspera * 5;
                    System.out.println("* Tiempo estimado de espera: " + tiempoEstimado + " min.\n");

                    System.out.println("FARMACIA:");

                    if (pilaAnalgesicos.size() < 3) {
                        System.out.println("* Alerta: Pila de Analgesicos con menos de 3 unidades.\n");
                    } else {
                        System.out.println("* Inventario estable.\n");
                    }
                    if (pilaAntibioticos.size() < 3) {
                        System.out.println("* Alerta: Pila de Antibioticos con menos de 3 unidades.\n");
                    } else {
                        System.out.println("* Inventario estable.\n");
                    }

                    if (pilaSueros.size() < 3) {
                        System.out.println("* Alerta: Pila de Sueros con menos de 3 unidades.\n");
                    } else {
                        System.out.println("* Inventario estable.\n");
                    }

                    System.out.println("PACIENTES ACTIVOS:");

                    int totalDiagnosticos = pacientesAtendidos.size(); // usa tu lista real
                    System.out.println("* Total de diagnósticos registrados hoy: " + totalDiagnosticos);

                    if (etapaActual != null) {
                        System.out.println("* Paciente actual en etapa: ["
                                + etapaActual.getDato() + "].");
                    }

                    System.out.println("\nPresione ENTER para continuar...");
                    entrada.nextLine();
                    entrada.nextLine();

                    break;
             
            }
            
            

        }while (continuar);

    }
    
    public static void abrirExpedientePaciente(Paciente paciente, Scanner entrada){
        
        boolean volver = false;
    do {
        System.out.println("\n--- EXPEDIENTE MÉDICO: [" + paciente.getNombre().toUpperCase() + "] ---");
        System.out.println("[1] Agregar nuevo diagnóstico (Insertar al final)");
        System.out.println("[2] Buscar diagnóstico (Search)");
        System.out.println("[3] Calcular total de cargos (Recorrer lista)");
        System.out.println("[4] Mostrar historial completo");
        System.out.println("[5] Finalizar consulta");
        System.out.print("> Selección: ");
        int op = entrada.nextInt();
        entrada.nextLine();

        switch (op) {
            case 1:
                System.out.print("Diagnóstico: ");
                String diagnostico = entrada.nextLine();
                System.out.print("Cargo: ");
                double cargo = entrada.nextDouble();
                paciente.getHistorial().insertaFinal(new ExpedienteMedico(diagnostico, cargo));
                System.out.println(">> [Sistema]: Nodo enlazado correctamente.");
                break;
            case 2:
                System.out.print("Palabra a buscar: ");
                String buscar = entrada.nextLine().toLowerCase();
                listas.Nodo aux = paciente.getHistorial().getInicio();
                boolean hallado = false;
                while(aux != null) {
                    ExpedienteMedico encontrar = (ExpedienteMedico) aux.getDato();
                    if(encontrar.diagnostico.toLowerCase().contains(buscar)) {
                        System.out.println("Encontrado:  " + encontrar);
                        hallado = true;
                    }
                    aux = aux.getSiguiente();
                }
                if(!hallado) System.out.println(">> No hay coincidencias.");
                break;
            case 3:
                double total = 0;
                listas.Nodo sum = paciente.getHistorial().getInicio();
                while(sum != null) {
                    total += ((ExpedienteMedico)sum.getDato()).cargo;
                    sum = sum.getSiguiente();
                }
                System.out.println(" Total acumulado: " + total);
                break;
            case 4:
                paciente.getHistorial().imprimir();
                break;
            case 5:
                volver = true;
                break;
        }
    } while (!volver);
        
    }
    
}
