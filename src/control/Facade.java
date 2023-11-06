/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import view.frmMain;
import view.frmNominalEfectiva;

/**
 *
 * @author victorhuertas
 */
public class Facade implements ActionListener {
    private frmMain frmMain;
    private frmNominalEfectiva frmNominalEfectiva;

    public Facade(frmMain frmMain, frmNominalEfectiva frmNominalEfectiva) {
        this.frmMain = frmMain;
        this.frmNominalEfectiva = frmNominalEfectiva;
    }
    
    public Facade() throws IOException{
        this.frmMain = new frmMain();
        this.frmNominalEfectiva = new frmNominalEfectiva();
        iniComponentStart();
    }
    
    public void start() {
        frmMain.setTitle("Ingenieria Economica");
        frmMain.setVisible(true);
    }
    
    public void iniComponentStart(){
        frmMain.getOpcNominalEfectiva().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
         
    }
}
