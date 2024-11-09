package parcialprogramacion;

import java.text.ParseException;
import javax.swing.JOptionPane;

public class Listado {
    protected Alumno[] v;

    public Alumno getV(int i) {
        return v[i];
    }
    
    public int largev(){
        return v.length;
    }

    public void setV(Alumno[] v) {
        this.v = v;
    }

    public Listado() throws ParseException {
        int n=0;
        String alu;
        n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de alumno que tiene:"));
        v=new Alumno[n];
        for (int i = 0; i < n; i++) {
            alu=JOptionPane.showInputDialog("Su alumno es virtual o presencial");
            if(alu.equalsIgnoreCase("virtual")){
                v[i]=new Onl();
                ((Onl) v[i]).regis(i);
                JOptionPane.showMessageDialog(null,((Onl) v[i]).mos());
            }else{
                v[i]=new Pre();
                ((Pre) v[i]).regis(i);
                JOptionPane.showMessageDialog(null,((Pre) v[i]).mos());
            }
            
        } 
    }
    
    public int bus(){
        String b=JOptionPane.showInputDialog("Ingrese el nombre que desea buscar");
        int l = -1;
        for (int i = 0; i < v.length && l==-1; i++) {
            if(b.equalsIgnoreCase(v[i].getNomc())) l=i;
        }
        return l;
    }
    
    
}
