package clase_07_09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class Clase_07_09 {
    
    public static Mascota []vm;
    public static int n;
    
    public static void main(String[] args) throws ParseException {
        n=0;
        String v="";
        String op="";
        int l=0;
        int h=0;
        do{
            do{
                v=JOptionPane.showInputDialog("Ingrese cantidad de mascotas");
            }while(v.isBlank());
            n=Integer.parseInt(v);
        }while(n<1);
        vm=new Mascota[n];
        for (int i = 0; i < n; i++) {
            vm[i]= new Mascota();
            vm[i].regis(i);
            JOptionPane.showMessageDialog(null, vm[i].mostrar());
        }
        
        
        do{
            op=JOptionPane.showInputDialog("""
                                           1-Registrar defuncion
                                           2-Modificar datos por nombre y especie
                                           3-Eliminar por nombre y especie
                                           4-Listar perro mas longevo
                                           5-Listar edad de los conejos
                                           6-Listar datos de perros fallecidos en el mes actual
                                           7-Gatos por fecha de nacimiento
                                           8-Listado por especie
                                           9-Salir""");
            switch(Integer.parseInt(op)){
                case 1:
                    l=bus();
                    if(l!=-1){
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        do{
                            v=JOptionPane.showInputDialog("Ingrese fecha de defuncion");
                            h=vm[l].setfDef(format.parse(v));
                            v="";
                        }while(h==-1);
                           JOptionPane.showMessageDialog(null, vm[l].mostrar());
                    }else JOptionPane.showMessageDialog(null, "Error");
                break;
                case 2:
                    l=bus();
                    if(l!=-1){
                        vm[l].regis(vm[l].getCod()-1);
                        JOptionPane.showMessageDialog(null, vm[l].mostrar());
                    }else JOptionPane.showMessageDialog(null, "Error");
                break;
                case 3:
                    l=bus();
                    if(l!=-1){
                        vm[l].elm(); 
                    }else JOptionPane.showMessageDialog(null, "Error");
                break;
                case 4:
                    
                break;
                case 5:
                    
                break;
                case 6:
                    
                break;
                case 7:
                    
                break;
                case 8:
                    
                break;
                case 9:
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalido");
            } 
        }while(Integer.parseInt(op)!=9);
        
    }
    
    public static int bus(){
        int b=-1;
        String m="";
        String esp;
        String nom;
        do{
            nom=JOptionPane.showInputDialog("Ingrese nombre de la mascota");
        }while(nom.isBlank());
        
        do{
            esp=JOptionPane.showInputDialog("Ingrese la especie de la mascota");
        }while(!esp.equalsIgnoreCase("perro") &&
                !esp.equalsIgnoreCase("gato") &&
                !esp.equalsIgnoreCase("conejo"));
       
        for (int i = 0; i < n; i++) {
            if(vm[i].getCod()!=-1){
                if(vm[i].getNom().equalsIgnoreCase(nom) && vm[i].getEsp().equalsIgnoreCase(esp)){
                    m+=vm[i].mostrar();
                }
            }
        }
        
        if(m.equalsIgnoreCase("")){
            return b;
        }else m=JOptionPane.showInputDialog(m+"\n\nIngrese el codigo que desea");
        
        for (int i = 0; i < n; i++) {
            if(vm[i].getCod()!=-1){
                if(vm[i].getNom().equalsIgnoreCase(nom) && vm[i].getEsp().equalsIgnoreCase(esp) && Integer.parseInt(m)==vm[i].getCod()){
                    b=i;
                }
            }
        }
        return b;
    }
    
    
}
