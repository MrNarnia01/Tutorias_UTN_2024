package clase_28_09;

import javax.swing.JOptionPane;

public class Proyecto {
    private String nom;
    private int dura;
    private Miembro[] mie;

    public Proyecto(String nom, int dura, Miembro[] mie) {
        this.nom = nom;
        this.dura = dura;
        this.mie = mie;
    }
    
    public Proyecto() {
        this.nom = "";
        this.dura = 0;
        //Esta inicializacion nos sirve para mas adelante en unu set personalizado
        this.mie = new Miembro[0];
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDura() {
        return dura;
    }

    public void setDura(int dura) {
        this.dura = dura;
    }
    
    public int getLargeMie(){
        return this.mie.length;
    }
    
    public Miembro getMie(int p) {
        return mie[p];
    }
    //Set personlaizado
    public void setMie(Miembro m) {
        //Revisamos que haya lugar para añadir miembros
        if(mie.length<10){
            //Creamos un vector auxiliar de una posicion mas larga que el anterior
            Miembro[] aux = new Miembro[mie.length+1];
            //Copiamos todos los miembros que ya teniamos
            for (int i = 0; i < mie.length; i++) {
                aux[i]=mie[i];
            }
            //Añadimos el nuevo en la ultima posicion
            aux[mie.length]= m;
            //Guardamos el vector con el nuevo miembro
            this.mie=aux;
        }
    }

    @Override
    public String toString() {
        String a="Proyecto{" + "nom=" + nom + ", dura=" + dura + '}';
        for (int i = 0; i < mie.length; i++) {
            a+="\n"+mie[i].toString();
        }
        return a;
    }
    //Solo pedimos 2 datos, los miembros se los cargamos individualmente con el set personalizado
    public void Registrar(){
        this.nom=JOptionPane.showInputDialog("Ingrese nombre del proyecto");
        this.dura=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duracion del proyecto"));
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
