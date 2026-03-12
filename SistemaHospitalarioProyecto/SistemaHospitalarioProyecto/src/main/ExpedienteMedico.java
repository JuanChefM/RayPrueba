/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author pootb
 */
public class ExpedienteMedico {
    
    protected String diagnostico;
    protected double cargo;

    public ExpedienteMedico(String diagnostico, double cargo) {
        this.diagnostico = diagnostico;
        this.cargo = cargo;
    }

    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the cargo
     */
    public double getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(double cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Diagnostico: " + getDiagnostico() + "| Cargo: " + getCargo();
    }
    
    
    
}
