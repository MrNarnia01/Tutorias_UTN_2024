package tienda_guia4;

import javax.swing.JOptionPane;


abstract public class Producto {
    private int id;
    private String nombre;
    private String marca;
    private float precio_base;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getPrecio_base() {
        return precio_base;
    }

    public void setPrecio_base(float precio_base) {
        this.precio_base = precio_base;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Producto(int id, String nombre, String marca, float precio_base) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.precio_base = precio_base;
    }
    
    public Producto() {
        this.id = 0;
        this.nombre = "";
        this.marca = "";
        this.precio_base = 0;
    }
    
    public void regis(int i){
        this.id=i;
        this.nombre=JOptionPane.showInputDialog("Inmgrese el nombre");
        this.marca=JOptionPane.showInputDialog("Inmgrese el marca");
        this.precio_base=Float.parseFloat( JOptionPane.showInputDialog("Inmgrese el precio base"));
    }

    public String mos(){
        String a="";
        a+="\nId: "+this.id;
        a+="    Nombre: "+this.nombre;
        a+="    Marca: "+this.marca;
        a+="    P.Base : "+this.precio_base;
        
        return a;
    }
    
    abstract float precio_final();
    
}
