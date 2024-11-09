package parcialprogramacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public abstract class Alumno {
    protected int id;
    protected String nomc;
    protected Date fIng;
    protected int[] notas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomc() {
        return nomc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

    public Date getfIng() {
        return fIng;
    }

    public void setfIng(Date fIng) {
        this.fIng = fIng;
    }

    public int[] getNotas() {
        return notas;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }

    public Alumno(int id, String nomc, Date fIng, int[] notas) {
        this.id = id;
        this.nomc = nomc;
        this.fIng = fIng;
        this.notas = notas;
    }
    
    public Alumno() {
        this.id = 0;
        this.nomc = "";
        this.fIng = null;
        int[] aux = new int[3];
        for (int i = 0; i < 3; i++) aux[i]=0; 
        this.notas = aux;
    }
    
    public void regis(int i) throws ParseException{
        this.id=i+1;
        this.nomc= JOptionPane.showInputDialog("Ingrese el nombre");
        Date hoy = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        do{
            this.fIng=format.parse(JOptionPane.showInputDialog("Ingrese fecha de ingreso(dd/MM/yyyy)"));
        }while(this.fIng.compareTo(hoy)>0);
        for (int j = 0; j < 3; j++) {
            this.notas[j]= Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota N "+ (j+1) +" (1-10)"));
        }
        
    }
    
    public String mos(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String a="Nombre: "+this.nomc;
        a+="\nF.Ingreso: "+format.format(this.fIng);
        for (int j = 0; j < 3; j++) {
            a+="\nNota "+ (j+1) +" : "+ this.notas[j];
        }
        return a;
    }
    
    public abstract String est();
    
    public int prom(){
        return ((notas[0]+notas[1]+notas[2])/3);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
