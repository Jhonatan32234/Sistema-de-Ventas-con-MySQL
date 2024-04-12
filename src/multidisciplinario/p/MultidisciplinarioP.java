/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package multidisciplinario.p;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author jhona
 */
public class MultidisciplinarioP extends Application{
    String bd="bdinventario";
    String url="jdbc:mysql://localhost:3307/test";
    String user="root";
    String password="";
    String driver="com.mysql.cj.jdbc.Driver";
    Connection cx;
    
    public MultidisciplinarioP(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        launch(args);  
    }
    
    public MultidisciplinarioP conect(){
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            cx=DriverManager.getConnection(url,user,password);
            System.out.println("SE CONECTO A BD "+bd);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("NO SE CONECTO A BD "+bd);
            Logger.getLogger(MultidisciplinarioP.class.getName()).log(Level.SEVERE, null, e);
        }
        return (MultidisciplinarioP) cx;
    }
   
    @Override
    public void start(Stage stage) {
        
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MultidisciplinarioP.class.getResource("/View/Login.fxml"));
            Pane ventana = (Pane) loader.load();
            
            Scene scene = new Scene(ventana);
            stage.setScene(scene);
            stage.show();
            
            
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    
}
