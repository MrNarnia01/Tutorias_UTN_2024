package tienda_guia4;

import javax.swing.JOptionPane;

public class Ropa extends Producto{
    private String tama;

    public String getTama() {
        return tama;
    }

    public void setTama(String tama) {
        this.tama = tama;
    }

    public Ropa(String tama, int id, String nombre, String marca, float precio_base) {
        super(id, nombre, marca, precio_base);
        this.tama = tama;
    }

    public Ropa() {
        super();
        this.tama = "";
    }
    
    public void regis(int i){
        super.regis(i+1);
        this.tama=JOptionPane.showInputDialog("Ingrese el tamaño(pequeño/mediano/grande)");
    }
    
    public float precio_final(){
        float p=super.getPrecio_base();
        if(this.tama.equalsIgnoreCase("Pequeño"))   return (float) (p+(p*0.05));
        if(this.tama.equalsIgnoreCase("Mediano"))   return (float) (p+(p*0.07));
        else   return (float) (p+(p*0.1));
    }
    
    public String mos(){
        String a=super.mos();
        a+="    Tamaño: "+this.tama;
        a+="    P.Final: "+this.precio_final();
        return a;
    }
    
}
