package clase_28_09;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Clase_28_09 {
    //Creamos los vectores globales
    static Miembro[] vm;
    static Proyecto[] v;
    
    public static void main(String[] args) throws ParseException {
        //Variables
        int n,h;
        String l="";
        //Creacion de los miembros
        n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de miembros que tiene en total"));
        vm= new Miembro[n];
        for (int i = 0; i < n; i++) {
            vm[i]= new Miembro();
            vm[i].Registrar(i);
            //El rol se registrara independientemente del proyecto
            JOptionPane.showMessageDialog(null, vm[i].toString());
        }
        //Creacionde los proyectos
        n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de proyectos"));
        v=new Proyecto[n];
        for (int i = 0; i < v.length; i++) {
            //Creo las bases del proyecto
            v[i]= new Proyecto();
            v[i].Registrar();
            //Creo cada miembro
            n=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de miembros en este proyecto(max : 10)"));
            for (int j = 0; j < n; j++) {
                do{
                    //Con el bus() busco un miembro por su id;
                    h=bus();
                    if(h!=-1){
                        //Le asigno un rol
                        do{
                            l=JOptionPane.showInputDialog("Ingrese el rol del miembro");
                        }while(!l.equalsIgnoreCase("lider") &&
                            !l.equalsIgnoreCase("analista") &&
                            !l.equalsIgnoreCase("desarrollador") && 
                            !l.equalsIgnoreCase("tester"));
                        //Lo guardo asi porque daba errores rancios y con esta manera ya no
                        v[i].setMie(new Miembro(vm[h].getId(), vm[h].getNom(), l, vm[h].getfIn(),null));
                    }else   JOptionPane.showMessageDialog(null, "Error");
                }while(h==-1);
                
            }
            //Muestreo para ver que los datos estan correctos
            JOptionPane.showMessageDialog(null, v[i].toString());
        }
        
        do{
            n=Integer.parseInt(JOptionPane.showInputDialog("""
                                                       -2-Listar miembros por rol elegido
                                                       -7-Miembros de este año
                                                       -8-Miembro y fecha de baja
                                                       -9-Miembro y modificarlo
                                                       -10-Desarrolladores en proyectos a 6 meses
                                                       -11-Agregar miembros a un proyecto
                                                       -12-Salir"""));
            
            switch (n) {
                case 2:
                    //Pido el rol
                    do{
                        l=JOptionPane.showInputDialog("Ingrese el rol a buscar");
                    }while(!l.equalsIgnoreCase("lider") &&
                            !l.equalsIgnoreCase("analista") &&
                            !l.equalsIgnoreCase("desarrollador") && 
                            !l.equalsIgnoreCase("tester"));
                    
                    l=mieXrol(l);
                    //Validacion para saber si esta vacio o no, si esta vacio es que no encontro nada
                    if(l.equals("")){
                        JOptionPane.showMessageDialog(null, "Error");
                    }else   JOptionPane.showMessageDialog(null, l);
                break;
                case 7:
                    l="";
                    Date hoy = new Date();
                    //Solo comparo sus años de incorporacion con el año actual
                    for (int i = 0; i < vm.length; i++) {
                        if(vm[i].getfIn().getYear()==hoy.getYear()){
                            l+="\nId: "+vm[i].getId()+" Nombre: "+vm[i].getNom();
                        }
                    }
                    if(l.equals("")){
                        JOptionPane.showMessageDialog(null, "Error");
                    }else   JOptionPane.showMessageDialog(null, l);
                break;
                case 8:
                    //Busco el miembro
                    n=bus();
                    //Reviso que no de error
                    if(n!=-1){
                        //Pido la fecha y actualizo el original
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        l=JOptionPane.showInputDialog("Ingrese la fecha de baja");
                        vm[n].setfBa(format.parse(l));
                        
                        //Reviso uno por uno en todos los proyectos para actualizarlos todos los que coincidan
                        for (int i = 0; i < v.length; i++) {
                            for (int j = 0; j < v[i].getLargeMie(); j++) {
                                if(v[i].getMie(j).getId()==vm[n].getId()){
                                    v[i].getMie(j).setfBa(format.parse(l));
                                }
                            }

                        }
                        
                    }else   JOptionPane.showMessageDialog(null, "Error");
                break;
                case 9:
                    //Busco el miembro y lo actualizo
                    n=bus();
                    if(n!=-1){
                        vm[n].Registrar(vm[n].getId()-1);
                        //Al igual que en el case 8, paso uno por uno actualizando todos los datos
                        for (int i = 0; i < v.length; i++) {
                            for (int j = 0; j < v[i].getLargeMie(); j++) {
                                if(v[i].getMie(j).getId()==vm[n].getId()){
                                    v[i].getMie(j).setNom(vm[n].getNom());
                                    v[i].getMie(j).setfIn(vm[n].getfIn());
                                }
                            }

                        }
                        
                    }else   JOptionPane.showMessageDialog(null, "Error");
                break;
                case 10:
                    l="";
                    for (int i = 0; i < v.length; i++) {
                        //Conculto por la duracion
                        if(v[i].getDura()==180){
                            for (int j = 0; j < v[i].getLargeMie(); j++) {
                                //Con el contains reviso que en ese String no este ya guardado el id, este es para que no se repita
                                if(!l.contains("id="+v[i].getMie(j).getId()) && v[i].getMie(j).getRol().equalsIgnoreCase("desarrollador")){
                                    //Si no lo encuentra siginifica que aun esta en el listado por eso lo añado
                                    l+=v[i].getMie(j).toString();
                                }
                            }
                        }
                    }
                    //Reviso que no este vacio
                    if(l.equals("")){
                        JOptionPane.showMessageDialog(null, "Error");
                    }else   JOptionPane.showMessageDialog(null, l);
                break;
                case 11:
                    //Busco el proyecto
                    n=busP();
                    if(n!=-1){
                        JOptionPane.showMessageDialog(null, v[n].toString());
                        do{
                            h=bus();
                            if(h!=-1){
                                //Pido el rol
                                do{
                                    l=JOptionPane.showInputDialog("Ingrese el rol del miembro");
                                }while(!l.equalsIgnoreCase("lider") &&
                                    !l.equalsIgnoreCase("analista") &&
                                    !l.equalsIgnoreCase("desarrollador") && 
                                    !l.equalsIgnoreCase("tester"));
                                //Uso el set personalizado para guardar un nuevo miembro
                                v[n].setMie(new Miembro(vm[h].getId(), vm[h].getNom(), l, vm[h].getfIn(),null));
                            }else   JOptionPane.showMessageDialog(null, "Error");
                        }while(h==-1);
                    }else   JOptionPane.showMessageDialog(null, "Error");
                break;
                default:
                    
            }
        }while(n!=12);
        
    }
    
    //Busqueda por id del miembro
    public static int bus(){
        int id=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del miembro a buscar"));
        int b=-1;
        for (int i = 0; i < vm.length; i++) {
            if(vm[i].getfBa()==null && vm[i].getId()==id){
                b=i;
            }
        }
        return b;
        
    }
    
    //Busco todos los miembros por rol
    public static String mieXrol(String r){
        String a="";
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].getLargeMie(); j++) {
                if(v[i].getMie(j).getfBa()==null && v[i].getMie(j).getRol().equalsIgnoreCase(r)){
                    //El contains es para saber si ya esta guardado en el String
                    if(!a.contains("id="+v[i].getMie(j).getId())){
                        //Si no lo esta lo guardo
                        a+=v[i].getMie(j).toString();
                    }
                }
            }
            
        }
        return a;
    }
    
    //Busqueda por nombre de proyecto
    public static int busP(){
        String id=JOptionPane.showInputDialog("Ingrese el nombre del proyecto a buscar");
        int b=-1;
        for (int i = 0; i < v.length; i++) {
            if(v[i].getNom().equalsIgnoreCase(id)){
                b=i;
            }
        }
        return b;
    }
    
}
