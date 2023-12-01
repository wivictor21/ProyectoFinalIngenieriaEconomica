/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victorhuertas
 */
public class Anualidades {
    private int periodo;
    private double monto;
    private double tasa;
    private double interes;
    private double cuota;
    private double plazo;
    private double aboInteres;
    private double amortizacion;
    private double saldo;
    private double cuotaAux;

    public Anualidades(int periodo, double monto, double tasa, double interes, double cuota, double plazo, double aboInteres, double amortizacion, double saldo, double cuotaAux) {
        this.periodo = periodo;
        this.monto = monto;
        this.tasa = tasa;
        this.interes = interes;
        this.cuota = cuota;
        this.plazo = plazo;
        this.aboInteres = aboInteres;
        this.amortizacion = amortizacion;
        this.saldo = saldo;
        this.cuotaAux = cuotaAux;
    }

    public Anualidades() {
        this.monto = 0;
        this.tasa = 0;
        this.interes = 0;
        this.cuota = 0;
        this.plazo = 0;
        this.periodo = 0;
        this.aboInteres = 0;
        this.amortizacion = 0;
        this.saldo = 0;
        this.cuotaAux = 0;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getTasa() {
        return tasa;
    }

    public void setTasa(double tasa) {
        this.tasa = tasa;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public double getPlazo() {
        return plazo;
    }

    public void setPlazo(double plazo) {
        this.plazo = plazo;
    }

    public double getAboInteres() {
        return aboInteres;
    }

    public void setAboInteres(double aboInteres) {
        this.aboInteres = aboInteres;
    }

    public double getAmortizacion() {
        return amortizacion;
    }

    public void setAmortizacion(double amortizacion) {
        this.amortizacion = amortizacion;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCuotaAux() {
        return cuotaAux;
    }

    public void setCuotaAux(double cuotaAux) {
        this.cuotaAux = cuotaAux;
    }

    public void transformarInteres(int indiceInteres) {
        switch (indiceInteres) {
            case 0:
                interes = interes / 12;
                break;
            case 1:
                interes = interes / 6;
                break;
            case 2:
                interes = interes / 4;
                break;
            case 3:
                interes = interes / 3;
                break;
            case 4:
                interes = interes / 2;
                break;
            case 5:
                interes = interes / 1;
                break;
            default:
                interes = interes / 1;
        }
    }

    public void anticipada() {
        interes = (interes / (1 - interes));
    }

    public void definirVariables(int indicePeriodo, int indiceInteres) {
        int ele1 = 0, ele2 = 0;
        switch (indicePeriodo) {
            case 0:
                ele1 = 12;
                break;
            case 1:
                ele1 = 6;
                break;
            case 2:
                ele1 = 4;
                break;
            case 3:
                ele1 = 3;
                break;
            case 4:
                ele1 = 2;
                break;
            case 5:
                ele1 = 1;
                break;
            default:
                ele1 = 1;
        }

        switch (indiceInteres) {
            case 0 | 6:
                ele2 = 12;
                break;
            case 1 | 7:
                ele2 = 6;
                break;
            case 2 | 8:
                ele2 = 4;
                break;
            case 3 | 9:
                ele2 = 3;
                break;
            case 4 | 10:
                ele2 = 2;
                break;
            case 5 | 11:
                ele2 = 1;
                break;
            default:
                ele2 = 1;
        }

        conversion(ele1, ele2);

    }

    public void conversion(int ele1, int ele2) {
        if (ele1 != ele2) {
            interes = decimal(Math.pow(interes + 1, (ele2 * (1.0 / ele1))));
            interes = interes - 1;

        }
    }

    public void calcularCuotaAmortizacion() {
        cuota = decimal(monto / ((1 - Math.pow((1 + tasa), (plazo * -1))) / tasa));
    }
    
    public void calcularCuotaCapitalizacion() {
        cuota = decimal(monto / ((Math.pow((1 + tasa), plazo) -1 ) /  tasa));
    }

    public void construct() {
        periodo = 0;
        aboInteres = 0;
        amortizacion = 0;
    }
  
    public DefaultTableModel generarTablaAmortizacion() {
        DefaultTableModel plantilla = new DefaultTableModel();
        plantilla.addColumn("Periodo");
        plantilla.addColumn("Saldo");
        plantilla.addColumn("Interés");
        plantilla.addColumn("Cuota");
        plantilla.addColumn("Amortización");
        while (Math.round(saldo) > 0) {
            if (periodo == 0) {
                cuotaAux = 0;
            } else {
                cuotaAux = cuota;
            }
            plantilla.addRow(new Object[]{periodo, saldo, aboInteres, cuotaAux, amortizacion});
            periodo++;
            aboInteres = decimal(saldo * tasa);
            amortizacion = decimal(cuota - aboInteres);
            saldo = decimal(saldo - amortizacion);
        }
        plantilla.addRow(new Object[]{periodo, saldo, aboInteres, cuotaAux, amortizacion});
        return plantilla;
    }
    
    public DefaultTableModel generarTablaCapitalizacion() {
        DefaultTableModel plantilla = new DefaultTableModel();
        plantilla.addColumn("Periodo");
        plantilla.addColumn("Saldo");
        plantilla.addColumn("Interés");
        plantilla.addColumn("Cuota");
        plantilla.addColumn("Incremento");
        while (Math.round(saldo) <= monto) {
            plantilla.addRow(new Object[]{periodo, saldo, aboInteres, cuota, amortizacion});
            periodo++;
            aboInteres = decimal(saldo * tasa);
            amortizacion = decimal(cuota + aboInteres);
            saldo = decimal(saldo + amortizacion);
        }
        return plantilla;
    }
    
    public double decimal(double val){
        return Math.round(val * Math.pow(10, 3)) / Math.pow(10, 3);      
    }
}
