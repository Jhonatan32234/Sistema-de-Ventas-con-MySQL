/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multidisciplinario.p;
import conexiondb.ConexionMySQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;


/**
 *
 * @author jhona
 */
public class MySQL {
    
  static  String  bd="bdinventario";
   static String url="jdbc:mysql://localhost:3307/bdinventario";
  static  String user="root";
  static  String password="";
  static  String driver="com.mysql.cj.jdbc.Driver";
  static  Connection cx=null;
    
    
    
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cx=DriverManager.getConnection(url,user,password);
            System.out.println("SE CONECTO A BD "+bd);
            return cx;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("NO SE CONECTO A BD "+bd);
            System.out.println("Revise la conexion a la base de datos cx es null");

            //Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
    
    public static ObservableList<Productos> getProductos(){
       
        Connection cx = ConnectDb();
        ObservableList <Productos> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cx.prepareStatement("SELECT * FROM Productos;");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Productos(Integer.parseInt(rs.getString("id")), rs.getString("nombre"), rs.getString("marca"), rs.getString("descripcion"), rs.getString("tipo"),Integer.parseInt(rs.getString("precio")),Integer.parseInt(rs.getString("cantidad"))));               
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return list;       
}    
    
    public static ObservableList<Servicio> getServicios(){
       
        Connection cx = ConnectDb();
        ObservableList <Servicio> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cx.prepareStatement("SELECT * FROM Servicios;");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Servicio(Integer.parseInt(rs.getString("id")), rs.getString("nombre"), rs.getString("tipo"), Integer.parseInt(rs.getString("precio"))));               
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return list;
        
}    
    public static ObservableList<Earnings> getEarnings(){
       
        Connection cx = ConnectDb();
        ObservableList <Earnings> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = cx.prepareStatement("SELECT * FROM ventas;");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                list.add(new Earnings(Integer.parseInt(rs.getString("id")), rs.getString("nombre"), Integer.parseInt(rs.getString("cantidad")),rs.getString("tipo"), Integer.parseInt(rs.getString("total"))));               
            }
        } catch (NumberFormatException | SQLException e) {
            System.out.println(e);
        }
        return list;   
}      
}
