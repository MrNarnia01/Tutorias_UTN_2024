package com.mycompany.clase_24_08;

import javax.swing.JOptionPane;

public class Clase_24_08 {

    public static void main(String[] args) {
        /*
            *Aclaracion: JOptionPane se usa para mostrar 
                    o pedir info en pantalla tipo pop-up
        */
        
        //Prueba del metodo contructor sin parametros
        Alumno alumno= new Alumno();
        JOptionPane.showMessageDialog(null, alumno.mostrar());
        //Prueba del metodo contructor con parametros
        alumno= new Alumno("juan",22);
        JOptionPane.showMessageDialog(null, alumno.mostrar());
        //Prueba del metodo registrar
        alumno.registrar();
        JOptionPane.showMessageDialog(null, alumno.mostrar());
        
    }
    
}
