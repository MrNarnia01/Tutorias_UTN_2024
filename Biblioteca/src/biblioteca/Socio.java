package biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Socio {
    private String nom;
    private Date fNac;
    private Long tel;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getfNac() {
        return fNac;
    }

    public void setfNac(Date fNac) {
        this.fNac = fNac;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Socio(String nom, Date fNac, Long tel) {
        this.nom = nom;
        this.fNac = fNac;
        this.tel = tel;
    }
    
    public Socio() {
        this.nom = "";
        this.fNac = null;
        this.tel = 0L;
    }
    
    public void regisS() throws ParseException{
        //Variable para las validaciones
        String v="";
        
        do{
            v=JOptionPane.showInputDialog("Ingrese el nombre");
        }while(v.isBlank());
        this.nom=v;
        
        Date hoy = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese la fecha de nacimiento");
            }while(v.isBlank());
        }while(format.parse(v).compareTo(hoy)>0);
        this.fNac=format.parse(v);
        
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese el telefono");
            }while(v.isBlank());
        }while(Long.parseLong(v)<=0);
        this.tel=Long.parseLong(v);
    }
    
    public String mos(){
        //Variable para guardar los datos
        String a="";
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        a+="Nombre: "+this.nom;
        a+=" - Fecha Nac: "+format.format(this.fNac);
        a+=" - Telefono: "+this.tel;
        return a;
    }
    
    public int edad(){
        Date hoy = new Date();
        return hoy.getYear()-this.fNac.getYear();
    } 
    
}
