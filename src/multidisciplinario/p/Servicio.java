/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multidisciplinario.p;

/**
 *
 * @author jhona
 */
public  class Servicio  extends Propiedades{
   public Servicio(int idServicio, String nombreServicio, String tipoServicio,int precioServicio) {
        super(idServicio,nombreServicio,tipoServicio,precioServicio);
    }
    int importe;

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    @Override
    public int obtenerPrecio(int cantidad) {
        int resultado =(super.getPrecio()*cantidad)+getImporte();
    return resultado;
    }
    
}
