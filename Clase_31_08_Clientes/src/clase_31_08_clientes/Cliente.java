package clase_31_08_clientes;

import javax.swing.JOptionPane;

public class Cliente {
    
    private int id;
    private String nom;
    private String ape;
    private Long tel;
    private int edad;
    
    Cliente(){
        this.id=0;
        this.edad=0;
        this.tel=0L;
        this.nom="";
        this.ape="";
    }
    
    Cliente(int i,int e,String n,String a,Long t){
        this.id=i;
        this.edad=e;
        this.tel=t;
        this.nom=n;
        this.ape=a;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    void elm(){
        this.id=-1;
    }
    
    String mostrar(){
        String a="";
        a+="\nNombre: "+this.nom;
        a+="\nApellido: "+this.ape;
        a+="\nEdad: "+this.edad;
        a+="\nTelefono: "+this.tel;
        return a;
    }
    
    void registrar(int i){
        String v="";
        this.id=i+1;
        do{
            this.nom=JOptionPane.showInputDialog("Ingrese nombre: ");
        }while(this.nom.isBlank());
        do{
            this.ape=JOptionPane.showInputDialog("Ingrese apellido: ");
        }while(this.ape.isBlank());
        
        do{
            v=JOptionPane.showInputDialog("Ingrese edad: ");
        }while(v.isBlank());
        this.edad=Integer.parseInt(v);
        
        do{
            v=JOptionPane.showInputDialog("Ingrese el telefono: ");
        }while(v.isBlank());
        this.tel=Long.parseLong(v);
        
    }
    
    
    
    
}
