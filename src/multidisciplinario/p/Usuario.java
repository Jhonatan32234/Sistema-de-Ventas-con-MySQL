/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multidisciplinario.p;

/**
 *
 * @author jhona
 */
public class Usuario {
    
    String nombreUsuario,contraseña,correo,tipo;

    public Usuario(String nombreUsuario, String contraseña, String correo, String tipo) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.correo = correo;
        this.tipo = tipo;
    }
    public boolean validarDatos(){
        return nombreUsuario!=null && !nombreUsuario.isEmpty() &&contraseña!=null && !contraseña.isEmpty() &&correo!=null && !correo.isEmpty() &&tipo!=null && !tipo.isEmpty();
    }
    
    
}
