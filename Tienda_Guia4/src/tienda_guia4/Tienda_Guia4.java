package tienda_guia4;

import javax.swing.JOptionPane;


public class Tienda_Guia4 {

    
    public static void main(String[] args) {
        Catalogo cat= new Catalogo();
        int op=0;
        String a="";
        do{
        op=Integer.parseInt(JOptionPane.showInputDialog("""
                                                        1-Listar ropa
                                                        2-Listar electronico
                                                        3-Listar alimento
                                                        4-Electronico x origen
                                                        5-Mod ropa
                                                        6-Mod electronico
                                                        7-Mod Alimento
                                                        8-Salir"""));
            switch (op) {
                case 1:
                    a=cat.list(1);
                    JOptionPane.showMessageDialog(null, a);
                break;
                case 2:
                    a=cat.list(2);
                    JOptionPane.showMessageDialog(null, a);
                break;
                case 3:
                    a=cat.list(3);
                    JOptionPane.showMessageDialog(null, a);
                break;
                case 4:
                    a=JOptionPane.showInputDialog("Ingrese origen");
                    a=cat.ListByOri(a);
                    JOptionPane.showMessageDialog(null, a);
                break;
                case 5:
                    op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la ropa"));
                    op=cat.bus(1, op);
                    if(op!=-1){
                        Ropa aux=new Ropa();
                        aux.regis( cat.getV(op).getId()-1 );
                        cat.setV(aux, op);
                    }else JOptionPane.showMessageDialog(null, "Error");
                break;
                case 6:
                    op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la ropa"));
                    op=cat.bus(2, op);
                    if(op!=-1){
                        Electronico aux=new Electronico();
                        aux.regis( cat.getV(op).getId()-1 );
                        cat.setV(aux, op);
                    }else JOptionPane.showMessageDialog(null, "Error");
                break;
                case 7:
                    op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id de la ropa"));
                    op=cat.bus(3, op);
                    if(op!=-1){
                        Alimento aux=new Alimento();
                        aux.regis( cat.getV(op).getId()-1 );
                        cat.setV(aux, op);
                    }else JOptionPane.showMessageDialog(null, "Error");
                break;
                
            }
        }while(op!=8);
    }
    
}
