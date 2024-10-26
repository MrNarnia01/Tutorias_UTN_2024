package matrices;

import javax.swing.JOptionPane;

public class Matrices {

    
    public static void main(String[] args) {
        int n=0;
        String op="";
        n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de vehiculos"));
        Vehiculo[] v=new Vehiculo[n];
        for (int i = 0; i < n; i++) {
            op=JOptionPane.showInputDialog("Moto o auto?");
            if(op.equalsIgnoreCase("auto")){
                v[i]= new Auto();
                ((Auto)v[i]).regis(i);
                JOptionPane.showMessageDialog(null,((Auto)v[i]).mos());
            }else{
                v[i]= new Moto();
                ((Moto)v[i]).regis(i);
                JOptionPane.showMessageDialog(null,((Moto)v[i]).mos());
            }
        }
        
        Vehiculo aux=new Vehiculo();
         op=JOptionPane.showInputDialog("Moto o auto?");
            if(op.equalsIgnoreCase("auto")){
                aux= new Auto();
                ((Auto)aux).regis(n);
                JOptionPane.showMessageDialog(null,((Auto)aux).mos());
            }else{
                aux= new Moto();
                ((Moto)aux).regis(n);
                JOptionPane.showMessageDialog(null,((Moto)aux).mos());
            }
        
        Vehiculo[] va=new Vehiculo[n+1];
        for (int i = 0; i < n; i++) {
            va[i]=v[i];
        }
        va[n]=aux;
        
        v=va;
        n++;
        
        op="";
        for (int i = 0; i < n; i++) {
            if(v[i] instanceof Auto){
                op+=((Auto)v[i]).mos();
            }else{
                op+=((Moto)v[i]).mos();
            }
        }
        JOptionPane.showMessageDialog(null, op);
        
        
        int[][]m=new int[2][2];
        
        for (int i = 0; i < 2; i++) {
            m[0][i]=0;
            m[1][i]=0;
        }
        
        for (int i = 0; i < n; i++) {
            if(v[i] instanceof Auto){
                if(((Auto)v[i]).getMarca().equalsIgnoreCase("toyota")){
                    m[0][0]++;
                }else   m[0][1]++;
            }else{
                if(((Moto)v[i]).getCil()==35)   m[1][0]++;
                else m[1][1]++;
            }
        }
        op="Auto toyota: "+m[0][0];
        op+="\nAuto Nyssan: "+m[0][1];
        op+="\nMoto de 35: "+m[1][0];
        op+="\nMoto de 45: "+m[1][1];
        
        JOptionPane.showMessageDialog(null, op);
        
        //Conteo
        for (int i = 0; i < 2; i++) {
            m[0][i]=0;
            m[1][i]=0;
        }
        
        
        for (int i = 0; i < n; i++) {
            if(v[i] instanceof Auto){
                if(((Auto)v[i]).getMarca().equalsIgnoreCase("toyota")){
                    m[0][0]+=((Auto)v[i]).getCantP();
                }else   m[0][1]+=((Auto)v[i]).getCantP();
            }
        }
        op="Cant puertas toyota: "+m[0][0];
        op+="\nCant puertas nyssan: "+m[0][1];
        
        JOptionPane.showMessageDialog(null, op);
        
        
    }
    
}
