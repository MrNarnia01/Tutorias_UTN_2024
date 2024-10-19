package tienda_guia4;

import javax.swing.JOptionPane;

public class Catalogo {
    private Producto[] v;

    public Producto getV(int p) {
        return v[p];
    }

    public void setV(Producto v, int p) {
        this.v[p] = v;
    }
    
    public int largeV(){
        return v.length;
    }

    public Catalogo() {
        int n=Integer.parseInt( JOptionPane.showInputDialog("ingrese cantidad de productos"));
        String op="";
        v=new Producto[n];
        for (int i = 0; i < n; i++) {
            op=JOptionPane.showInputDialog("ingrese tipo de producto");
            switch (op) {
                case "ropa":
                    v[i]=new Ropa();
                    ((Ropa)v[i]).regis(i);
                    JOptionPane.showMessageDialog(null, ((Ropa)v[i]).mos());
                break;
                case "electronico":
                    v[i]=new Electronico();
                    ((Electronico)v[i]).regis(i);
                    JOptionPane.showMessageDialog(null, ((Electronico)v[i]).mos());
                break;
                case "alimento":
                    v[i]=new Alimento();
                    ((Alimento)v[i]).regis(i);
                    JOptionPane.showMessageDialog(null, ((Alimento)v[i]).mos());
                break;
            }
        }
        
    }
    
    public void ord(){
        for (int i = 0; i < largeV()-1; i++) {
            for (int j = i+1; j < largeV(); j++) {
                if(v[i].precio_final()<v[j].precio_final()){
                    Producto aux=v[i];
                    v[i]=v[j];
                    v[j]=aux;
                }
            }
        }
    }
    
    public String list(int p){
        String a="";
        this.ord();
        for (int i = 0; i < largeV(); i++) {
            if(p==1 && v[i] instanceof Ropa){
                a+=((Ropa) v[i]).mos();
            }else if(p==2 && v[i] instanceof Electronico){
                a+=((Electronico) v[i]).mos();
            }else if(p==3 && v[i] instanceof Alimento){
                a+=((Alimento) v[i]).mos();
            }
        }
        return a;
    }
    
    public String ListByOri(String ori){
        String a="";
        for (int i = 0; i < largeV(); i++) {
            if(v[i] instanceof Electronico){
                if( ((Electronico)v[i]).isOri().equalsIgnoreCase(ori))   a+=((Electronico) v[i]).mos();
            }
        }
        return a;
    }
    
    public int bus(int p, int id){
        int ban=-1;
        for (int i = 0; i < largeV(); i++) {
            if(v[i].getId()==id){
                if(p==1 && v[i] instanceof Ropa){
                    ban=i;
                }else if(p==2 && v[i] instanceof Electronico){
                    ban=i;
                }else if(p==3 && v[i] instanceof Alimento){
                    ban=i;
                }
            }
            
        }
        return ban;
    }
    
    
    
    
    
    
}
