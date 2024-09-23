package biblioteca;

import javax.swing.JOptionPane;

public class Libro {
    private String tit;
    private int cantH;
    private String gen;
    private String edi;
    private String est;

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public int getCantH() {
        return cantH;
    }

    public void setCantH(int cantH) {
        this.cantH = cantH;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getEdi() {
        return edi;
    }

    public void setEdi(String edi) {
        this.edi = edi;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }
    
    public void devolver(){
        this.est="en biblioteca";
    }
    
    public Libro(String tit, int cantH, String gen, String edi, String est) {
        this.tit = tit;
        this.cantH = cantH;
        this.gen = gen;
        this.edi = edi;
        this.est = est;
    }
    
    public Libro() {
        this.tit = "";
        this.cantH = 0;
        this.gen = "";
        this.edi = "";
        this.est = "";
    }
    
    public void regisL(){
        //Variable para validaciones
        String v="";
        
        do{
            v=JOptionPane.showInputDialog("Ingrese el titulo del libro");
        }while(v.isBlank());
        this.tit=v;
        
        do{
            do{
            v=JOptionPane.showInputDialog("Ingrese la cantidad de hojas");
            }while(v.isBlank());
        }while(Integer.parseInt(v)<1);
        this.cantH=Integer.parseInt(v);
        
        do{
            v=JOptionPane.showInputDialog("Ingrese el genero del libro");
        }while(!v.equalsIgnoreCase("novela") &&
                !v.equalsIgnoreCase("poesia") &&
                !v.equalsIgnoreCase("cuento"));
        this.gen=v;
        
        do{
            v=JOptionPane.showInputDialog("Ingrese la editorial del libro");
        }while(!v.equalsIgnoreCase("Anagrama") &&
                !v.equalsIgnoreCase("Anaya") &&
                !v.equalsIgnoreCase("Planeta"));
        this.edi=v;
        
        //Lo pongo automaticamente en prestado ya que tecnicamente estamos creando un prestamo
        this.est="prestado";
    }
    
    public String mos(){
        //Variable donde se guara la info
        String a="";
        a+="\nTitulo: "+this.tit;
        a+=" - Cant. Hojas: "+this.cantH;
        a+=" - Genero: "+this.gen;
        a+=" - Editorial: "+this.edi;
        a+=" - Estado: "+this.est;
        return a;
    }
    
    
}
