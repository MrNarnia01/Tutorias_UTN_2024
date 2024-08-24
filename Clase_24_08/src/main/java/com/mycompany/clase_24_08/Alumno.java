package com.mycompany.clase_24_08;

import javax.swing.JOptionPane;

public class Alumno {
    
    private String nombre;
    private int edad;
    
    
    Alumno(){
        this.nombre="nada";
        this.edad=0;
    }
    
    Alumno(String n, int e){
        this.nombre=n;
        this.edad=e;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void registrar(){
        this.nombre=JOptionPane.showInputDialog("Ingrese nombre");
        String e=JOptionPane.showInputDialog("Ingrese edad");
        this.edad = Integer.parseInt(e);
    }
    
    public String mostrar(){
        String a="";
        a+="Nombre: "+this.nombre;
        a+="    Edad: "+this.edad;
        return a;
    }
    
}
