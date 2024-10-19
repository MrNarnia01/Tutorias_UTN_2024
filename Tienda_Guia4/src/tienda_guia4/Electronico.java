package tienda_guia4;

import javax.swing.JOptionPane;

public class Electronico extends Producto{
    private String gar;
    private String ori;

    public String isGar() {
        return gar;
    }

    public void setGar(String gar) {
        this.gar = gar;
    }

    public String isOri() {
        return ori;
    }

    public void setOri(String ori) {
        this.ori = ori;
    }

    public Electronico(String gar, String ori, int id, String nombre, String marca, float precio_base) {
        super(id, nombre, marca, precio_base);
        this.gar = gar;
        this.ori = ori;
    }
    
    public Electronico() {
        super();
        this.gar = "";
        this.ori = "";
    }
    
    public void regis(int i){
        super.regis(i+1);
        this.gar=JOptionPane.showInputDialog("Ingrese si tiene garantia");
        this.ori=JOptionPane.showInputDialog("Ingrese si tiene origen(nacional/importado)");
    }
    
    public float precio_final(){
        float p=super.getPrecio_base();
        if(this.gar.equalsIgnoreCase("Si") && this.ori.equalsIgnoreCase("Nacional"))    return (float) (p+(p*0.15));
        return p;
    }
    
    public String mos(){
        String a=super.mos();
        a+="    Garantia: "+this.gar;
        a+="    Origen: "+this.ori;
        a+="    P.Final: "+this.precio_final();
        return a;
    }
    
    
}
