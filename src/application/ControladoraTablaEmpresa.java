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

public class ControladoraTablaEmpresa {

	@FXML
	private Button Anadir;
	
	@FXML
	private Button Modificar;

	@FXML
	private Button Mostrar;
	
	@FXML
	private Button Tutor_empresa;
	
	@FXML
	private TableView<Empresa> Tabla;
	
	@FXML
	private TableColumn<Empresa,String> ID_Convenio;
	
	@FXML
	private TableColumn<Empresa,String> Nombre;
	
	@FXML
	private TableColumn<Empresa,String>  Provincia;
	
	@FXML
	private TableColumn<Empresa,String> CIF;
	
	@FXML
	private TableColumn<Empresa,String> Pais;
	

	@FXML
	private TableColumn<Empresa,String> Ciudad;
	

	@FXML
	private TableColumn<Empresa,String> Direccion;
	
	@FXML
	private TableColumn<Empresa,String> CP;
	
	@FXML
	private TableColumn<Empresa,String> Telefono;
	
	@FXML
	private TableColumn<Empresa,String> Fax;
	
	@FXML
	private TableColumn<Empresa,String>  Fecha_firma;
	
	private ObservableList<Empresa> empresa = FXCollections.observableArrayList();
	
	private Main ProgramaPrincipal;
	

	@FXML
	public void initialize() {

	 // TODO (don't really need to do anything here).
		ID_Convenio.setCellValueFactory(new PropertyValueFactory<Empresa,String>("ID_Convenio"));
		 Nombre.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Nombre"));
		 Provincia.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Provincia"));
		 CIF.setCellValueFactory(new PropertyValueFactory<Empresa,String>("CIF"));
		 Pais.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Pais"));
		 Ciudad.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Ciudad"));
		 Direccion.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Direccion"));	
		 CP.setCellValueFactory(new PropertyValueFactory<Empresa,String>("CP"));	
		 Telefono.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Telefono"));	
		 Fax.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Fax"));	
		 Fecha_firma.setCellValueFactory(new PropertyValueFactory<Empresa,String>("Fecha_firma"));	
	}
	
	public void Mostrar(ActionEvent event) {
	       System.out.println("Mostrar Empresa");
	       
	       Conexion conexionBBDD = new Conexion();   
	       Tabla.setItems(conexionBBDD.Consulta3());
}
	
	
	public void Anadir(ActionEvent event) throws IOException{
		
		System.out.println("Añadir Empresa");
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_6_anadir_empresa.fxml"));
		AnchorPane ventanaDos = (AnchorPane) loader.load();
      Stage ventana = new Stage();
      ventana.setTitle("Nuevo empresa");
      Scene scene = new Scene(ventanaDos);
      ventana.setScene(scene);
      ventana.show();
	}
	
	public void Modificar(ActionEvent event) throws IOException{
		
		System.out.println("Modificar Empresa");
		
		Empresa selectedEmpresa = Tabla.getSelectionModel().getSelectedItem();
		
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_6_modificar_empresa.fxml"));
		AnchorPane ventanaDos = (AnchorPane) loader.load();
      Stage ventana = new Stage();
      ControladoraModificarEmpresa controller = loader.getController();
      controller.setEmpresa(selectedEmpresa);
      ventana.setTitle("Modificar Empresa");
      Scene scene = new Scene(ventanaDos);
      ventana.setScene(scene);
      ventana.show();
      
	}
	
	public void Tutor_empresa(ActionEvent event) throws IOException{
			
		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_tabla_tutor_empresa.fxml"));
		AnchorPane ventanaDos = (AnchorPane) loader.load();
		Stage ventana = new Stage();
		ventana.setTitle("Ventana Tutor_empresa");
		Scene scene = new Scene(ventanaDos);
		ventana.setScene(scene);
		ventana.show();
      
	}
}
