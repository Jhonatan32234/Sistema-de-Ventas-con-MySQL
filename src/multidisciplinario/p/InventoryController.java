/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package multidisciplinario.p;

import conexiondb.ConexionMySQL;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Optional;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author jhona
 */
public class InventoryController implements Initializable {
    
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    StartController start;
    public StartController getStart() {
        return start;
    }

    public void setStart(StartController start) {
        this.start = start;
    }
    
 
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$VENTANAS$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ 
@FXML
    private Button btnVProducts;

    @FXML
    private Button btnVServices;
    @FXML
    private AnchorPane viewProducts;

    @FXML
    private AnchorPane viewServices;
    
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    @FXML
    private Label label;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtMark;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtType;
    @FXML
    private TextField txtQuantity;
    
    @FXML
    private TextField txtDescription;
    @FXML
    private TableColumn colDescription;
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colMark;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colPrice;
    @FXML
    private TableColumn colQuantity;
    @FXML
    private TableColumn colType;
    @FXML
    private TableView<Productos> tableProducts;
    
    private ObservableList<Productos> productos;
    
    
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$PRODUCTOS$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
    
    @FXML
    private Button agregarBoton;
    @FXML
    private Button eliminarBoton;
    @FXML
    private TableColumn<?, ?> idCol;
    @FXML
    private TextField idTxt;
    @FXML
    private Button modificarBoton;
    @FXML
    private TableColumn<?, ?> nombreCol;
    @FXML
    private TextField nombreTxt;
    @FXML
    private TableColumn<?, ?> precioCol;
    @FXML
    private TextField precioTxt;
    @FXML
    private TableColumn<?, ?> tipoCol;
    @FXML
    private TextField tipoTxt;
    @FXML
    private TableView<Servicio> tableService;
    
    private ObservableList<Servicio> servicios;
    
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$SERVICIOS$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4
    
  
    Connection cx;
    PreparedStatement ps;
    int index = -1;
   


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        
 //$$$$$$$$$$$$$$$$$PRODUCTOS$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4

       this.colId.setCellValueFactory(new PropertyValueFactory("id"));
       this.colName.setCellValueFactory(new PropertyValueFactory("nombre"));
       this.colMark.setCellValueFactory(new PropertyValueFactory("marca"));
       this.colDescription.setCellValueFactory(new PropertyValueFactory("descripcion"));
       this.colType.setCellValueFactory(new PropertyValueFactory("tipo"));
       this.colPrice.setCellValueFactory(new PropertyValueFactory("precio"));
       this.colQuantity.setCellValueFactory(new PropertyValueFactory("cantidad"));
       
       this.productos = MySQL.getProductos();
       tableProducts.setItems(productos);
     //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4
      
       //$$$$$$$$$$$$$$$$SERVICIOS$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

       this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
       this.nombreCol.setCellValueFactory(new PropertyValueFactory("nombre"));
       this.tipoCol.setCellValueFactory(new PropertyValueFactory("tipo"));
       this.precioCol.setCellValueFactory(new PropertyValueFactory("precio"));
      
       this.servicios = MySQL.getServicios();
       tableService.setItems(servicios);
       
       
       
     
       //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

       
    }    
    
    
    @FXML
    private void addProducts(ActionEvent event){
        cx = MySQL.ConnectDb();
        String sql = "insert into Productos (id,nombre,marca,descripcion,tipo,precio,cantidad) VALUES(?,?,?,?,?,?,?)";
        
        
        
        try{
            int id = Integer.parseInt(this.txtId.getText());
            String name = this.txtName.getText();
            String mark = this.txtMark.getText();
            String  description = this.txtDescription.getText();
            String type = this.txtType.getText();
            int  price = Integer.parseInt(this.txtPrice.getText());
            int quantity = Integer.parseInt(this.txtQuantity.getText());
            
            if(id>0&&price>0&&quantity>0){
                ps = cx.prepareStatement(sql);
            ps.setString(1, txtId.getText());
            ps.setString(2, txtName.getText());
            ps.setString(3, txtMark.getText());
            ps.setString(4, txtDescription.getText());
            ps.setString(5, txtType.getText());
            ps.setString(6, txtPrice.getText());
            ps.setString(7, txtQuantity.getText());
            ps.execute();
            
            Productos u = new Productos(id,name,mark,description,type,price,quantity);
        if(!this.productos.contains(u)){
            this.productos.add(u);
            this.tableProducts.setItems(productos);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Alerta");
            alert.setContentText("Datos añadidos");
            alert.showAndWait();
        }else{        
        }
            }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos incorrectos, menor a 0 ");
            alert.showAndWait();
            }   
           
        }catch( NumberFormatException|SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos incorrectos");
            alert.showAndWait();
            System.out.println(e);
        }
    }
    
    @FXML
    private void addServices(ActionEvent event){
        cx = MySQL.ConnectDb();
        String sql = "insert into Servicios (id,nombre,tipo,precio) VALUES(?,?,?,?)";
        try{
            int id = Integer.parseInt(this.idTxt.getText());
            String name = this.nombreTxt.getText();
            String type = this.tipoTxt.getText();
            int price = Integer.parseInt(this.precioTxt.getText()); 
            if(id>0&&price>0){
            ps = cx.prepareStatement(sql);
            ps.setString(1, idTxt.getText());
            ps.setString(2, nombreTxt.getText());
            ps.setString(3, tipoTxt.getText());
            ps.setString(4, precioTxt.getText());
            ps.execute();
 
            Servicio u = new Servicio(id,name,type,price);
           
        if(!this.servicios.contains(u)){
            this.servicios.add(u);
            this.tableService.setItems(servicios);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Alerta");
            alert.setContentText("Datos añadidos");
            alert.showAndWait();
        }else{   
        }
            }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos incorrectos, menor a 0 ");
            alert.showAndWait();               
            }      
        }catch(NumberFormatException|InputMismatchException | SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos incorrectos");
            alert.showAndWait();
            //System.out.println(e);
        }
    }
     
     
     

    //mostrar datos seleccionados
    @FXML 
    void getProducts(MouseEvent event){
        this.index = tableProducts.getSelectionModel().getSelectedIndex();
        if(index<= -1){
            return;
        }
        txtId.setText(this.colId.getCellData(index).toString());
        txtName.setText(this.colName.getCellData(index).toString());
        txtMark.setText(this.colMark.getCellData(index).toString());
        txtDescription.setText(this.colDescription.getCellData(index).toString());
        txtType.setText(this.colType.getCellData(index).toString());
        txtPrice.setText(this.colPrice.getCellData(index).toString());
        txtQuantity.setText(this.colQuantity.getCellData(index).toString());
        txtId.setEditable(false);
                
}
    
    @FXML 
    void getServices(MouseEvent event){
    this.index= tableService.getSelectionModel().getSelectedIndex();
    if(index <=-1){
        return;
    }
    idTxt.setText(this.idCol.getCellData(index).toString());
    nombreTxt.setText(this.nombreCol.getCellData(index).toString());
    tipoTxt.setText(this.tipoCol.getCellData(index).toString());
    precioTxt.setText(this.precioCol.getCellData(index).toString());
    idTxt.setEditable(false);
            
            
            }
    
    @FXML
   private void modifyProducts(ActionEvent event) {
        cx = MySQL.ConnectDb();
        try{
            String idAux = this.txtId.getText();
        if(idAux.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Fila no seleccionada");
            alert.showAndWait();
        }else{
            int id = Integer.parseInt(this.txtId.getText());
            String name = this.txtName.getText();
            String mark = this.txtMark.getText();
            String description = this.txtDescription.getText();
            String type = this.txtType.getText();
            int price = Integer.parseInt(this.txtPrice.getText());
            int quantity = Integer.parseInt(this.txtQuantity.getText());
            if(price>0&&quantity>0){
                
            String sql = "UPDATE Productos SET id = '"+id+"', nombre= '"+name+"', marca= '"+mark+"', descripcion= '"+description+"', tipo= '"+type+"', precio= '"+price+"', cantidad= '"+quantity+"' WHERE id ="+id; 
            ps= cx.prepareStatement(sql);
            ps.execute();
            System.out.println("Actualizado");
      
        Productos u = this.tableProducts.getSelectionModel().getSelectedItem();
         if(u == null){
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Datos incorrectoafas");
            alerta.showAndWait();
         }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Alerta");
            alert.setContentText("Datos modificados");
            alert.showAndWait();
            actualizarProductos();
                
         }    
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos incorrectos, menor a 0 ");
            alert.showAndWait();   
                
            }     
        }
        }catch(NumberFormatException|InputMismatchException| SQLException e){      
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Datos incorrectos");
            alerta.showAndWait();
            System.out.println(e);
            
        }
        /*En el caso de JavaFX, muchas veces se trabaja con componentes gráficos que 
        permiten al usuario ingresar información, como TextBox para ingresar números.
        Cuando se intenta convertir el contenido de estos componentes en un tipo numérico, 
        es posible que se lance la excepción NumberFormatException si el usuario ingresa un
        valor que no puede ser convertido a número.
        Por lo tanto, es común que en aplicaciones JavaFX se maneje la excepción NumberFormatException
        al trabajar con la conversión de String a números, en lugar de InputMismatchException,
        que se utiliza más comúnmente en la lectura de datos desde la consola.
        */
    }
   public void actualizarProductos(){
       this.colId.setCellValueFactory(new PropertyValueFactory("id"));
       this.colName.setCellValueFactory(new PropertyValueFactory("nombre"));
       this.colMark.setCellValueFactory(new PropertyValueFactory("marca"));
       this.colDescription.setCellValueFactory(new PropertyValueFactory("descripcion"));
       this.colType.setCellValueFactory(new PropertyValueFactory("tipo"));
       this.colPrice.setCellValueFactory(new PropertyValueFactory("precio"));
       this.colQuantity.setCellValueFactory(new PropertyValueFactory("cantidad"));
       
       this.productos = MySQL.getProductos();
       tableProducts.setItems(productos);
   }
   
   @FXML
   private void modifyServices(ActionEvent event) {
        try{
            cx = MySQL.ConnectDb();
            
            int id = Integer.parseInt(this.idTxt.getText());
            String name = this.nombreTxt.getText();
            String type = this.tipoTxt.getText();
            int price = Integer.parseInt(this.precioTxt.getText());
            String sql = "UPDATE Servicios SET id ='"+id+"', nombre= '"+name+"', tipo= '"+type+"', precio= '"+price+"' WHERE id ="+id; 
            if(price>0){
                
            ps= cx.prepareStatement(sql);
            ps.execute();
            System.out.println("Actualizado");
            
            Servicio u = this.tableService.getSelectionModel().getSelectedItem();
         if(u == null){ 
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setTitle("Error");
            alerta.setContentText("Datos incorrectoafas");
            alerta.showAndWait();
         }else{
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setHeaderText(null);
            alerta.setTitle("Alerta");
            alerta.setContentText("Datos modificados");
            alerta.showAndWait();
            actualizarServicios();
         }
            }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos incorrectos, menor a 0 ");
            alert.showAndWait();   
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
            
        }
        
    }
   public void actualizarServicios(){
       this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
       this.nombreCol.setCellValueFactory(new PropertyValueFactory("nombre"));
       this.tipoCol.setCellValueFactory(new PropertyValueFactory("tipo"));
       this.precioCol.setCellValueFactory(new PropertyValueFactory("precio"));
      
       this.servicios = MySQL.getServicios();
       tableService.setItems(servicios);
   }
    

    @FXML
    private void deleteProducts(ActionEvent event){
      Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
      alerta.setTitle("Confirmacion");
      alerta.setHeaderText("Eliminar Datos");
      alerta.setContentText("Desea eliminar este producto o Servicio?");
      ButtonType btnSi = new ButtonType("Si");
      ButtonType btnNo = new ButtonType("No");
      alerta.getButtonTypes().setAll(btnSi,btnNo);
      Optional<ButtonType> opcion = alerta.showAndWait();
      if(opcion.get()==btnSi){
        
        cx = MySQL.ConnectDb();
        
        String idAux = this.txtId.getText();
        if(idAux.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Fila no seleccionada");
            alert.showAndWait();
        }else{
        int id = Integer.parseInt(this.txtId.getText());
        String sql = "delete from Productos where id='"+id+"'";
        try{
           ps = cx.prepareStatement(sql);
           ps.execute();
           this.tableProducts.refresh();
        }catch(NumberFormatException |SQLException e){
           System.out.println("Error al eliminar");            
        }
        Productos u = this.tableProducts.getSelectionModel().getSelectedItem();
         if(u == null){           
         }else{
            this.productos.remove(u);
            this.tableProducts.refresh();
         
         }
         
        
        }
        
      }
    }
    @FXML
    private void deleteServices(ActionEvent event){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
      alerta.setTitle("Confirmacion");
      alerta.setHeaderText("Añadir Datos");
      alerta.setContentText("Desea añadir este producto o Servicio?");
      ButtonType btnSi = new ButtonType("Si");
      ButtonType btnNo = new ButtonType("No");
      alerta.getButtonTypes().setAll(btnSi,btnNo);
      Optional<ButtonType> opcion = alerta.showAndWait();
      if(opcion.get()==btnSi){
        cx = MySQL.ConnectDb();
        String idAux = this.idTxt.getText();
        if(idAux.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Fila no seleccionada");
            alert.showAndWait();
        }else{
        int id = Integer.parseInt(this.idTxt.getText());
        String sql = "delete from Servicios where id='"+id+"'";
        try{
           ps = cx.prepareStatement(sql);
           ps.execute();
           this.tableService.refresh();
        }catch(SQLException e){
            System.out.println("gdgsdgs");
            
        }
        Servicio u = this.tableService.getSelectionModel().getSelectedItem();
         if(u == null){           
         }else{
             this.servicios.remove(u);
             this.tableService.refresh();         
         }
            
        }

      }
    }

   public void closeWindow() {
        
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
    
    @FXML
    private void changeToProducts(ActionEvent event){
        viewProducts.setVisible(true);
        viewServices.setVisible(false);
        
    }
    @FXML
    private void changeToServices(ActionEvent event){
        viewProducts.setVisible(false);
        viewServices.setVisible(true);
    }

    @FXML
    void setEditable(MouseEvent event) {
        txtId.setEditable(true);
        idTxt.setEditable(true);
        txtId.setText("");
        txtName.setText("");
        txtMark.setText("");
        txtDescription.setText("");
        txtType.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        idTxt.setText("");
        nombreTxt.setText("");
        tipoTxt.setText("");
        precioTxt.setText("");

    }    
    
}
