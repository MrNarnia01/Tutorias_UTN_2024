package clase_31_08_clientes;

import javax.swing.JOptionPane;


public class Clase_31_08_Clientes {

    public static void main(String[] args) {
        int n=0;
        int op=0;
        int b=0;
        String l="";
        String lb="";
        n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de clientes que desea: "));
        Cliente cli[] = new Cliente[n];
        
        //Inicializacion
        for (int i = 0; i < n; i++) {
            cli[i]=new Cliente();
        }
        //Registrar
        for (int i = 0; i < n; i++) {
            cli[i].registrar(i);
            JOptionPane.showMessageDialog(null, cli[i].mostrar());
        }
        
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog("""
                                                            1-Listar todos
                                                            2-Buscar por nombre
                                                            3-Ordenar por nombre
                                                            4-Elminar
                                                            5-Modificar
                                                            6-Salir
                                                            """));
            switch (op) {
                case 1:
                    l="";
                    for (int i = 0; i < n; i++) {
                        if(cli[i].getId()!=-1){
                            l+="\n"+cli[i].mostrar();
                        }
                    }
                    JOptionPane.showMessageDialog(null, l);
                break;
                case 2:
                    l="";
                    lb=JOptionPane.showInputDialog("Ingrese el nombre a buscar");
                    for (int i = 0; i < n; i++) {
                        if(cli[i].getId()!=-1){
                            if(lb.equalsIgnoreCase(cli[i].getNom())){
                                l+="\n"+cli[i].mostrar();
                            }
                        }
                    }
                    
                    if(!l.equals("")){
                        JOptionPane.showMessageDialog(null, l);
                    }else JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                    
                break;
                case 3:
                    Cliente aux= new Cliente();
                    for (int i = 0; i < n-1; i++) {
                        for (int j = i+1; j < n; j++) {
                            
                            if(cli[i].getId()!=-1 && cli[j].getId()!=-1){
                                
                                if(cli[i].getNom().compareToIgnoreCase(cli[j].getNom())>0){
                                    //cli[i].getNom() > cli[j].getNom()
                                    
                                    aux=cli[i];
                                    cli[i]=cli[j];
                                    cli[j]=aux;
                                }
                                
                            }
                            
                        }
                    }
                    
                    l="";
                    for (int i = 0; i < n; i++) {
                        if(cli[i].getId()!=-1){
                            l+="\n"+cli[i].mostrar();
                        }
                    }
                    JOptionPane.showMessageDialog(null, l);
                break;
                case 4:
                    b=-1;
                    op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a eliminar"));
                    for (int i = 0; i < n; i++) {
                        if(cli[i].getId()!=-1){
                            if(op==cli[i].getId()){
                                b=i;
                            }
                        }
                    }
                    if(b!=-1){
                        cli[b].elm();
                    }else   JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                break;
                case 5:
                    b=-1;
                    op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id a modificar"));
                    for (int i = 0; i < n; i++) {
                        if(cli[i].getId()!=-1){
                            if(op==cli[i].getId()){
                                b=i;
                            }
                        }
                    }
                    if(b!=-1){
                        cli[b].registrar( cli[b].getId()-1 );
                    }else   JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                break;
                case 6:
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
              
        }while(op!=6);
        
    }
    
    
}
