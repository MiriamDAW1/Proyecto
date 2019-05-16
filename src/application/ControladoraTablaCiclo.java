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

public class ControladoraTablaCiclo {
	
		@FXML
		private Button Anadir;
		
		@FXML
		private Button Modificar;
	
		@FXML
		private Button Mostrar;
		
		
		@FXML
		private TableView<Ciclo> Tabla;
		
		@FXML
		private TableColumn<Ciclo,String> ColID_ciclo;

		@FXML
		private TableColumn<Ciclo,String> Colnumdecurso;
		
		@FXML
		private TableColumn<Ciclo,String> ColCicloformativo;
		
		@FXML
		private TableColumn<Ciclo,String> ColFamiliaprofesional;
		
		@FXML
		private TableColumn<Ciclo,String> ColCapacidadesterminales;
		
		@FXML
		private TableColumn<Ciclo,String>  ColActividadesformativos;
		
		@FXML
		private TableColumn<Ciclo,String>  ColCriterioevaluacion;
		
		
	   private ObservableList<Ciclo> Ciclo = FXCollections.observableArrayList();
		
		private Main ProgramaPrincipal;
		
		
		@FXML
		public void initialize() {

		 // TODO (don't really need to do anything here).
			ColID_ciclo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("ID_ciclo"));
			Colnumdecurso.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("numdecurso"));
			ColCicloformativo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Cicloformativo"));
			ColFamiliaprofesional.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Familiaprofesional"));
			ColCapacidadesterminales.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Capacidadesterminales"));
			ColActividadesformativos.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Actividadesformativos"));
			ColCriterioevaluacion.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Criterioevaluacion"));	
		}
		  
		
		public void Mostrar(ActionEvent event) {
		       System.out.println("Mostrar Ciclo");
		       
		       Conexion conexionBBDD = new Conexion();   
		       Tabla.setItems(conexionBBDD.Consulta2());
	   }
		
		
		public void Anadir(ActionEvent event) throws IOException{
			
			System.out.println("Añadir Ciclo");
			
	 		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_anadir_ciclos.fxml"));
	 		AnchorPane ventanaDos = (AnchorPane) loader.load();
	         Stage ventana = new Stage();
	         ventana.setTitle("Nuevo Ciclo");
	         Scene scene = new Scene(ventanaDos);
	         ventana.setScene(scene);
	         ventana.show();
	 	}
		
		public void Modificar(ActionEvent event) throws IOException{
			
			System.out.println("Modificar Ciclo");
			
			Ciclo selectedCiclo = Tabla.getSelectionModel().getSelectedItem();
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_modificar_ciclos.fxml"));
	 		AnchorPane ventanaDos = (AnchorPane) loader.load();
	         Stage ventana = new Stage();
	         ControladoraModificarCiclo controller = loader.getController();
	         controller.setCiclo(selectedCiclo);
	         ventana.setTitle("Modificar Ciclo");
	         Scene scene = new Scene(ventanaDos);
	         ventana.setScene(scene);
	         ventana.show();
	         
	 	}
		
	  
	}