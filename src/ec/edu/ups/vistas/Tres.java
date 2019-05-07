/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vistas;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author erics
 */
public class Tres {
     private int turno;
    private int turnoX;
    private int turnoO;
    
    public Tres() {
    }

    public Tres(int turno, int turnoX, int turnoO) {
        this.turno = turno;
        this.turnoX = turnoX;
        this.turnoO = turnoO;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getTurnoX() {
        return turnoX;
    }

    public void setTurnoX(int turnoX) {
        this.turnoX = turnoX;
    }

    public int getTurnoO() {
        return turnoO;
    }

    public void setTurnoO(int turnoO) {
        this.turnoO = turnoO;
    }
    
    public void intercambio() {
        if (getTurno() == 0) {
            setTurno(1);
        } else {
            setTurno(0);
        }
    }
    
    public int posibilidad(int matriz[][]) {
       
        if (matriz[0][0] == matriz[0][1] & matriz[0][0] == matriz[0][2]) {
            return 1;
        }
        
        if (matriz[1][0] == matriz[1][1] & matriz[1][0] == matriz[1][2]) {
            return 2;
        }
        
        if (matriz[2][0] == matriz[2][1] & matriz[2][0] == matriz[2][2]) {
            return 3;
        }

        
        if (matriz[0][0] == matriz[1][0] & matriz[0][0] == matriz[2][0]) {
            return 4;
        }
        
        if (matriz[0][1] == matriz[1][1] & matriz[0][1] == matriz[2][1]) {
            return 5;
        }
        
        if (matriz[0][2] == matriz[1][2] & matriz[0][2] == matriz[2][2]) {
            return 6;
        }

        
        if (matriz[0][0] == matriz[1][1] & matriz[0][0] == matriz[2][2]) {
            return 7;
        }
        
        if (matriz[0][2] == matriz[1][1] & matriz[0][2] == matriz[2][0]) {
            return 8;
        }
        
        return 0;
    }
    
    public int jugar(javax.swing.JButton btt, int i, int j, int matriz[][], javax.swing.JLabel jX, javax.swing.JLabel jO) {
        matriz[i][j] = getTurno();
        String n = new String();
        if (getTurno() == 0) {
            n = "X";
            btt.setForeground(Color.red);
        }else{
            n = "O";
            btt.setForeground(Color.blue);
        }
        
        intercambio();
        btt.setText(n);
        btt.setEnabled(false);
        
        if(posibilidad(matriz)!=0){
            JOptionPane.showMessageDialog(null, "Ganaste: "+n);
            if(getTurno()==1){
                setTurnoX(getTurnoX()+1);
                jX.setText(String.valueOf(getTurnoX()));
            }
            
            if(getTurno()==0){
                setTurnoO(getTurnoO()+1);
                jO.setText(String.valueOf(getTurnoO()));
            }
            return 1;
        }
        return 0;
    }
    public void rayar(int matriz[][], javax.swing.JPanel p, int n, int i, int j){
        matriz[i][j]=getTurno();
        if(posibilidad(matriz)==n){
            p.setVisible(true);
        }
    }
    
    public void rayar(int matriz[][], javax.swing.JLabel p, int n, int i, int j){
        matriz[i][j]=getTurno();
        if(posibilidad(matriz)==n){
            p.setVisible(true);
        }
}
}
