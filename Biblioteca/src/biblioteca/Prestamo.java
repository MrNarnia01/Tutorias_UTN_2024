package biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Prestamo {
    private int id;
    private Socio soc;
    private Libro lib[];
    private Date fPres;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Socio getSoc() {
        return soc;
    }

    public void setSoc(Socio soc) {
        this.soc = soc;
    }

    public Date getfPres() {
        return fPres;
    }

    public void setfPres(Date fPres) {
        this.fPres = fPres;
    }
    
    //Con este get vamos a sacar de a una sola posicion para laburar de forma mas ordenada
    public Libro getLib(int p) {
        return lib[p];
    }
    
    //Este get es para pedir el tamaño del vector lib[]
    public int getLibLarge(){
        return this.lib.length;
    }
    
    //Este set lo vamos a utilizar para añadir un nuevo libro al prestamo 
    public void setLib() {
        //Variable con el largo original
        int n = this.lib.length;
        //Creamos aux con una posicion mas
        Libro  aux[]=new Libro[n+1];
        //Copiamos los datos que ya teniamos
        for (int i = 0; i < n; i++) {
            aux[i]=this.lib[i];
        }
        //Creamos el nuevo libro
        aux[n]=new Libro();
        aux[n].regisL();
        //Guardamos el nuevo vector
        this.lib=aux;
    }
    
    public Prestamo(int id, Socio soc, Libro[] lib, Date fPres) {
        this.id = id;
        this.soc = soc;
        this.lib = lib;
        this.fPres = fPres;
    }
    
    public Prestamo() {
        this.id = 0;
        this.soc = new Socio();
        this.lib = null;
        this.fPres = null;
    }
    
    public void regisP(int i) throws ParseException{
        //Variable para las validaciones
        String v="";
        
        //Vamos a hacer que el id empiece en 1, por eso la suma
        this.id=i+1;
        
        Date hoy = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese la fecha del prestamo");
            }while(v.isBlank());
        }while(format.parse(v).compareTo(hoy)>0);
        this.fPres=format.parse(v);
        
        this.soc.regisS();
        
        //Pido cantidad de libro y lo valido
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese la cantidad de libros que quiere prestar");
            }while(v.isBlank());
        }while(Integer.parseInt(v)<1 || Integer.parseInt(v)>5);
        
        //Creacion de array una vez validado la cantidad de libros, re utilizo la variable i
        i=Integer.parseInt(v);
        lib = new Libro[i];
        for (int j = 0; j < i; j++) {
            lib[j]=new Libro();
            lib[j].regisL();
        }
    }
    
    public String mos(){
        //Variable para guardar los datos
        String a="";
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        a+="\nId: "+this.id;
        a+="\nFecha prestamo: "+format.format(this.fPres);
        a+="\nSocio:\n"+this.soc.mos();
        a+="\nLibro/s";
        for (int i = 0; i < this.getLibLarge(); i++) {
            a+=this.lib[i].mos();
        }
        return a;
    }
    
    
}
