package multidisciplinario.p;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController implements Initializable{

    
    @FXML
    private Button btnIniciar;
    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField contraseña;

    @FXML
    private PasswordField contraseñaB;

    @FXML
    private TextField correo;

    @FXML
    private TextField nombreB;

    @FXML
    private TextField nombreUsuario;

    @FXML
    private AnchorPane panelIniciar;

    @FXML
    private AnchorPane panelRegistrar;

    @FXML
    private ComboBox tipo;
    
    Connection cx = null;
    ResultSet rs = null;
    PreparedStatement ps;
    
    @FXML
    public void PanelIniciarSesion(ActionEvent event){
        panelIniciar.setVisible(true);
        panelRegistrar.setVisible(false);
        
    }
    
    @FXML
    public void PanelRegistrarse(ActionEvent event){
        nombreUsuario.setText("");
        correo.setText("");
        contraseña.setText("");
        panelIniciar.setVisible(false);
        panelRegistrar.setVisible(true);
        
    }
    
    @FXML
    private void iniciarSesion(ActionEvent event) throws IOException{
        String nombreAux = this.nombreB.getText();
        String contraseñaAux = this.contraseñaB.getText();
        
        
        cx = MySQL.ConnectDb();
        String sql= "select contraseña from usuarios where usuarios.nombreUsuario='"+nombreAux+"';";
        try{
            ps = cx.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                String contraseñabd = rs.getString("contraseña");
                System.out.println(contraseñabd);
                if(contraseñabd.equals(contraseñaAux)){
                    btnIniciar.getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/View/Start.fxml"));
                    Stage mainStage = new Stage();
                    Scene scene = new Scene(root);
                    mainStage.setScene(scene);
                    mainStage.show();
                    
                    System.out.println("Usuario encontrado");
                }else{
                   Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setHeaderText(null);
                   alert.setTitle("Error");
                   alert.setContentText("Contraseña incorrecta");
                   alert.showAndWait();
                }
                
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                   alert.setHeaderText(null);
                   alert.setTitle("Error");
                   alert.setContentText("Usuario no encontrado");
                   alert.showAndWait();
            }
         }catch(SQLException e){
            System.out.println(e);
        }
           
    }
    @FXML
    private void addUser(ActionEvent event){
        cx = MySQL.ConnectDb();
        String sql = "insert into usuarios (nombreUsuario,contraseña,email,tipo) VALUES(?,?,?,?)";
        try{          
            String auxNombre = this.nombreUsuario.getText();
            String auxContraseña = this.contraseña.getText();
            String auxCorreo = this.correo.getText();
            String auxTipo = this.tipo.getValue().toString();
            Usuario u = new Usuario(auxNombre,auxContraseña,auxCorreo,auxTipo);
        if(u.validarDatos()){
            ps = cx.prepareStatement(sql);
            ps.setString(1, nombreUsuario.getText());
            ps.setString(2, contraseña.getText());
            ps.setString(3, correo.getText());
            ps.setString(4, tipo.getValue().toString());
            ps.execute();
           
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Alerta");
            alert.setContentText("Usuario registrado con exito");
            alert.showAndWait();
            panelIniciar.setVisible(true);
            panelRegistrar.setVisible(false);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Datos faltantes");
            alert.showAndWait();            
        }
          
        }catch(NumberFormatException | SQLException e){
            System.out.println("Error al añadir usuario");
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipo.getItems().addAll("Administrador","Trabajador");      
    }    
}
