package com.mycompany.clase_24_08;

import javax.swing.JOptionPane;

public class Alumno {
    //Se crean los atributos
    private String nombre;
    private int edad;
    
    //Constructor sin parametros
    Alumno(){
        this.nombre="";
        this.edad=0;
    }
    //Constructor con parametros
    Alumno(String n, int e){
        this.nombre=n;
        this.edad=e;
    }
    //Getters y Setters
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
    //Metodos a gusto del programador
    //Este metodo es para registrar los datos y guardarlos en el objeto
    public void registrar(){
        this.nombre=JOptionPane.showInputDialog("Ingrese nombre");
        String e=JOptionPane.showInputDialog("Ingrese edad");
        this.edad = Integer.parseInt(e);
    }
    //Este metodo devuelve ordenado los datos de un alumno
    public String mostrar(){
        String a="";
        a+="Nombre: "+this.nombre;
        a+="    Edad: "+this.edad;
        return a;
    }
    
}
