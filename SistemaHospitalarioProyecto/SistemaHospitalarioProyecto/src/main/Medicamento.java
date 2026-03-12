/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author pootb
 */
public class Medicamento {
    
    private String nombreLote;

    public Medicamento(String nombreLote) {
        this.nombreLote = nombreLote;
    }

    /**
     * @return the nombreLote
     */
    public String getNombreLote() {
        return nombreLote;
    }

    /**
     * @param nombreLote the nombreLote to set
     */
    public void setNombreLote(String nombreLote) {
        this.nombreLote = nombreLote;
    }

    @Override
    public String toString() {
        return getNombreLote();
    }
    
    
}
