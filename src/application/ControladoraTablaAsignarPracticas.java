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

public class ControladoraTablaAsignarPracticas {
	
	@FXML
	private Button Anadir;
	
	@FXML
	private Button Mostrar;
	
	@FXML
	private TableView<AsignarPracticas> Tabla;
	
	@FXML
	private TableColumn<AsignarPracticas,String> ColID_Convenio;

	@FXML
	private TableColumn<AsignarPracticas,String> ColDNI_Alumno;
	
	@FXML
	private TableColumn<AsignarPracticas,String> ColFechainicio;
	
	@FXML
	private TableColumn<AsignarPracticas,String> ColFechafin;
	
	@FXML
	private TableColumn<AsignarPracticas,String> ColHorastotal;
	
	@FXML
	private TableColumn<AsignarPracticas,String> ColHoradia;
	
	@FXML
	private TableColumn<AsignarPracticas,String> ColHoratarde;
	
	@FXML
	private TableColumn<AsignarPracticas,String> ColHorariomanana;
	
	private ObservableList<AsignarPracticas> AsignarPracticas = FXCollections.observableArrayList();
	
	private Main ProgramaPrincipal;
	   
	@FXML
	public void initialize() {

	 // TODO (don't really need to do anything here).
		ColID_Convenio.setCellValueFactory(new PropertyValueFactory<AsignarPracticas,String>("ID_Convenio"));
		ColDNI_Alumno.setCellValueFactory(new PropertyValueFactory<AsignarPracticas,String>("DNI_Alumno"));
		ColFechainicio.setCellValueFactory(new PropertyValueFactory<AsignarPracticas,String>("Fechainicio"));
		ColFechafin.setCellValueFactory(new PropertyValueFactory<AsignarPracticas,String>("Fechafin"));
		ColHorastotal.setCellValueFactory(new PropertyValueFactory<AsignarPracticas,String>("Horastotal"));
		ColHoradia.setCellValueFactory(new PropertyValueFactory<AsignarPracticas,String>("Horadia"));
		ColHoratarde.setCellValueFactory(new PropertyValueFactory<AsignarPracticas,String>("Horatarde"));
		ColHorariomanana.setCellValueFactory(new PropertyValueFactory<AsignarPracticas,String>("Horariomanana"));
		
			
	}
	
	public void Mostrar(ActionEvent event) {
		
	       System.out.println("Mostrar Asignar Practicas");
	       
	       Conexion conexionBBDD = new Conexion();
	       
	       Tabla.setItems(conexionBBDD.Consulta5());
	       
    }
	
	public void Anadir(ActionEvent event) throws IOException{
		
		System.out.println("Añadir Asignar Practicas");
		
 		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_anadir_asignar_practicas.fxml"));
 		AnchorPane ventanaDos = (AnchorPane) loader.load();
         Stage ventana = new Stage();
         ventana.setTitle("Nuevo Asignar Practicas");
         Scene scene = new Scene(ventanaDos);
         ventana.setScene(scene);
         ventana.show();
 	}
}
