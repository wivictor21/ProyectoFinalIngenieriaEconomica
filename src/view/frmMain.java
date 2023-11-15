/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author victorhuertas
 */
public class frmMain extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public frmMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBackground = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        opcMetodoSimple = new javax.swing.JMenu();
        opcTasasNominales = new javax.swing.JMenuItem();
        opcTasasEfectivas = new javax.swing.JMenuItem();
        opcNominalEfectiva = new javax.swing.JMenuItem();
        opcEfectivaNominal = new javax.swing.JMenuItem();
        opcMetodoGrafico = new javax.swing.JMenu();
        opcAmortizacion = new javax.swing.JMenuItem();
        opcCapitalizacion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/background.gif"))); // NOI18N
        lblBackground.setAlignmentY(0.0F);

        opcMetodoSimple.setForeground(new java.awt.Color(0, 0, 0));
        opcMetodoSimple.setText("Conversión de Tasas");

        opcTasasNominales.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcTasasNominales.setText("Entre Tasas Nominales");
        opcTasasNominales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcTasasNominalesActionPerformed(evt);
            }
        });
        opcMetodoSimple.add(opcTasasNominales);

        opcTasasEfectivas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcTasasEfectivas.setText("Entre Tasas Efectivas");
        opcTasasEfectivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcTasasEfectivasActionPerformed(evt);
            }
        });
        opcMetodoSimple.add(opcTasasEfectivas);

        opcNominalEfectiva.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcNominalEfectiva.setText("De Nominal a Efectiva");
        opcNominalEfectiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcNominalEfectivaActionPerformed(evt);
            }
        });
        opcMetodoSimple.add(opcNominalEfectiva);

        opcEfectivaNominal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcEfectivaNominal.setText("De Efectiva a Nominal");
        opcMetodoSimple.add(opcEfectivaNominal);

        jMenuBar1.add(opcMetodoSimple);

        opcMetodoGrafico.setForeground(new java.awt.Color(0, 0, 0));
        opcMetodoGrafico.setText("Anualidades");

        opcAmortizacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcAmortizacion.setText("Amortización");
        opcAmortizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcAmortizacionActionPerformed(evt);
            }
        });
        opcMetodoGrafico.add(opcAmortizacion);

        opcCapitalizacion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        opcCapitalizacion.setText("Capitalización");
        opcCapitalizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcCapitalizacionActionPerformed(evt);
            }
        });
        opcMetodoGrafico.add(opcCapitalizacion);

        jMenuBar1.add(opcMetodoGrafico);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBackground)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBackground)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcNominalEfectivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcNominalEfectivaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcNominalEfectivaActionPerformed

    private void opcAmortizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcAmortizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcAmortizacionActionPerformed

    private void opcTasasNominalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcTasasNominalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcTasasNominalesActionPerformed

    private void opcTasasEfectivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcTasasEfectivasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcTasasEfectivasActionPerformed

    private void opcCapitalizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcCapitalizacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcCapitalizacionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JMenuItem opcAmortizacion;
    private javax.swing.JMenuItem opcCapitalizacion;
    private javax.swing.JMenuItem opcEfectivaNominal;
    private javax.swing.JMenu opcMetodoGrafico;
    private javax.swing.JMenu opcMetodoSimple;
    private javax.swing.JMenuItem opcNominalEfectiva;
    private javax.swing.JMenuItem opcTasasEfectivas;
    private javax.swing.JMenuItem opcTasasNominales;
    // End of variables declaration//GEN-END:variables

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JLabel getLblBackground() {
        return lblBackground;
    }

    public void setLblBackground(JLabel lblBackground) {
        this.lblBackground = lblBackground;
    }

    public JMenuItem getOpcAmortizacion() {
        return opcAmortizacion;
    }

    public void setOpcAmortizacion(JMenuItem opcAmortizacion) {
        this.opcAmortizacion = opcAmortizacion;
    }

    public JMenuItem getOpcCapitalizacion() {
        return opcCapitalizacion;
    }

    public void setOpcCapitalizacion(JMenuItem opcCapitalizacion) {
        this.opcCapitalizacion = opcCapitalizacion;
    }

    public JMenuItem getOpcEfectivaNominal() {
        return opcEfectivaNominal;
    }

    public void setOpcEfectivaNominal(JMenuItem opcEfectivaNominal) {
        this.opcEfectivaNominal = opcEfectivaNominal;
    }

    public JMenu getOpcMetodoGrafico() {
        return opcMetodoGrafico;
    }

    public void setOpcMetodoGrafico(JMenu opcMetodoGrafico) {
        this.opcMetodoGrafico = opcMetodoGrafico;
    }

    public JMenu getOpcMetodoSimple() {
        return opcMetodoSimple;
    }

    public void setOpcMetodoSimple(JMenu opcMetodoSimple) {
        this.opcMetodoSimple = opcMetodoSimple;
    }

    public JMenuItem getOpcNominalEfectiva() {
        return opcNominalEfectiva;
    }

    public void setOpcNominalEfectiva(JMenuItem opcNominalEfectiva) {
        this.opcNominalEfectiva = opcNominalEfectiva;
    }

    public JMenuItem getOpcTasasEfectivas() {
        return opcTasasEfectivas;
    }

    public void setOpcTasasEfectivas(JMenuItem opcTasasEfectivas) {
        this.opcTasasEfectivas = opcTasasEfectivas;
    }

    public JMenuItem getOpcTasasNominales() {
        return opcTasasNominales;
    }

    public void setOpcTasasNominales(JMenuItem opcTasasNominales) {
        this.opcTasasNominales = opcTasasNominales;
    }

    
    

    

    

}
