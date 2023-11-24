/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author victorhuertas
 */
public class Anualidades {

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
    
    

}
