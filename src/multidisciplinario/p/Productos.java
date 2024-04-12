/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multidisciplinario.p;

/**
 *
 * @author jhona
 */
public class Productos extends Propiedades{
    private int cantidad;

    private String marca,descripcion;
    public Productos(int id, String nombre, String mark, String description, String type,int price,int cantidad) {
        super(id,nombre,type,price);
        this.marca = mark;
        this.descripcion = description;
        this.cantidad=cantidad;
        
    }
   public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    


    public String getMarca() {
        return marca;
    }

    public void setMarca(String mark) {
        this.marca = mark;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String description) {
        this.descripcion = description;
    }
    @Override
   public int obtenerPrecio(int cantidad){
       
   return (super.getPrecio()*cantidad);
   }
    
}
