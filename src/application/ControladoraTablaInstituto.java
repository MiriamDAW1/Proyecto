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

public class ControladoraTablaInstituto {
	
	@FXML
	private Button Anadir;
	
	@FXML
	private Button Modificar;
	
	@FXML
	private Button Mostrar;
	
	@FXML
	private TableView<Instituto> Tabla;
	
	@FXML
	private TableColumn<Alumno,String> ID_Instituto;
	
	@FXML
	private TableColumn<Alumno,String> NombreCentro;
	
	@FXML
	private TableColumn<Alumno,String>  Profesor_Tutor;
	
	@FXML
	private TableColumn<Alumno,String> FAX;
	
	@FXML
	private TableColumn<Alumno,String> Director;
	
	@FXML
	private TableColumn<Alumno,String> NIFDirector;
	
	@FXML
	private TableColumn<Alumno,String> Telefono;
	
	@FXML
	private TableColumn<Alumno,String>  Direccion;
	
	@FXML
	private TableColumn<Alumno,String> Poblacion;
	
	@FXML
	private TableColumn<Alumno,String>  DAT;
	
	@FXML
	private TableColumn<Alumno,String>  Ciudad;
	
	@FXML
	private TableColumn<Alumno,String>   CP;
	
	private ObservableList<Instituto> Institutos = FXCollections.observableArrayList();
	
    private Main ProgramaPrincipal;
	
	@FXML
	public void initialize() {

	 // TODO (don't really need to do anything here).
		 ID_Instituto.setCellValueFactory(new PropertyValueFactory<Alumno,String>("ID_Instituto"));
		 NombreCentro.setCellValueFactory(new PropertyValueFactory<Alumno,String>("NombreCentro"));
		 Profesor_Tutor.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Profesor_Tutor"));
		 FAX.setCellValueFactory(new PropertyValueFactory<Alumno,String>("FAX"));
		 Director.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Director"));
		 NIFDirector.setCellValueFactory(new PropertyValueFactory<Alumno,String>("NIFDirector"));
		 Telefono.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Telefono"));
		 Direccion.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Direccion"));
		 Poblacion.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Poblacion"));
		 DAT.setCellValueFactory(new PropertyValueFactory<Alumno,String>("DAT"));
		 Ciudad.setCellValueFactory(new PropertyValueFactory<Alumno,String>("Ciudad"));
		 CP.setCellValueFactory(new PropertyValueFactory<Alumno,String>("CP"));
		
	}
	
	public void Mostrar(ActionEvent event) {
		
		   System.out.println("Mostrar Instituto");
	       
	       Conexion conexionBBDD = new Conexion();
	       
	       Tabla.setItems(conexionBBDD.Consulta1());      
   }
	
	public void Anadir(ActionEvent event) throws IOException{
		
		System.out.println("A�adir Instituto");
		
 		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_anadir_instituto.fxml"));
 		AnchorPane ventanaDos = (AnchorPane) loader.load();
         Stage ventana = new Stage();
         ventana.setTitle("Nuevo Instituto");
         Scene scene = new Scene(ventanaDos);
         ventana.setScene(scene);
         ventana.show();
 	}
	
	public void Modificar(ActionEvent event) throws IOException{
		

		System.out.println("Modificar Instituto");
		
		Instituto selectedInstituto = Tabla.getSelectionModel().getSelectedItem();
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_modificar_instituto.fxml"));
 		AnchorPane ventanaDos = (AnchorPane) loader.load();
         Stage ventana = new Stage();
         ControladoraModificarInstituto controller = loader.getController();
         controller.setInstituto(selectedInstituto);
         ventana.setTitle("Modificar Instituto");
         Scene scene = new Scene(ventanaDos);
         ventana.setScene(scene);
         ventana.show();
	}
}
