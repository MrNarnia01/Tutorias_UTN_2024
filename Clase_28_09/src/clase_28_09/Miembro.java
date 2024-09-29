package clase_28_09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Miembro {
    private int id;
    private String nom;
    private String rol;
    private Date fIn;
    private Date fBa;

    public Miembro(int id, String nom, String rol, Date fIn, Date fBa) {
        this.id = id;
        this.nom = nom;
        this.rol = rol;
        this.fIn = fIn;
        this.fBa = fBa;
    }
    
    public Miembro() {
        this.id = 0;
        this.nom = "";
        this.rol = "";
        this.fIn = null;
        this.fBa = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getfIn() {
        return fIn;
    }

    public void setfIn(Date fIn) {
        this.fIn = fIn;
    }

    public Date getfBa() {
        return fBa;
    }

    public void setfBa(Date fBa) {
        //Validacion para que la fecha de baja sea anterior o igual a hoy, no superior
        Date hoy = new Date();
        if(fBa.compareTo(hoy)<=0){
            this.fBa=fBa;
        }
    }
    
    void Registrar(int i) throws ParseException{
        //No registramos el rol ya que eso depende del proyecto
        this.id=i+1;
        this.nom=JOptionPane.showInputDialog("Ingrese el nombre");
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.fIn=format.parse(JOptionPane.showInputDialog("Ingrese la fecha de incorporacion"));
        
    }

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String a="Miembro{" + "id=" + id + ", nom=" + nom + ", rol=" + rol + ", fIn=" + format.format(fIn) + ", fBa=";
        if(this.fBa==null)    a+="No hay}";
        else    a+=format.format(fBa) + '}';
        return a;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
