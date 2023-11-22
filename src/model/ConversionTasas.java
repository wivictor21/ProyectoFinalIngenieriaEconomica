/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author victorhuertas
 */
public class ConversionTasas {

    private double tasa;
    private int periodo;

    public ConversionTasas(double tasa, int periodo) {
        this.tasa = tasa;
        this.periodo = periodo;
    }

    public ConversionTasas() {
        this.tasa = 0;
        this.periodo = 0;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
   
    public void extraerPeriodo(int periodoIndice) {
        switch (periodoIndice) {
            case 0:
                periodo = 12;
                break;
            case 1:
                periodo = 6;
                break;
            case 2:
                periodo = 4;
                break;
            case 3:
                periodo = 3;
                break;
            case 4:
                periodo = 2;
                break;
            case 5:
                periodo = 1;
                break;
            default:
                periodo = 1;
                break;
        }
    }

    public void equivalenciaTasas(int periodoIndice) {
        switch (periodoIndice) {
            case 0:
                tasa = Math.pow(Math.pow(1 + tasa, periodo), 1.0 / 12.0) - 1;
                break;
            case 1:
                tasa = Math.pow(Math.pow(1 + tasa, periodo), 1.0 / 6.0) - 1;
                break;
            case 2:
                tasa = Math.pow(Math.pow(1 + tasa, periodo), 1.0 / 4.0) - 1;
                break;
            case 3:
                tasa = Math.pow(Math.pow(1 + tasa, periodo), 1.0 / 3.0) - 1;
                break;
            case 4:
                System.out.println("Antes\n Tasa: " + tasa + "\nPeriodo: " + periodo);
                tasa = Math.pow(Math.pow(1 + tasa, periodo), 1.0 / 2.0) - 1;
                System.out.println("Despues\n Tasa: " + tasa + "\nPeriodo: " + periodo);
                break;
            case 5:
                tasa = Math.pow(Math.pow(1 + tasa, periodo), 1) - 1;
                break;
            default:
                tasa = Math.pow(Math.pow(1 + tasa, periodo), 1) - 1;
                break;
        }
    }
        
    public void dividir(int periodoIndice) {
        switch (periodoIndice) {
            case 0:
                tasa = tasa / 12;
                break;
            case 1:
                tasa = tasa / 6;
                break;
            case 2:
                tasa = tasa / 4;
                break;
            case 3:
                tasa = tasa / 3;
                break;
            case 4:
                tasa = tasa / 2;
                break;
            default:
                break;
        }
    }
    
    public void multiplicar(int periodoIndice){
        switch (periodoIndice) {
            case 0:
                tasa = tasa * 12;
                break;
            case 1:
                tasa = tasa * 6;
                break;
            case 2:
                tasa = tasa * 4;
                break;
            case 3:
                tasa = tasa * 3;
                break;
            case 4:
                tasa = tasa * 2;
                break;
            default:
                break;
        }
    }

    public void verificarAnticipada1() {
        tasa = tasa / (1 - tasa);
    }
    
    public void verificarAnticipada2() {
        tasa = tasa / (1 + tasa);
    }
}
