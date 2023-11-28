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

    private double monto;
    private double tasa;
    private double numeroPagos;
    private double interes;
    private double cuota;
    private double plazo;
    private double periodo;
    private double aboInteres;
    private double amortizacion;
    private double saldo;
    private double cuotaAux;

    public Anualidades(double monto, double tasa, double numeroPagos, double interes, double cuota, double plazo, double periodo, double aboInteres, double amortizacion, double saldo, double cuotaAux) {
        this.monto = monto;
        this.tasa = tasa;
        this.numeroPagos = numeroPagos;
        this.interes = interes;
        this.cuota = cuota;
        this.plazo = plazo;
        this.periodo = periodo;
        this.aboInteres = aboInteres;
        this.amortizacion = amortizacion;
        this.saldo = saldo;
        this.cuotaAux = cuotaAux;
    }

    

    public Anualidades() {
        this.monto = 0;
        this.tasa = 0;
        this.numeroPagos = 0;
        this.interes = 0;
        this.cuota = 0;
        this.plazo = 0;
        this.periodo = 0;
        this.aboInteres = 0;
        this.amortizacion = 0;
        this.saldo = 0;
        this.cuotaAux = 0;
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

    public double getNumeroPagos() {
        return numeroPagos;
    }

    public void setNumeroPagos(double numeroPagos) {
        this.numeroPagos = numeroPagos;
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

    public double getPeriodo() {
        return periodo;
    }

    public void setPeriodo(double periodo) {
        this.periodo = periodo;
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
            interes = (Math.pow(interes + 1, (ele2 * (1 / ele1))));
            interes = interes - 1;

        }
    }

    public void calcularCuota() {
        cuota = monto / ((1 - Math.pow((1 + tasa), (plazo * -1))) / tasa);
    }

    public void construct() {
        periodo = 0;
        aboInteres = 0;
        amortizacion = 0;
    }

    public DefaultTableModel generarTabla() {
        DefaultTableModel plantilla = new DefaultTableModel();
        /*
        while (saldo > 0) {
            if (periodo == 0) {
                cuotaAux = 0;
            } else {
                cuotaAux = cuota;
            }
            plantilla.addRow(new Object[]{saldo,aboInteres,cuotaAux,amortizacion});
            periodo++;
            aboInteres=saldo*tasa;
            amortizacion=cuota-aboInteres;
            saldo=saldo-amortizacion;
        }
        */
        //plantilla.setColumnCount("1","2","3","4","5");
        plantilla.addRow(new Object[]{1,2,3,4,5});
        return plantilla;
    }

}

/*
float cuota;
    String tasa;
    float monto;
    String periodo;
    String saldo;
    String aboInteres;
    String amortizacion;
    String plazo;
    String mostrar;

    public void calcularPlazo(String tipo_p) {
        switch (tipo_p) {
            case "M":
                mostrar = "Mensual";
                break;
            case "B":
                mostrar = "Bimestral";
                break;
            case "T":
                mostrar = "Trimestral";
                break;
            case "C":
                mostrar = "Cuatrimestral";
                break;
            case "S":
                mostrar = "Semestral";
                break;
            case "A":
                mostrar = "Anual";
                break;
        }
    }

    public float anticipada(float interes, String tipo_a) {
        switch (tipo_a) {
            case "Si":
                interes = (interes / (1 - interes));
                break;
            case "No":
                break;
        }
        return interes;
    }

    public float transformarInteres(float interes, String tipo, String tipo_a) {
        if (tipo == "N_M") {
            interes = interes / 12;
        } else if (tipo == "N_B") {
            interes = interes / 6;
        } else if (tipo == "N_T") {
            interes = interes / 4;
        } else if (tipo == "N_C") {
            interes = interes / 3;
        } else if (tipo == "N_S") {
            interes = interes / 2;
        } else if (tipo == "N_A") {
            interes = interes / 1;
        }
        interes = anticipada(interes, tipo_a);
        return interes;

    }

    public float transformar_interes(float interes, String tipo, String tipo_a) {
        if (tipo == "N_M") {
            interes = interes / 12;
        } else if (tipo == "N_B") {
            interes = interes / 6;
        } else if (tipo == "N_T") {
            interes = interes / 4;
        } else if (tipo == "N_C") {
            interes = interes / 3;
        } else if (tipo == "N_S") {
            interes = interes / 2;
        } else if (tipo == "N_A") {
            interes = interes / 1;
        }
        interes = anticipada(interes, tipo_a);
        return interes;
    }

    public float definir_variables(float interes, String tipo_i, String plazo, String tipo_p) {

        if (tipo_p == "M") {
            ele1 = 12;
        } else if (tipo_p == "B") {
            ele1 = 6;
        } else if (tipo_p == "T") {
            ele1 = 4;
        } else if (tipo_p == "C") {
            ele1 = 3;
        } else if (tipo_p == "S") {
            ele1 = 2;
        } else if (tipo_p == "A") {
            ele1 = 1;
        }

        if (tipo_i == "Ef_M" || tipo_i == "N_M") {
            ele2 = 12;
        } else if (tipo_i == "Ef_B" || tipo_i == "N_B") {
            ele2 = 6;
        } else if (tipo_i == "Ef_T" || tipo_i == "N_T") {
            ele2 = 4;
        } else if (tipo_i == "Ef_C" || tipo_i == "N_C") {
            ele2 = 3;
        } else if (tipo_i == "Ef_S" || tipo_i == "N_S") {
            ele2 = 2;
        } else if (tipo_i == "Ef_A" || tipo_i == "N_A") {
            ele2 = 1;
        }

        interes = conversion(interes, ele1, ele2);
        return interes;
    }

    public float conversion(float interes, float ele1, float ele2) {
        if (ele1 != ele2) {
            interes = (Math.pow(interes + 1, (ele2 * (1 / ele1))));
            interes = interes - 1;

        }
        return interes;
    }

    public void calcularCuota() {
        cuota = monto / (1 - Math.pow((1 + tasa), (plazo * -1))) / tasa;
        cuota = cuota.toFixed(2);
    }
 */
