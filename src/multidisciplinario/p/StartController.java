/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package multidisciplinario.p;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jhona
 */
public class StartController implements Initializable { 
    @FXML
    private Button btnEarnings;

    @FXML
    private Button btnInventory;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnSelect;
    @FXML
    private Button nan;
    
    /**
     * Initializes the controller class.
     */
    @FXML
    private void switchToInventory(ActionEvent event){
        try{
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Inventory.fxml"));
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
            
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> closeWindow());

        
        Stage myStage = (Stage) this.btnSearch.getScene().getWindow();
        myStage.close();
        InventoryController c = loader.getController();
        c.setStart(this); 
        
        }catch(IOException e){
            System.out.println("Revise la conexion hacia la base de datos para poder cargar la vista de Inventory.fxml");
        }
    }
    
    @FXML
    private void switchToSearch(ActionEvent event){
        try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Search.fxml"));
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
            
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> closeWindow());

        Stage myStage = (Stage) this.btnSearch.getScene().getWindow();
        myStage.close();
        
        SearchController c = loader.getController();
        c.setSearch(this); 
        
        }catch(IOException e){
            Logger.getLogger(StartController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Revise la conexion hacia la base de datos para poder cargar la vista de Search.fxml");
        
        }
}
    
    @FXML
    private void switchToEarnings(ActionEvent event){
        try{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Earnings.fxml"));
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
            
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> closeWindow());

        Stage myStage = (Stage) this.btnSearch.getScene().getWindow();
        myStage.close();
        
        }catch(IOException e){
            Logger.getLogger(EarningsController.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Revise la conexion hacia la base de datos para poder cargar la vista de Earnings.fxml");
        
        }
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
 
    public void closeWindow(){
        try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Start.fxml"));
           Parent root = loader.load();
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           
           stage.setScene(scene);
           stage.show();
           
       } catch (IOException ex) {
           Logger.getLogger(StartController.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    }
