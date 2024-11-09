package parcialprogramacion;

import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;

public class Onl extends Alumno{
    protected String tps;

    public String getTps() {
        return tps;
    }

    public void setTps(String tps) {
        this.tps = tps;
    }

    public Onl(String tps, int id, String nomc, Date fIng, int[] notas) {
        super(id, nomc, fIng, notas);
        this.tps = tps;
    }

    public Onl() {
        super();
        this.tps = "";
    }
    
    public void regis(int i) throws ParseException{
        super.regis(i);
        this.tps = JOptionPane.showInputDialog("Entrego todos los tps?(Si - No)");
    }
    
    public String mos(){
       String a=super.mos();
       a+="\nTps entregados: "+this.tps;
       a+="\nPromedio: "+super.prom();
       return a+="\nEstado: "+this.est();
    }
    
    public String est(){
        if(super.prom()>=4){
            if(super.prom()>=7 && this.tps.equalsIgnoreCase("Si")) return "Promocionado";
            else return "Regular";
        }else return "Libre";
    }
    
    
    
}
