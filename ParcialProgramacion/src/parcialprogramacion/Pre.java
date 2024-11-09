package parcialprogramacion;

import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;

public class Pre extends Alumno{
    protected int asis;

    public int getAsis() {
        return asis;
    }

    public void setAsis(int asis) {
        this.asis = asis;
    }

    public Pre(int asis, int id, String nomc, Date fIng, int[] notas) {
        super(id, nomc, fIng, notas);
        this.asis = asis;
    }

    public Pre() {
        super();
        this.asis = 0;
    }
    
    public void regis(int i) throws ParseException{
        super.regis(i);
        this.asis = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la asistencia (1-100)"));
    }
    
    public String mos(){
       String a=super.mos();
       a+="\nAsistencia: "+this.asis;
       a+="\nPromedio: "+super.prom();
       return a+="\nEstado: "+this.est();
    }
    
    public String est(){
        if(asis>=75){
            if(super.prom()>=4){
                if(super.prom()>=7) return "Promocionado";
                else return "Regular";
            }else return "Libre";
        }else return "Libre";
    }
    
    
}
