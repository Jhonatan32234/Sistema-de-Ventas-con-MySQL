/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package multidisciplinario.p;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.SQLException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author jhona
 */
public class SearchController implements Initializable {
    
    //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$44
    @FXML
    private Label label;
    @FXML
    private ComboBox menu;
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
    private TableColumn colDescription;    
    @FXML
    private TableColumn colId;
    @FXML
    private TableColumn colMark;
    @FXML
    private TextField txtDescription;
    @FXML
    private TableColumn colName;
    @FXML
    private TableColumn colPrice;
    @FXML
    private TableColumn colType;
    @FXML
    private Button btnEarnings;
    @FXML
    private Button btnInventory;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnSelect;
    @FXML
    private Button exd;   
    @FXML
    private TableColumn colQuantity;
    @FXML
    private TableView<Productos> tableProducts;
    
    private ObservableList<Productos> productos;
    private ObservableList<Productos> buscarProductos;
    //$$$$$$$$$$$$$$$$$$$$PRODUCTOS$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$44
    @FXML
    private Button btnAñadir;
    @FXML
    private TextField ProSer;
    @FXML
    private TextField total;
    @FXML
    private TextField cantidadVista;
    @FXML
    private TextField descripcionVista;
    @FXML
    private TextField selectProSer;
    @FXML
    private TextField nombreVista;
    @FXML
    private TextField precioVista;
    @FXML
    private TextField filtroProductos;
    @FXML
    private TextField filtroServicios;
    @FXML
    private TextField eleccionCantidad;
    @FXML
    private Button btnFinalizar;
    @FXML
    private TextField importe;
    
    
    FilteredList<Productos> productoFiltro;
    FilteredList<Servicio> servicioFiltro;
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
    private TableColumn<?, ?> txtQuantity;
    @FXML
    private TextField tipoTxt;
    @FXML
    private TableView<Servicio> tableService;
    
    private ObservableList<Servicio> servicios;
    int index = -1;
//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$SERVICIOS$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4
  Connection cx;
  PreparedStatement ps;
  String tipoAux;
  boolean estado = true;
  int cantidadContador=0;
  int resultado;
  Productos PAux;
  Servicio SAux ;
    @FXML
    void Select(ActionEvent event) {
        String s = menu.getSelectionModel().getSelectedItem().toString();
        label.setText(s);
    
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    

//$$$$$$$$$$$$$$$$$PRODUCTOS$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4
       this.colId.setCellValueFactory(new PropertyValueFactory("id"));
       this.colName.setCellValueFactory(new PropertyValueFactory("nombre"));
       this.colMark.setCellValueFactory(new PropertyValueFactory("marca"));
       this.colDescription.setCellValueFactory(new PropertyValueFactory("descripcion"));
       this.colType.setCellValueFactory(new PropertyValueFactory("tipo"));
       this.colPrice.setCellValueFactory(new PropertyValueFactory("precio"));
       this.colQuantity.setCellValueFactory(new PropertyValueFactory("cantidad"));     
       this.productos = MySQL.getProductos();
       this.tableProducts.setItems(productos);      
       productoFiltro= new FilteredList(productos,p->true);

//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$4
       
//$$$$$$$$$$$$$$$$SERVICIOS$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
       this.idCol.setCellValueFactory(new PropertyValueFactory("id"));
       this.nombreCol.setCellValueFactory(new PropertyValueFactory("nombre"));
       this.tipoCol.setCellValueFactory(new PropertyValueFactory("tipo"));
       this.precioCol.setCellValueFactory(new PropertyValueFactory("precio"));     
       this.servicios = MySQL.getServicios();
       tableService.setItems(servicios);      
       servicioFiltro =new FilteredList(servicios,p->true);
 //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

 
 /*
 La excepción NumberFormatException se lanza cuando se intenta convertir una cadena (String) en un tipo numérico 
 y esta cadena no tiene un formato válido para ser convertida. Por otro lado, la excepción InputMismatchException 
 se lanza en Java cuando se intenta leer un tipo de dato que no coincide con lo que se espera en la entrada de datos
 (por ejemplo, se espera leer un entero pero se ingresa un String).

En el caso de JavaFX, muchas veces se trabaja con componentes gráficos que permiten al usuario ingresar información, 
 como TextBox para ingresar números. Cuando se intenta convertir el contenido de estos componentes en un tipo numérico,
 es posible que se lance la excepción NumberFormatException si el usuario ingresa un valor que no puede ser convertido
 a número.

Por lo tanto, es común que en aplicaciones JavaFX se maneje la excepción NumberFormatException al trabajar con la
 conversión de String a números, en lugar de InputMismatchException, que se utiliza más comúnmente en la lectura 
 de datos desde la consola.
 */
    }    
    public void closeWindow(){
          try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Start.fxml"));
           Parent root = loader.load();
           //StartController controller = loader.load();
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           
           stage.setScene(scene);
           stage.show();
           
           //stage.setOnCloseRequest(e ->controller.closeWindow());
           
           Stage myStage = (Stage) this.exd.getScene().getWindow();
           myStage.close();
           
       } catch (IOException ex) {
           Logger.getLogger(StartController.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
       }
    }
    StartController start;

    public StartController getSearch() {
        return start;
    }

    public void setSearch(StartController search) {
        this.start = search;
    }
    
    
    @FXML   
    private void filtrarProductos(KeyEvent event){
        
        
        filtroProductos.textProperty().addListener((observable,oldValue,newValue)->{
        
           productoFiltro.setPredicate(prod->{
               if(newValue==null||newValue.isEmpty()){
               return true;
               }
               else if(prod.getNombre().toLowerCase().contains(newValue.toLowerCase())){
               return true;
               }
               return false;
           });
        });
        SortedList<Productos> arreglo = new SortedList<>(productoFiltro);
        arreglo.comparatorProperty().bind(tableProducts.comparatorProperty());
        tableProducts.setItems(arreglo);
    }
    
    @FXML  
    private void filtrarServicios(KeyEvent event){
         filtroServicios.textProperty().addListener((observable,oldValue,newValue)->{
        
           servicioFiltro.setPredicate(prod->{
               if(newValue==null||newValue.isEmpty()){
               return true;
               }
               else if(prod.getNombre().toLowerCase().contains(newValue.toLowerCase())){
               return true;
               }
               return false;
           });
        });
        SortedList<Servicio> arreglo = new SortedList<>(servicioFiltro);
        arreglo.comparatorProperty().bind(tableService.comparatorProperty());
        tableService.setItems(arreglo);
    }
    
    @FXML
     void getProducts(MouseEvent event){
        this.index = tableProducts.getSelectionModel().getSelectedIndex();
        if(index<= -1){
            return;
        }
        nombreVista.setText(this.colName.getCellData(index).toString());
        descripcionVista.setText(this.colDescription.getCellData(index).toString());
        precioVista.setText(this.colPrice.getCellData(index).toString());
        cantidadVista.setText(this.colQuantity.getCellData(index).toString());
        tipoAux = this.colType.getCellData(index).toString();
        int id = Integer.parseInt(this.colId.getCellData(index).toString());        
        String nombre=this.colName.getCellData(index).toString();
        String marca = this.colMark.getCellData(index).toString();
        String descripcion = this.colDescription.getCellData(index).toString();
        String tipo =this.colType.getCellData(index).toString();
        int precio = Integer.parseInt(this.colPrice.getCellData(index).toString());
        int cantidad = Integer.parseInt(this.colQuantity.getCellData(index).toString());
        PAux = new Productos(id, nombre, marca, descripcion, tipo, precio, cantidad); 
        estado = false;
        importe.setEditable(false);
}  
    @FXML 
     void getServices(MouseEvent event){
    this.index= tableService.getSelectionModel().getSelectedIndex();
    if(index <=-1){
        return;
    }
    nombreVista.setText(this.nombreCol.getCellData(index).toString());
    precioVista.setText(this.precioCol.getCellData(index).toString());
    tipoAux = this.tipoCol.getCellData(index).toString();
    descripcionVista.setText(" ");
    cantidadVista.setText(" ");
    int id = Integer.parseInt(this.idCol.getCellData(index).toString());
    String nombre=this.nombreCol.getCellData(index).toString();
    String tipo =this.tipoCol.getCellData(index).toString();
    int precio = Integer.parseInt(this.precioCol.getCellData(index).toString());
    SAux = new Servicio(id,nombre,tipo,precio);          
    estado = true;
    importe.setEditable(true);
  }
  @FXML  
  private void añadirProSer(ActionEvent event){
      Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
      alerta.setTitle("Confirmacion");
      alerta.setHeaderText("Añadir Datos");
      alerta.setContentText("Desea añadir este producto o Servicio?");
      ButtonType btnSi = new ButtonType("Si");
      ButtonType btnNo = new ButtonType("No");
      alerta.getButtonTypes().setAll(btnSi,btnNo);
      Optional<ButtonType> opcion = alerta.showAndWait();     
      if(opcion.get()==btnSi){
        int cantidadbd =0;
        int importeExtra=0;                
        try{
        String nombrebd = this.nombreVista.getText();
        int cantidadSelect = Integer.parseInt(this.eleccionCantidad.getText());
        int preciodb = Integer.parseInt(this.precioVista.getText());
        if(estado){   
        cantidadbd = 999999;
        importeExtra=Integer.parseInt(importe.getText());
        }else{
        cantidadbd = Integer.parseInt(this.cantidadVista.getText());
        }

        if(cantidadSelect<=cantidadbd){
            cantidadContador++;
            selectProSer.setText(Integer.toString(cantidadContador));  
            String totalAux = Integer.toString(cantidadSelect*preciodb);
          total.setText(Integer.toString(resultado));
          cx = MySQL.ConnectDb();
          String sql = "insert into ventas (nombre,cantidad,tipo,total) values (?,?,?,?)";
          try{
              ps = cx.prepareStatement(sql);
              ps.setString(1, nombrebd);
              ps.setString(2, eleccionCantidad.getText());
              ps.setString(3, tipoAux);
              ps.setString(4, totalAux);
              ps.execute();              
          }catch(SQLException e){
          } 
             if(estado){
                  SAux.setImporte(importeExtra);
                  resultado=SAux.obtenerPrecio(cantidadSelect)+resultado;
                  total.setText(Integer.toString(resultado));
             }else{
                 resultado=PAux.obtenerPrecio(cantidadSelect)+resultado;
                 total.setText(Integer.toString(resultado));
             }
             Alert alert = new Alert(Alert.AlertType.INFORMATION);
              alert.setHeaderText(null);
              alert.setTitle("Exito");
              alert.setContentText("Datos añadidos");
              alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Cantidad mayor a la disponible");
            alert.showAndWait();
        }
          
      }catch(NumberFormatException e){
            System.out.println(e);
          Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos incorrectosfasfas");
            alert.showAndWait();
      }
      }    
}
  
  @FXML
  private void finalizarCompra(ActionEvent event){
      try{
      String total1=this.total.getText();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Cliente.fxml"));      
      Parent root = loader.load();
      ClienteController controller = loader.getController();
      controller.mostrarTotal(total1); 
      Scene scene = new Scene(root);
      Stage stage = new Stage();
      stage.setScene(scene);
      stage.show();
      deleteText();    
      }catch(IOException e){
          System.out.println(e);
      }
  }
  public void deleteText(){
      this.nombreVista.setText("");
      this.descripcionVista.setText("");
      this.precioVista.setText("");
      this.importe.setText("");
      this.eleccionCantidad.setText("");
      this.cantidadVista.setText("");
      this.selectProSer.setText("");
      this.total.setText("");
  }
}
    

