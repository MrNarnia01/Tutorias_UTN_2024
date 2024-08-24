package com.mycompany.clase_24_08;

import javax.swing.JOptionPane;

public class Clase_24_08 {

    public static void main(String[] args) {
        
        Alumno alumno= new Alumno();
        JOptionPane.showMessageDialog(null, alumno.mostrar());
           
        alumno= new Alumno("juan",22);
        JOptionPane.showMessageDialog(null, alumno.mostrar());
        
        alumno.registrar();
        JOptionPane.showMessageDialog(null, alumno.mostrar());
        
    }
    
}
