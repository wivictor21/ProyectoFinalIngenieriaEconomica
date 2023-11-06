/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author victorhuertas
 */
public class nominalEfectiva {
/*
    private double tasa;
    private String periodoN;
    private double periodoNN;
    private String periodoE;

    public void getData() {

    }

    public double nominalEfectiva() {
        switch (periodoN) {
            case "M":
                periodoNN = 12;
                tasa = tasa / 12;
                break;
            case "B":
                periodoNN = 6;
                tasa = tasa / 6;
                break;
            case "T":
                periodoNN = 4;
                tasa = tasa / 4;
                break;
            case "C":
                periodoNN = 3;
                tasa = tasa / 3;
                break;
            case "S":
                periodoNN = 2;
                tasa = tasa / 2;
                break;
            case "A":
                periodoNN = 1;
                break;
            default:
                periodoNN = 1;
                break;
        }
        return tasa;
    }

    public double verificarAnticipada1() {
        if (document.getElementById("nominalA").checked) {
            tasa = tasa / (1 - tasa);
        }
        return tasa;
    }

    public double equivalenciaTasas() {
        switch (periodoE) {
            case "M":
                tasa = Math.pow(Math.pow(1 + tasa, periodoNN), 1 / 12) - 1;
                break;
            case "B":
                tasa = Math.pow(Math.pow(1 + tasa, periodoNN), 1 / 6) - 1;
                break;
            case "T":
                tasa = Math.pow(Math.pow(1 + tasa, periodoNN), 1 / 4) - 1;
                break;
            case "C":
                tasa = Math.pow(Math.pow(1 + tasa, periodoNN), 1 / 3) - 1;
                break;
            case "S":
                tasa = Math.pow(Math.pow(1 + tasa, periodoNN), 1 / 2) - 1;
                break;
            case "A":
                tasa = Math.pow(Math.pow(1 + tasa, periodoNN), 1) - 1;
                break;
            default:
                tasa = Math.pow(Math.pow(1 + tasa, periodoNN), 1) - 1;
                break;
        }
        return tasa;
    }

    public double verificar_anticipada2() {
        if (document.getElementById("efectivaA").checked) {
            tasa = tasa / (1 + tasa);
        }
        return tasa;
    }

    public double Decimal() {
        return parseFloat(tasa).toFixed(8);
    }

    public void convertirTasa() {
        getData();
        tasa = Decimal(tasa) * 100;
        document.getElementById("tasaE").innerHTML = tasa + "%";
        $("#tasaE").val(tasa);
    }*/

}
