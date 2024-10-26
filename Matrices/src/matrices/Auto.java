package matrices;

import javax.swing.JOptionPane;


public class Auto extends Vehiculo{
    private int cantP;
    private String marca;

    public int getCantP() {
        return cantP;
    }

    public void setCantP(int cantP) {
        this.cantP = cantP;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Auto(int cantP, String marca, int id, String color) {
        super(id, color);
        this.cantP = cantP;
        this.marca = marca;
    }
    
    public Auto() {
        super(0,"" );
        this.cantP = 0;
        this.marca = "";
    }
    
    public void regis(int id){
        super.registrar(id);
        this.cantP=Integer.parseInt( JOptionPane.showInputDialog("Ingrese las puertas"));
        this.marca=JOptionPane.showInputDialog("Ingrese las marca");
        
    }
    
    public String mos(){
        String a=super.mos();
        return a+=" Cant.Puertas: "+this.cantP+" Marca: "+this.marca;
    }
    
}
