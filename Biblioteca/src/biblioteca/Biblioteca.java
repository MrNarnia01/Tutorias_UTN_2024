package biblioteca;

import java.text.ParseException;
import java.util.Date;
import javax.swing.JOptionPane;

public class Biblioteca {
    //Creamos la instancia de prestamo
    public static Prestamo p[];
    
    public static void main(String[] args) throws ParseException {
        //Variables
        String v = "";
        int op=0;
        
        //Creacion del vector
        do {            
            do {                
                v=JOptionPane.showInputDialog("Ingrese la cantidad de prestamos a registrar");
            } while (v.isBlank());
            op=Integer.parseInt(v);
        } while (op<1);
        
        p = new Prestamo[op];
        
        for (int i = 0; i < op; i++) {
            p[i]= new Prestamo();
            p[i].regisP(i);
            JOptionPane.showMessageDialog(null, p[i].mos());
        }
        
        //Menu de opciones
        do {            
            v=JOptionPane.showInputDialog("""
                                          1-Registrar devolucion
                                          2-Registrar nuevo prestamo
                                          3-Libros prestados por novela
                                          4-Libros prestados por poesia
                                          5-Libros prestados por cuento
                                          6-Socio mas joven
                                          7-Socio mas viejo
                                          8-Cuantos libros a mayores y cuantos a menores
                                          9-Prestamos por mes en el año actual
                                          10-Nuevo libro a un prestamo
                                          11-Modificar prestamo
                                          12-Eliminar prestamo
                                          13-Salir
                                          """);
            op=Integer.parseInt(v);
            switch (op) {
                case 1:
                    op=busByNombre();
                    if(op!=-1){
                        //Revision de que este prestamo no haya sido ya devuelto
                        if(p[op].getLib(0).getEst().equalsIgnoreCase("prestado")){
                            for(int i=0; i<p[op].getLibLarge() ;i++){
                                p[op].getLib(i).devolver();
                            }
                        }else JOptionPane.showMessageDialog(null, "Prestamo ya devuelto");
                    }else JOptionPane.showMessageDialog(null, "Prestamo no encontrado");
                break;
                case 2:
                    op=p.length;
                    Prestamo aux[]= new Prestamo[op+1];
                    for (int i = 0; i < op; i++) {
                        aux[i]=p[i];
                    }
                    //op es lo mismo que la ultima posicion de aux
                    //le mandamos el ultimo id (op-1) y dentro del regisP le suma uno para el nuevo prestamo
                    aux[op]=new Prestamo();
                    aux[op].regisP(p[op-1].getId());
                    //Guardo el nuevo vector actualizado
                    p=aux;
                break;
                case 3:
                    op=cantBy("novela");
                    JOptionPane.showMessageDialog(null, "Cantidad de libros prestados de novela: "+op);
                break;
                case 4:
                    op=cantBy("poesia");
                    JOptionPane.showMessageDialog(null, "Cantidad de libros prestados de poesia: "+op);
                break;
                case 5:
                    op=cantBy("cuento");
                    JOptionPane.showMessageDialog(null, "Cantidad de libros prestados de cuento: "+op);
                break;
                case 6:
                    //Asumimos que en la primera vuelta el primer socio es el de menor edad por eso usamos int i = 1
                    op=0;
                    for (int i = 1; i < p.length; i++) {
                        if(p[i].getSoc().edad()<p[op].getSoc().edad()){
                            op=i;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Socio de menor edad\n"+p[op].getSoc().mos());
                break;
                case 7:
                    //Asumimos que en la primera vuelta el primer socio es el de mayor edad por eso usamos int i = 1
                    op=0;
                    for (int i = 1; i < p.length; i++) {
                        if(p[i].getSoc().edad()>p[op].getSoc().edad()){
                            op=i;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Socio de mayor edad\n"+p[op].getSoc().mos());
                break;
                case 8:
                    op=0;//Variable para menores
                    int c=0;//Variable para mayores
                    for (int i = 0; i < p.length; i++) {
                        if(p[i].getSoc().edad()<18) c++;
                        else op++;
                    }
                    JOptionPane.showMessageDialog(null, "Socios menores de edad: "+op+"\nSocios mayores de edad: "+c);
                break;
                case 9:
                    v="";
                    Date hoy = new Date();
                    int[] pres = new int [12]; 
                    for (int i = 0; i < 12; i++)    pres[i]=0;
                    
                    for (int i = 0; i < p.length; i++) {
                        //Revisamos que sea el año actual
                        if(hoy.getYear()==p[i].getfPres().getYear()){
                            //La funcion getMonth() devuelve valores entre 0 y 11 asi que se puede usar directamente como posicionador para el vector
                            pres[p[i].getfPres().getMonth()]++;
                        }
                    }
                    
                    v+="\nEnero: "+pres[0];
                    v+="\nFebrero: "+pres[1];
                    v+="\nMarzo: "+pres[2];
                    v+="\nAbril: "+pres[3];
                    v+="\nMayo: "+pres[4];
                    v+="\nJunio: "+pres[5];
                    v+="\nJulio: "+pres[6];
                    v+="\nAgosto: "+pres[7];
                    v+="\nSeptiembre: "+pres[8];
                    v+="\nOctubre: "+pres[9];
                    v+="\nNoviembre: "+pres[10];
                    v+="\nDiciembre: "+pres[11];
                    JOptionPane.showMessageDialog(null, v);
                break;
                case 10:
                    op=busById();
                    if(op!=-1){
                        if(p[op].getLibLarge()<5 && p[op].getLib(0).getEst().equalsIgnoreCase("prestado")){
                            p[op].setLib();
                            JOptionPane.showMessageDialog(null, p[op].mos());
                        }else JOptionPane.showMessageDialog(null, "Cantidad de libros maximos por prestamo alcanzado o prestamo ya devuelto");
                    }else JOptionPane.showMessageDialog(null, "Prestamo no encontrado");
                break;
                case 11:
                    op=busById();
                    if(op!=-1){
                        //El -1 se hace ya que en el regis se le suma uno aca se lo restamos para que mantenga el mismo id
                        p[op].regisP(p[op].getId()-1);
                    }else JOptionPane.showMessageDialog(null, "Prestamo no encontrado");
                break;
                case 12:
                    op=busById();
                    if(op!=-1){
                        elm(op);
                    }else JOptionPane.showMessageDialog(null, "Prestamo no encontrado");
                break;
                case 13:
                break;
                default:
                    JOptionPane.showMessageDialog(null, "Error");
            }
            
        } while (op!=13);
        
        
    }
    
    //Busqueda por id
    public static int busById(){
        int b=-1;
        int op=0;
        
        //No voy a validar este pedido de datos :)
        op=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del prestamo que quiere"));
        
        for (int i = 0; i < p.length; i++) {
            if(p[i].getId()==op)    b=i;
        }
        
        return b;
    }
    
    //Busqueda por nombre
    //Por tiempo y facilidades voy a hacer esta busqueda suponierndo que no se repiten los nombres
    //En caso de querer hacer una busqueda habiendo posibles varios resultados, en el ejercicio de la carpeta "Clase_07_09" se encuentra un ejemplo
    public static int busByNombre(){
        int b=-1;
        
        //No voy a validar este pedido de datos :)
        String op=JOptionPane.showInputDialog("Ingrese el nombre del socio que quiere");
        
        for (int i = 0; i < p.length; i++) {
            if(p[i].getSoc().getNom().equalsIgnoreCase(op)){
                b=i;
            }
        }
        
        return b;
    }
    
    //Lo hice en funcion para reutilizar el metodo
    public static int cantBy(String gen){
        int c=0;
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i].getLibLarge(); j++) {
                //Aca revisamos que sea prestado y que el genero sea igual a lo solicitado
                if(p[i].getLib(j).getEst().equals("prestado") && p[i].getLib(j).getGen().equalsIgnoreCase(gen)){
                    c++;
                }
            }
        }
        return c;
    }
    
    public static void elm(int po){
        int n = p.length;
        //Creamos el auxiliar de una posicion mas chica que el original
        Prestamo aux[]= new Prestamo[n-1];
        //Copiamos la primera parte
        for (int i = 0; i < po; i++) {
            aux[i]=p[i];
        }
        //Copiamos la segunda parte
        //n-1 es por que aux tiene una posicion menos que el original
        for (int i = po; i < n-1; i++) {
            //p[i+1] es por que esa posicion la salteamos en el vector p entonces se tiene que usar la posicion siguiente
            aux[i]=p[i+1];
        }
        //Guardamos los cambios
        p=aux;
    }
}
