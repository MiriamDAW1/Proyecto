package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladoraTablaAlumno {
	
	@FXML
	private Button Anadir;
	
	@FXML
	private Button Modificar;
	
	@FXML
	private Button Mostrar;
	
	@FXML
	private TableView<Alumno> Tabla;
	
	@FXML
	private TableColumn<Alumno,String> ColDNI_Alumno;

	@FXML
	private TableColumn<Alumno,String> ColNombre;
	
	@FXML
	private TableColumn<Alumno,String> ColApellido;
	
	@FXML
	private TableColumn<Alumno,String> ColTelefono;
	
	@FXML
	private TableColumn<Alumno,String> ColProvincia;
	
	@FXML
	private TableColumn<Alumno,String> ColLocalidad;
	
	@FXML
	private TableColumn<Alumno,String> ColCorreoelectronico;
	
	@FXML
	private TableColumn<Alumno,String> ColNacionalidad;
	
	@FXML
	private TableColumn<Alumno,String> ColDNI_Tutor;
	
	@FXML
	private TableColumn<Alumno,String> ColNumAlumnos;
	
	@FXML
	private TableColumn<Alumno,String> ColNota;
	
	private ObservableList<Alumno> Alumnos = FXCollections.observableArrayList();
	
	private Main ProgramaPrincipal;
	   
	@FXML
	public void initialize() {

	 // TODO (don't really need to do anything here).
		ColDNI_Alumno.setCellValueFactory(new PropertyValueFactory<Alumno,String>("DNI_Alumno"));
		ColNombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Nombre"));
		ColNumAlumnos.setCellValueFactory(new PropertyValueFactory<Alumno,String>("NumAlumnos"));
		ColCorreoelectronico.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Correoelectronico"));
		ColApellido.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Apellido"));
		ColNacionalidad.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Nacionalidad"));
		ColProvincia.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Provincia"));
		ColNota.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Nota"));
		ColLocalidad.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Localidad"));
		ColTelefono.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Telefono"));
		ColDNI_Tutor.setCellValueFactory(new PropertyValueFactory<Alumno,String>("DNI_Tutor"));
			
	}
	
	public void Mostrar(ActionEvent event) {
		
	       System.out.println("Mostrar Alumno");
	       
	       Conexion conexionBBDD = new Conexion();
	       
	       Tabla.setItems(conexionBBDD.Consulta());
	       
    }
	
	public void Anadir(ActionEvent event) throws IOException{
		
		System.out.println("A�adir Alumno");
		
 		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_4_anadir_alumno.fxml"));
 		AnchorPane ventanaDos = (AnchorPane) loader.load();
         Stage ventana = new Stage();
         ventana.setTitle("Nuevo Alumno");
         Scene scene = new Scene(ventanaDos);
         ventana.setScene(scene);
         ventana.show();
 	}
	
	public void Modificar(ActionEvent event) throws IOException{
		
		System.out.println("Modificar Alumno");
		
		Alumno selectedAlumno = Tabla.getSelectionModel().getSelectedItem();
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_4_modificar_alumno.fxml"));
 		AnchorPane ventanaDos = (AnchorPane) loader.load();
         Stage ventana = new Stage();
         ControladoraModificarAlumno controller = loader.getController();
         controller.setAlumno(selectedAlumno);
         ventana.setTitle("Modificar Alumno");
         Scene scene = new Scene(ventanaDos);
         ventana.setScene(scene);
         ventana.show();
         
 	}
		
  }
	
