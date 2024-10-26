package matrices;

import javax.swing.JOptionPane;

public class Vehiculo {
    private int id;
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vehiculo(int id, String color) {
        this.id = id;
        this.color = color;
    }
    
    public Vehiculo() {
        this.id = 0;
        this.color = "";
    }

    public void registrar(int id){
        this.id=id+1;
        this.color=JOptionPane.showInputDialog("Ingrese el color");
    }

    public String mos(){
        String a="\nId: "+this.id;
        return a+=" Color: "+this.color;
    }
    
    
}
