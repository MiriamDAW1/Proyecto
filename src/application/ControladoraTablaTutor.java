package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControladoraTablaTutor {
	
	@FXML
	private Button Anadir;
	
	@FXML
	private Button Modificar;
	
	@FXML
	private Button Mostrar;
	
	@FXML
	private TableView<Tutor_empresa> Tabla;
	
	@FXML
	private TableColumn<Tutor_empresa,String> ColDNI_Tutor;

	@FXML
	private TableColumn<Tutor_empresa,String> ColTelefono;
	
	@FXML
	private TableColumn<Tutor_empresa,String> ColNacionalidad ;
	
	@FXML
	private TableColumn<Tutor_empresa,String> ColApellido ;
	
	@FXML
	private TableColumn<Tutor_empresa,String> ColNombre ;
	
	@FXML
	private TableColumn<Tutor_empresa,String> ColProvincia ;
	
	@FXML
	private TableColumn<Tutor_empresa,String> ColLocalidad ;
	
	@FXML
	private TableColumn<Tutor_empresa,String> ColCorreo_electronico;
	
	@FXML
	private TableColumn<Tutor_empresa,String> ColID_Convenio;
	
	private ObservableList<Tutor_empresa> Tutor_empresa = FXCollections.observableArrayList();
	
	private Main ProgramaPrincipal;
	   
	@FXML
	public void initialize() {

	 // TODO (don't really need to do anything here).
		ColDNI_Tutor.setCellValueFactory(new PropertyValueFactory<Tutor_empresa,String>("DNI_Tutor"));
		ColTelefono.setCellValueFactory(new PropertyValueFactory<Tutor_empresa,String>("Telefono "));
		ColNacionalidad.setCellValueFactory(new PropertyValueFactory<Tutor_empresa,String>("Nacionalidad "));
		ColApellido.setCellValueFactory(new PropertyValueFactory<Tutor_empresa,String>("Apellido "));
		ColNombre.setCellValueFactory(new PropertyValueFactory<Tutor_empresa,String>("Nombre "));
		ColProvincia.setCellValueFactory(new PropertyValueFactory<Tutor_empresa,String>("Provincia "));
		ColLocalidad.setCellValueFactory(new PropertyValueFactory<Tutor_empresa,String>("Localidad "));
		ColCorreo_electronico.setCellValueFactory(new PropertyValueFactory<Tutor_empresa,String>("Correo_electronico"));
		ColID_Convenio.setCellValueFactory(new PropertyValueFactory<Tutor_empresa,String>("ID_Convenio"));
			
	}
	
	public void Mostrar(ActionEvent event) {
		
	       System.out.println("Mostrar Tutor_empresa");
	       
	       Conexion conexionBBDD = new Conexion();
	       
	       Tabla.setItems(conexionBBDD.Consulta4());
	       
    }
	
	public void Anadir(ActionEvent event) throws IOException{
		
		System.out.println("Añadir Tutor_empresa");
		
 		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_anadir_tutor_empresa.fxml"));
 		AnchorPane ventanaDos = (AnchorPane) loader.load();
         Stage ventana = new Stage();
         ventana.setTitle("Nuevo Tutor");
         Scene scene = new Scene(ventanaDos);
         ventana.setScene(scene);
         ventana.show();
 	}
	
	/*public void Modificar(ActionEvent event) throws IOException{
		
		System.out.println("Modificar Tutor_empresa");
		
		Alumno selectedAlumno = Tabla.getSelectionModel().getSelectedItem();
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_4_modificar_alumno.fxml"));
 		AnchorPane ventanaDos = (AnchorPane) loader.load();
         Stage ventana = new Stage();
         ControladoraModificarAlumno controller = loader.getController();
         controller.setAlumno(selectedAlumno);
         ventana.setTitle("Modificar Tutor");
         Scene scene = new Scene(ventanaDos);
         ventana.setScene(scene);
         ventana.show();
         
 	}*/
}
