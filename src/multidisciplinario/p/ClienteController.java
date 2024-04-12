/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package multidisciplinario.p;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jhona
 */
public class ClienteController implements Initializable {
    @FXML
    private Button btnCobrar;

    @FXML
    private TextField cambio;

    @FXML
    private TextField pago;
    @FXML
    private TextField total;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        // TODO
    }   
       
    public void mostrarTotal(String total){
        this.total.setText(total);
    }
       
    @FXML
    void calcularCambio(ActionEvent event) {
        int total = Integer.parseInt(this.total.getText());
        int pago = Integer.parseInt(this.pago.getText());
        if(pago>=total){
            int cambioPago = pago - total;
            this.cambio.setText(Integer.toString(cambioPago));
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Cantidad menor al total");
            alert.showAndWait();
        }
    }
  
}
