package tienda_guia4;

import javax.swing.JOptionPane;

public class Alimento extends Producto {
    private String per;

    public String getPer() {
        return per;
    }

    public void setPer(String per) {
        this.per = per;
    }

    public Alimento(String per, int id, String nombre, String marca, float precio_base) {
        super(id, nombre, marca, precio_base);
        this.per = per;
    }
    
    public Alimento() {
        super();
        this.per = "";
    }
    
    public void regis(int i){
        super.regis(i+1);
        this.per=JOptionPane.showInputDialog("Ingrese si es perecedero o no");
    }
    
    public float precio_final(){
        float p=super.getPrecio_base();
        if(this.per.equalsIgnoreCase("Si"))    return (float) (p+(p*0.05));
        return (float) (p-(p*0.1));
    }
    
    public String mos(){
        String a=super.mos();
        a+="    Perecedero: "+this.per;
        a+="    P.Final: "+this.precio_final();
        return a;
    }
    
}
