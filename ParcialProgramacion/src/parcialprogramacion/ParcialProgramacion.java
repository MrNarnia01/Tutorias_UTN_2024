package parcialprogramacion;

import java.text.ParseException;
import javax.swing.JOptionPane;


public class ParcialProgramacion {

    
    public static void main(String[] args) throws ParseException {
        
        Listado listado = new Listado();
        
        int op=0;
        
        
        
        do {      
            op=Integer.parseInt(JOptionPane.showInputDialog("""
                                       1-Listado por modalidad
                                       2-Buscar y modificar
                                       3-Salir
                                       """));
            switch (op) {
                case 1:
                    String a="Listado de Presenciales";
                    for (int i = 0; i < listado.largev(); i++) {
                        if(listado.getV(i) instanceof Pre){
                            a+="\n"+((Pre)listado.getV(i)).mos();
                        }
                    }
                    JOptionPane.showMessageDialog(null,a );
                    
                    
                    a="Listado de Virtuales";
                    for (int i = 0; i < listado.largev(); i++) {
                        if(listado.getV(i) instanceof Onl){
                            a+="\n"+((Onl)listado.getV(i)).mos();
                        }
                    }
                    JOptionPane.showMessageDialog(null,a );
                    
                break;
                case 2:
                    op=listado.bus();
                    if(op!=-1){
                        if(listado.getV(op) instanceof Pre)   ((Pre) listado.getV(op) ).regis( listado.getV(op).getId()-1 );
                        else ((Onl) listado.getV(op) ).regis( listado.getV(op).getId()-1 );
                    }else JOptionPane.showMessageDialog(null, "Error");
                break;
                case 3:
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Error");
            }
        } while (op!=3);
        
        
        
        
        
    }
    
}
