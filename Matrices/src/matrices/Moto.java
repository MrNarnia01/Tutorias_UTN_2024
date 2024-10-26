package matrices;

import javax.swing.JOptionPane;

public class Moto extends Vehiculo{
    private int cil;

    public int getCil() {
        return cil;
    }

    public void setCil(int cil) {
        this.cil = cil;
    }

    public Moto(int cil, int id, String color) {
        super(id, color);
        this.cil = cil;
    } 
    public Moto() {
        super(0, "");
        this.cil = 0;
    }
    
    public void regis(int id){
        super.registrar(id);
        this.cil=Integer.parseInt( JOptionPane.showInputDialog("Ingrese tamaño de cilindradas"));
        
    }
    
    public String mos(){
        String a=super.mos();
        return a+=" Cilindradas: "+this.cil;
    }
}
