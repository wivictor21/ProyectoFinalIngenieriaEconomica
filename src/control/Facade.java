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
import view.frmEfectivaEfectiva;
import view.frmMain;
import view.frmEfectivaNominal;
import view.frmNominalEfectiva;
import view.frmNominalNominal;

/**
 *
 * @author victorhuertas
 */
public class Facade implements ActionListener {

    private frmMain frmMain;
    private frmEfectivaNominal frmEfectivaNominal;
    private frmNominalEfectiva frmNominalEfectiva;
    private frmEfectivaEfectiva frmEfectivaEfectiva;
    private frmNominalNominal frmNominalNominal;
    private ConversionTasas objConversionTasas;

    public Facade(frmMain frmMain, frmEfectivaNominal frmEfectivaNominal, frmNominalEfectiva frmNominalEfectiva, frmEfectivaEfectiva frmEfectivaEfectiva, frmNominalNominal frmNominalNominal, ConversionTasas objConversionTasas) {
        this.frmMain = frmMain;
        this.frmEfectivaNominal = frmEfectivaNominal;
        this.frmNominalEfectiva = frmNominalEfectiva;
        this.frmEfectivaEfectiva = frmEfectivaEfectiva;
        this.frmNominalNominal = frmNominalNominal;
        this.objConversionTasas = objConversionTasas;
    }

    public Facade() throws IOException {
        this.frmMain = new frmMain();
        this.frmEfectivaNominal = new frmEfectivaNominal();
        this.frmNominalEfectiva = new frmNominalEfectiva();
        this.frmEfectivaEfectiva = new frmEfectivaEfectiva();
        this.frmNominalNominal = new frmNominalNominal();
        this.objConversionTasas = new ConversionTasas();
        iniComponentStart();
    }

    public void start() {
        frmMain.setTitle("Ingenieria Economica");
        frmMain.setVisible(true);
    }

    public void iniComponentStart() {
        frmMain.getOpcNominalEfectiva().addActionListener(this);
        frmMain.getOpcEfectivaNominal().addActionListener(this);
        frmMain.getOpcEfectivaEfectiva().addActionListener(this);
        frmMain.getOpcNominalNominal().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Abrir Nominal Efectiva
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
            objConversionTasas.setTasa(0);
            objConversionTasas.setPeriodo(0);
            objConversionTasas.setTasa(Float.parseFloat(frmNominalEfectiva.getTxtInteres().getText())/100);
            objConversionTasas.extraerPeriodo1(frmNominalEfectiva.getCmbTasaNominal().getSelectedIndex());
            if(frmNominalEfectiva.getJcbAnticipadoNominal().isSelected()){
                System.out.println("Entró 1");
                objConversionTasas.verificarAnticipada1();
            }
            objConversionTasas.equivalenciaTasasNominalEfectiva(frmNominalEfectiva.getCmbTasaEfectiva().getSelectedIndex());
            //System.out.println("Tasa: "+objConversionTasas.getTasa()+"\nIndice: "+frmNominalEfectiva.getCmbTasaEfectiva().getSelectedItem()+"\n"+frmNominalEfectiva.getJcbAnticipadoNominal());
            if(frmNominalEfectiva.getJcbAnticipadoEfectivo().isSelected()){
                System.out.println("Entró 2");
                objConversionTasas.verificarAnticipada2();
            }
            String apellido = ""+frmNominalEfectiva.getCmbTasaEfectiva().getSelectedItem();
            if(frmNominalEfectiva.getJcbAnticipadoEfectivo().isSelected()){
                frmNominalEfectiva.getLblResultado().setText("Resultado: "+objConversionTasas.getTasa()*100+" %  E"+apellido.charAt(0)+"a");
            }else{
                frmNominalEfectiva.getLblResultado().setText("Resultado: "+objConversionTasas.getTasa()*100+" %  E"+apellido.charAt(0));
            }
        }
        
        // Abrir Efectiva Nominal
        if (frmMain.getOpcEfectivaNominal()== e.getSource()) {
            frmEfectivaNominal = new frmEfectivaNominal();
            frmMain.getLblBackground().add(frmEfectivaNominal);
            frmEfectivaNominal.setVisible(true);
            frmEfectivaNominal.getBtnCalcular().addActionListener(this);
            frmEfectivaNominal.getBtnCerrar().addActionListener(this);
        }
        // Cerrar Efectiva Nominal
        if (frmEfectivaNominal.getBtnCerrar() == e.getSource()) {
            frmEfectivaNominal.dispose();
        }
        // Calculo Efectiva Nominal
        if (frmEfectivaNominal.getBtnCalcular() == e.getSource()) {
            if(frmEfectivaNominal.getTxtInteres().getText().length()<1){
                JOptionPane.showMessageDialog(frmMain, "No se puede Registrar, no hay datos ingresados");
            }
            objConversionTasas.setTasa(0);
            objConversionTasas.setPeriodo(0);
            objConversionTasas.setTasa(Float.parseFloat(frmEfectivaNominal.getTxtInteres().getText())/100);
            if(frmEfectivaNominal.getJcbAnticipadoEfectivo().isSelected()){
                objConversionTasas.verificarAnticipada1();
            }
            objConversionTasas.extraerPeriodo2(frmEfectivaNominal.getCmbTasaEfectiva().getSelectedIndex());
            System.out.println("Tasa: "+objConversionTasas.getTasa()+"\nIndice 1: "+frmEfectivaNominal.getCmbTasaEfectiva().getSelectedItem()+"\nIndice 2: "+frmEfectivaNominal.getCmbTasaNominal().getSelectedItem()+"\n"+frmNominalEfectiva.getJcbAnticipadoNominal());
            objConversionTasas.equivalenciaTasasEfectivaNominal(frmEfectivaNominal.getCmbTasaNominal().getSelectedIndex());
            if(frmEfectivaNominal.getJcbAnticipadoNominal().isSelected()){
                System.out.println("Entró 2");
                objConversionTasas.verificarAnticipada2();
                
            }
            objConversionTasas.multiplicador(frmEfectivaNominal.getCmbTasaNominal().getSelectedIndex());
            String apellido = ""+frmEfectivaNominal.getCmbTasaNominal().getSelectedItem();
            if(frmEfectivaNominal.getJcbAnticipadoNominal().isSelected()){
                frmEfectivaNominal.getLblResultado().setText("Resultado: "+objConversionTasas.getTasa()*100+" %  N"+apellido.charAt(0)+"a");
            }else{
                frmEfectivaNominal.getLblResultado().setText("Resultado: "+objConversionTasas.getTasa()*100+" %  N"+apellido.charAt(0));
            }
        }
        // Abrir Efectiva Efectiva
        if (frmMain.getOpcEfectivaEfectiva()== e.getSource()) {
            frmEfectivaEfectiva = new frmEfectivaEfectiva();
            frmMain.getLblBackground().add(frmEfectivaEfectiva);
            frmEfectivaEfectiva.setVisible(true);
            frmEfectivaEfectiva.getBtnCalcular().addActionListener(this);
            frmEfectivaEfectiva.getBtnCerrar().addActionListener(this);
        }
        // Cerrar Efectiva Efectiva
        if (frmEfectivaEfectiva.getBtnCerrar() == e.getSource()) {
            frmEfectivaEfectiva.dispose();
        }
        // Calculo Efectiva Efectiva
        if (frmEfectivaEfectiva.getBtnCalcular() == e.getSource()) {
            if(frmEfectivaEfectiva.getTxtInteres().getText().length()<1){
                JOptionPane.showMessageDialog(frmMain, "No se puede Registrar, no hay datos ingresados");
            }
            objConversionTasas.setTasa(0);
            objConversionTasas.setPeriodo(0);
            objConversionTasas.setTasa(Float.parseFloat(frmEfectivaEfectiva.getTxtInteres().getText())/100);
            objConversionTasas.extraerPeriodo2(frmEfectivaEfectiva.getCmbTasaEfectiva1().getSelectedIndex());
            if(frmEfectivaEfectiva.getJcbAnticipadoEfectivo1().isSelected()){
                System.out.println("Entró 1");
                objConversionTasas.verificarAnticipada1();
            }
            objConversionTasas.equivalenciaTasasNominalEfectiva(frmNominalEfectiva.getCmbTasaEfectiva().getSelectedIndex());
            //System.out.println("Tasa: "+objConversionTasas.getTasa()+"\nIndice: "+frmNominalEfectiva.getCmbTasaEfectiva().getSelectedItem()+"\n"+frmNominalEfectiva.getJcbAnticipadoNominal());
            if(frmNominalEfectiva.getJcbAnticipadoEfectivo().isSelected()){
                System.out.println("Entró 2");
                objConversionTasas.verificarAnticipada2();
            }
            String apellido = ""+frmNominalEfectiva.getCmbTasaEfectiva().getSelectedItem();
            if(frmNominalEfectiva.getJcbAnticipadoEfectivo().isSelected()){
                frmNominalEfectiva.getLblResultado().setText("Resultado: "+objConversionTasas.getTasa()*100+" %  E"+apellido.charAt(0)+"a");
            }else{
                frmNominalEfectiva.getLblResultado().setText("Resultado: "+objConversionTasas.getTasa()*100+" %  E"+apellido.charAt(0));
            }
        }

    }
}
