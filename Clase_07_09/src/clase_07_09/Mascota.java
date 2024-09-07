package clase_07_09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Mascota {
    private int cod;
    private String nom;
    private String esp;
    private String raza;
    private Date fNac;
    private Date fDef;

    public int getCod() {
        return cod;
    }

    private void setCod(int cod) {
        this.cod = cod;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Date getfNac() {
        return fNac;
    }

    public void setfNac(Date fNac) {
        this.fNac = fNac;
    }

    public Date getfDef() {
        return fDef;
    }

    public int setfDef(Date fDef) {
        Date hoy = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        if(this.fNac.compareTo(fDef)<0 && fDef.compareTo(hoy)<=0 && this.fDef==null){ 
            this.fDef = fDef;
        }else   return -1;
        return 0;
    }

    public Mascota(int cod, String nom, String esp, String raza, Date fNac, Date fDef) {
        this.cod = cod;
        this.nom = nom;
        this.esp = esp;
        this.raza = raza;
        this.fNac = fNac;
        this.fDef = fDef;
    }
    
    public Mascota() {
        this.cod = 0;
        this.nom = "";
        this.esp = "";
        this.raza = "";
        this.fNac = null;
        this.fDef = null;
    }
    
    public void regis(int i) throws ParseException{
        this.cod=i+1;
        String v="";
        do{
            v=JOptionPane.showInputDialog("Ingrese nombre de la mascota");
        }while(v.isBlank());
        this.nom=v;
        
        do{
            v=JOptionPane.showInputDialog("Ingrese la especie de la mascota");
        }while(!v.equalsIgnoreCase("perro") &&
                !v.equalsIgnoreCase("gato") &&
                !v.equalsIgnoreCase("conejo"));
        //v.compareToIgnoreCase("perro")!=0
        this.esp=v;
        
        do{
            v=JOptionPane.showInputDialog("Ingrese la raza de la mascota");
        }while(v.isBlank());
        this.raza=v;
        
        Date hoy = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        do{
            do{
            v=JOptionPane.showInputDialog("Ingrese fecha de nacimiento(dd/mm/yyyy)");
            }while(v.isBlank());
        }while(format.parse(v).compareTo(hoy)>0);
        this.fNac=format.parse(v);
        
    }
    
    public String mostrar(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String a="\n";
        a+="\nCodigo: "+this.cod;
        a+="\nNombre: "+this.nom;
        a+="\nEspecie: "+this.esp;
        a+="\nRaza: "+this.raza;
        a+="\nF Nacimiento: "+format.format(this.fNac);
        a+="\nF Defuncion: ";
        if(this.fDef==null){
            a+="No murio";
        }else a+=format.format(this.fDef);
        return a;
    }
    
    public int edad(){
        int e=0;
        Date hoy = new Date();
        if(this.fDef==null){
            return (hoy.getYear()-this.fNac.getYear());
        }else{
            return (this.fDef.getYear()-this.fNac.getYear());
        }
    }
    
    public void elm(){
        this.cod=-1;
    }
}
