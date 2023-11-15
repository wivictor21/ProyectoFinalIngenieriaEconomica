/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.ConversionTasas;
import view.frmMain;
import view.frmEfectivaNominal;
import view.frmNominalEfectiva;

/**
 *
 * @author victorhuertas
 */
public class Facade implements ActionListener {

    private frmMain frmMain;
    private frmEfectivaNominal frmEfectivaNominal;
    private frmNominalEfectiva frmNominalEfectiva;
    private ConversionTasas objConversionTasas;

    public Facade(frmMain frmMain, frmEfectivaNominal frmEfectivaNominal, frmNominalEfectiva frmNominalEfectiva, ConversionTasas objConversionTasas) {
        this.frmMain = frmMain;
        this.frmEfectivaNominal = frmEfectivaNominal;
        this.frmNominalEfectiva = frmNominalEfectiva;
        this.objConversionTasas = objConversionTasas;
    }

    public Facade() throws IOException {
        this.frmMain = new frmMain();
        this.frmEfectivaNominal = new frmEfectivaNominal();
        this.frmNominalEfectiva = new frmNominalEfectiva();
        this.objConversionTasas = new ConversionTasas();
        iniComponentStart();
    }

    public void start() {
        frmMain.setTitle("Ingenieria Economica");
        frmMain.setVisible(true);
    }

    public void iniComponentStart() {
        frmMain.getOpcNominalEfectiva().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Abrir Nominal Efectiva
        if (frmMain.getOpcNominalEfectiva() == e.getSource()) {
            frmNominalEfectiva = new frmNominalEfectiva();
            frmMain.getLblBackground().add(frmNominalEfectiva);
            frmNominalEfectiva.setVisible(true);
            frmNominalEfectiva.getBtnCalcular().addActionListener(this);
            frmNominalEfectiva.getBtnCerrar().addActionListener(this);
        }
        // Cerrar Nominal Efectiva
        if (frmNominalEfectiva.getBtnCerrar() == e.getSource()) {
            frmNominalEfectiva.dispose();
        }
        // Calculo Nominal Efectiva
        if (frmNominalEfectiva.getBtnCalcular() == e.getSource()) {
            if(frmNominalEfectiva.getTxtInteres().getText().length()<1){
                JOptionPane.showMessageDialog(frmMain, "No se puede Registrar, no hay datos ingresados");
            }
            objConversionTasas.setInteres("*");
            objConversionTasas.setInteres(frmNominalEfectiva.getTxtInteres().getText());
            
        }
    }
}
