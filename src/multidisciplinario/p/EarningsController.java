/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package multidisciplinario.p;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jhona
 */
public class EarningsController implements Initializable {
    @FXML
    private TableView<Earnings> tableEarnings;
    @FXML
    private TableColumn cantidad;

    @FXML
    private TableColumn id;

    @FXML
    private TableColumn nombre;

    @FXML
    private TableColumn tipo;

    @FXML
    private TableColumn total;
    @FXML
    private TextField ganancias;
    StartController start;
    
    ObservableList<Earnings> ventas;
    
    public StartController getSearch() {
        return start;
    }

    public void setSearch(StartController search) {
        this.start = search;
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.id.setCellValueFactory(new PropertyValueFactory("id"));
        this.nombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.cantidad.setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.tipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        this.total.setCellValueFactory(new PropertyValueFactory("total"));
        this.ventas = MySQL.getEarnings();
        tableEarnings.setItems(ventas);
        
        int totalCliente = 0;
        for(Earnings articulo : tableEarnings.getItems()){
            totalCliente += articulo.getTotal(); 
        }
        ganancias.setText(Integer.toString(totalCliente));
       
        // TODO
    }    
}
