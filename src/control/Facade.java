/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Anualidades;
import model.ConversionTasas;
import view.frmAmortizacion;
import view.frmCapitalizacion;
import view.frmEfectivaEfectiva;
import view.frmMain;
import view.frmEfectivaNominal;
import view.frmNominalEfectiva;
import view.frmNominalNominal;
import view.frmTabla;

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
    private frmCapitalizacion frmCapitalizacion;
    private frmAmortizacion frmAmortizacion;
    private frmTabla frmTabla;
    private ConversionTasas objConversionTasas;
    private Anualidades objAnualidades;
    private String apellido;

    public Facade(frmMain frmMain, frmEfectivaNominal frmEfectivaNominal, frmNominalEfectiva frmNominalEfectiva, frmEfectivaEfectiva frmEfectivaEfectiva, frmNominalNominal frmNominalNominal, frmCapitalizacion frmCapitalizacion, frmAmortizacion frmAmortizacion, frmTabla frmTabla, ConversionTasas objConversionTasas, Anualidades objAnualidades) {
        this.frmMain = frmMain;
        this.frmEfectivaNominal = frmEfectivaNominal;
        this.frmNominalEfectiva = frmNominalEfectiva;
        this.frmEfectivaEfectiva = frmEfectivaEfectiva;
        this.frmNominalNominal = frmNominalNominal;
        this.frmCapitalizacion = frmCapitalizacion;
        this.frmAmortizacion = frmAmortizacion;
        this.frmTabla = frmTabla;
        this.objConversionTasas = objConversionTasas;
        this.objAnualidades = objAnualidades;
    }

    public Facade() throws IOException {
        this.frmMain = new frmMain();
        this.frmEfectivaNominal = new frmEfectivaNominal();
        this.frmNominalEfectiva = new frmNominalEfectiva();
        this.frmEfectivaEfectiva = new frmEfectivaEfectiva();
        this.frmNominalNominal = new frmNominalNominal();
        this.frmAmortizacion = new frmAmortizacion();
        this.frmCapitalizacion = new frmCapitalizacion();
        this.frmTabla = new frmTabla();
        this.objConversionTasas = new ConversionTasas();
        this.objAnualidades = new Anualidades();
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
        frmMain.getOpcAmortizacion().addActionListener(this);
        frmMain.getOpcCapitalizacion().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Abrir Nominal Efectiva
            if (frmMain.getOpcNominalEfectiva() == e.getSource()) {
                cerrarTodo();
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
                if (frmNominalEfectiva.getTxtInteres().getText().length() < 1) {
                    JOptionPane.showMessageDialog(frmMain, "No se puede Registrar, no hay datos ingresados");
                }
                objConversionTasas.setTasa(0);
                objConversionTasas.setPeriodo(0);
                objConversionTasas.setTasa(Float.parseFloat(frmNominalEfectiva.getTxtInteres().getText()) / 100);
                objConversionTasas.extraerPeriodo(frmNominalEfectiva.getCmbTasaNominal().getSelectedIndex());
                objConversionTasas.dividir(frmNominalEfectiva.getCmbTasaNominal().getSelectedIndex());
                if (frmNominalEfectiva.getJcbAnticipadoNominal().isSelected()) {
                    objConversionTasas.verificarAnticipada1();
                }
                objConversionTasas.equivalenciaTasas(frmNominalEfectiva.getCmbTasaEfectiva().getSelectedIndex());
                if (frmNominalEfectiva.getJcbAnticipadoEfectivo().isSelected()) {
                    objConversionTasas.verificarAnticipada2();
                }
                apellido = "" + frmNominalEfectiva.getCmbTasaEfectiva().getSelectedItem();
                if (frmNominalEfectiva.getJcbAnticipadoEfectivo().isSelected()) {
                    frmNominalEfectiva.getLblResultado().setText("Resultado: " + String.format("%.4f", objConversionTasas.getTasa() * 100) + " %  E" + apellido.charAt(0) + "a");
                } else {
                    frmNominalEfectiva.getLblResultado().setText("Resultado: " + String.format("%.4f", objConversionTasas.getTasa() * 100) + " %  E" + apellido.charAt(0));
                }
            }

            // Abrir Efectiva Nominal
            if (frmMain.getOpcEfectivaNominal() == e.getSource()) {
                cerrarTodo();
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
                if (frmEfectivaNominal.getTxtInteres().getText().length() < 1) {
                    JOptionPane.showMessageDialog(frmMain, "No se puede Registrar, no hay datos ingresados");
                }
                objConversionTasas.setTasa(0);
                objConversionTasas.setPeriodo(0);
                objConversionTasas.setTasa(Float.parseFloat(frmEfectivaNominal.getTxtInteres().getText()) / 100);
                if (frmEfectivaNominal.getJcbAnticipadoEfectivo().isSelected()) {
                    objConversionTasas.verificarAnticipada1();
                }
                objConversionTasas.extraerPeriodo(frmEfectivaNominal.getCmbTasaEfectiva().getSelectedIndex());
                objConversionTasas.equivalenciaTasas(frmEfectivaNominal.getCmbTasaNominal().getSelectedIndex());
                if (frmEfectivaNominal.getJcbAnticipadoNominal().isSelected()) {
                    objConversionTasas.verificarAnticipada2();
                }
                objConversionTasas.multiplicar(frmEfectivaNominal.getCmbTasaNominal().getSelectedIndex());
                apellido = "" + frmEfectivaNominal.getCmbTasaNominal().getSelectedItem();
                if (frmEfectivaNominal.getJcbAnticipadoNominal().isSelected()) {
                    frmEfectivaNominal.getLblResultado().setText("Resultado: " + String.format("%.4f", objConversionTasas.getTasa() * 100) + " %  N" + apellido.charAt(0) + "a");
                } else {
                    frmEfectivaNominal.getLblResultado().setText("Resultado: " + String.format("%.4f", objConversionTasas.getTasa() * 100) + " %  N" + apellido.charAt(0));
                }
            }
            // Abrir Efectiva Efectiva
            if (frmMain.getOpcEfectivaEfectiva() == e.getSource()) {
                cerrarTodo();
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
                if (frmEfectivaEfectiva.getTxtInteres().getText().length() < 1) {
                    JOptionPane.showMessageDialog(frmMain, "No se puede Registrar, no hay datos ingresados");
                }
                objConversionTasas.setTasa(0);
                objConversionTasas.setPeriodo(0);
                objConversionTasas.setTasa(Float.parseFloat(frmEfectivaEfectiva.getTxtInteres().getText()) / 100);
                objConversionTasas.extraerPeriodo(frmEfectivaEfectiva.getCmbTasaEfectiva1().getSelectedIndex());
                if (frmEfectivaEfectiva.getJcbAnticipadoEfectivo1().isSelected()) {
                    objConversionTasas.verificarAnticipada1();
                }
                objConversionTasas.equivalenciaTasas(frmEfectivaEfectiva.getCmbTasaEfectiva2().getSelectedIndex());
                if (frmEfectivaEfectiva.getJcbAnticipadoEfectivo2().isSelected()) {
                    objConversionTasas.verificarAnticipada2();
                }
                apellido = "" + frmEfectivaEfectiva.getCmbTasaEfectiva2().getSelectedItem();
                if (frmEfectivaEfectiva.getJcbAnticipadoEfectivo2().isSelected()) {
                    frmEfectivaEfectiva.getLblResultado().setText("Resultado: " + String.format("%.4f", objConversionTasas.getTasa() * 100) + " %  E" + apellido.charAt(0) + "a");
                } else {
                    frmEfectivaEfectiva.getLblResultado().setText("Resultado: " + String.format("%.4f", objConversionTasas.getTasa() * 100) + " %  E" + apellido.charAt(0));
                }
            }
            // Abrir Nominal Nominal
            if (frmMain.getOpcNominalNominal() == e.getSource()) {
                cerrarTodo();
                frmNominalNominal = new frmNominalNominal();
                frmMain.getLblBackground().add(frmNominalNominal);
                frmNominalNominal.setVisible(true);
                frmNominalNominal.getBtnCalcular().addActionListener(this);
                frmNominalNominal.getBtnCerrar().addActionListener(this);
            }
            // Cerrar Nominal Nominal
            if (frmNominalNominal.getBtnCerrar() == e.getSource()) {
                frmNominalNominal.dispose();
            }
            // Calculo Nominal Nominal
            if (frmNominalNominal.getBtnCalcular() == e.getSource()) {
                if (frmNominalNominal.getTxtInteres().getText().length() < 1) {
                    JOptionPane.showMessageDialog(frmMain, "No se puede Registrar, no hay datos ingresados");
                }
                objConversionTasas.setTasa(0);
                objConversionTasas.setPeriodo(0);
                objConversionTasas.setTasa(Float.parseFloat(frmNominalNominal.getTxtInteres().getText()) / 100);
                objConversionTasas.extraerPeriodo(frmNominalNominal.getCmbTasaNominal1().getSelectedIndex());
                objConversionTasas.dividir(frmNominalNominal.getCmbTasaNominal1().getSelectedIndex());
                if (frmNominalNominal.getJcbAnticipadoNominal1().isSelected()) {
                    objConversionTasas.verificarAnticipada1();
                }
                objConversionTasas.equivalenciaTasas(frmNominalNominal.getCmbTasaNominal2().getSelectedIndex());
                if (frmNominalNominal.getJcbAnticipadoNominal2().isSelected()) {
                    objConversionTasas.verificarAnticipada2();
                }
                objConversionTasas.multiplicar(frmNominalNominal.getCmbTasaNominal2().getSelectedIndex());
                apellido = "" + frmNominalNominal.getCmbTasaNominal2().getSelectedItem();
                if (frmNominalNominal.getJcbAnticipadoNominal2().isSelected()) {
                    frmNominalNominal.getLblResultado().setText("Resultado: " + String.format("%.4f", objConversionTasas.getTasa() * 100) + " %  N" + apellido.charAt(0) + "a");
                } else {
                    frmNominalNominal.getLblResultado().setText("Resultado: " + String.format("%.4f", objConversionTasas.getTasa() * 100) + " %  N" + apellido.charAt(0));
                }
            }
            // Abrir Amortizacion
            if (frmMain.getOpcAmortizacion() == e.getSource()) {
                cerrarTodo();
                frmAmortizacion = new frmAmortizacion();
                frmMain.getLblBackground().add(frmAmortizacion);
                frmAmortizacion.setVisible(true);
                frmAmortizacion.getBtnCalcular().addActionListener(this);
                frmAmortizacion.getBtnCerrar().addActionListener(this);
            }
            // Cerrar Amortizacion
            if (frmAmortizacion.getBtnCerrar() == e.getSource()) {
                frmAmortizacion.dispose();
            }
            // Calculo Amortizacion
            if (frmAmortizacion.getBtnCalcular() == e.getSource()) {
                if (frmAmortizacion.getTxtMonto().getText().length() < 1) {
                    JOptionPane.showMessageDialog(frmMain, "No se puede Registrar, no hay datos ingresados");
                }
                objAnualidades.setMonto(0);
                objAnualidades.setPlazo(0);
                objAnualidades.setInteres(0);
                objAnualidades.setMonto(Double.parseDouble(frmAmortizacion.getTxtMonto().getText()));
                objAnualidades.setPlazo(Double.parseDouble(frmAmortizacion.getTxtNumeroPagos().getText()));
                objAnualidades.setInteres(Double.parseDouble(frmAmortizacion.getTxtInteres().getText()));
                objAnualidades.setTasa(objAnualidades.getInteres() / 100);
                objAnualidades.setSaldo(objAnualidades.getMonto());
                objAnualidades.transformarInteres(frmAmortizacion.getCmbTipoInteres().getSelectedIndex());
                if (frmAmortizacion.getJcbTipoPlazo().isSelected()) {
                    objAnualidades.anticipada();
                }
                objAnualidades.definirVariables(frmAmortizacion.getCmbPeriodo().getSelectedIndex(), frmAmortizacion.getCmbTipoInteres().getSelectedIndex());
                objAnualidades.calcularCuotaAmortizacion();
                objAnualidades.construct();

                //Abrir Tabla
                //frmAmortizacion.setVisible(false);
                frmAmortizacion.dispose();
                frmTabla = new frmTabla();
                frmMain.getLblBackground().add(frmTabla);
                frmTabla.setVisible(true);
                frmTabla.getTblTabla().setModel(objAnualidades.generarTablaAmortizacion());
                frmTabla.getLblTitulo().setText("Resultado Amortización");
                frmTabla.getLblResultado().setText("Se deberarán de pagar " + objAnualidades.getPeriodo() + " cuotas, cada una por un valor de $ " + objAnualidades.getCuota());
                frmTabla.getBtnCerrar().addActionListener(this);
            }

            // Abrir Capitalizacion
            if (frmMain.getOpcCapitalizacion() == e.getSource()) {
                cerrarTodo();
                frmCapitalizacion = new frmCapitalizacion();
                frmMain.getLblBackground().add(frmCapitalizacion);
                frmCapitalizacion.setVisible(true);
                frmCapitalizacion.getBtnCalcular().addActionListener(this);
                frmCapitalizacion.getBtnCerrar().addActionListener(this);
            }
            // Cerrar Capitalizacion
            if (frmCapitalizacion.getBtnCerrar() == e.getSource()) {
                frmCapitalizacion.dispose();
            }
            // Calculo Capitalizacion
            if (frmCapitalizacion.getBtnCalcular() == e.getSource()) {
                if (frmCapitalizacion.getTxtMonto().getText().length() < 1) {
                    JOptionPane.showMessageDialog(frmMain, "No se puede Registrar, no hay datos ingresados");
                }
                objAnualidades.setMonto(0);
                objAnualidades.setPlazo(0);
                objAnualidades.setInteres(0);
                objAnualidades.setMonto(Double.parseDouble(frmCapitalizacion.getTxtMonto().getText()));
                objAnualidades.setPlazo(Double.parseDouble(frmCapitalizacion.getTxtNumeroPagos().getText()));
                objAnualidades.setInteres(Double.parseDouble(frmCapitalizacion.getTxtInteres().getText()));
                objAnualidades.setTasa(objAnualidades.getInteres() / 100);
                objAnualidades.transformarInteres(frmCapitalizacion.getCmbTipoInteres().getSelectedIndex());
                if (frmCapitalizacion.getJcbTipoPlazo().isSelected()) {
                    objAnualidades.anticipada();
                }
                objAnualidades.definirVariables(frmCapitalizacion.getCmbPeriodo().getSelectedIndex(), frmCapitalizacion.getCmbTipoInteres().getSelectedIndex());
                objAnualidades.calcularCuotaCapitalizacion();
                objAnualidades.setSaldo(objAnualidades.getCuota());
                objAnualidades.construct();
                objAnualidades.setPeriodo(1);

                //Abrir Tabla
                frmCapitalizacion.dispose();
                frmTabla = new frmTabla();
                frmMain.getLblBackground().add(frmTabla);
                frmTabla.setVisible(true);
                frmTabla.getTblTabla().setModel(objAnualidades.generarTablaCapitalizacion());
                frmTabla.getLblTitulo().setText("Resultado Capitalización");
                frmTabla.getLblResultado().setText("Se deberarán de invertir " + (objAnualidades.getPeriodo() - 1) + " cuotas, cada una por un valor de $ " + objAnualidades.getCuota());
                frmTabla.getBtnCerrar().addActionListener(this);
            }
            // Cerrar Tabla
            if (frmTabla.getBtnCerrar() == e.getSource()) {
                frmTabla.dispose();
            }
        } catch (Exception ex) {
            cerrarTodo();
            JOptionPane.showMessageDialog(frmMain, "Error, por favor vuelva a intentarlo");
        }
    }

    // Cerrar Todo
    public void cerrarTodo() {
        frmNominalEfectiva.dispose();
        frmEfectivaNominal.dispose();
        frmNominalNominal.dispose();
        frmEfectivaEfectiva.dispose();
        frmAmortizacion.dispose();
        frmCapitalizacion.dispose();
        frmTabla.dispose();
    }
}
