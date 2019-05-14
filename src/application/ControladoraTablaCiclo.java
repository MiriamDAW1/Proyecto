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
		private Button Eliminar;
		
		@FXML
		private Button Mostrar;
		
		
		@FXML
		private TableView<Ciclo> Tabla;
		
		@FXML
		private TableColumn<Ciclo,String> ID_ciclo;

		@FXML
		private TableColumn<Ciclo,String> numdecurso;
		
		@FXML
		private TableColumn<Ciclo,String> Cicloformativo;
		
		@FXML
		private TableColumn<Ciclo,String>  Familiaprofesional;
		
		@FXML
		private TableColumn<Ciclo,String> Capacidadesterminales;
		
		@FXML
		private TableColumn<Ciclo,String>  Actividadesformativos;
		
		@FXML
		private TableColumn<Ciclo,String>  Criterioevaluación;
		
		
	   private ObservableList<Alumno> Alumnos = FXCollections.observableArrayList();
		
		private Main ProgramaPrincipal;
		
		private int posicionCiclo;
		
		@FXML
		public void initialize() {

		 // TODO (don't really need to do anything here).
			 ID_ciclo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("ID_ciclo"));
			 numdecurso.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("numdecurso"));
			 Cicloformativo.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Cicloformativo"));
			 Familiaprofesional.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Familiaprofesional"));
			 Capacidadesterminales.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Capacidadesterminales"));
			 Actividadesformativos.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Actividadesformativos"));
			 Criterioevaluación.setCellValueFactory(new PropertyValueFactory<Ciclo,String>("Criterioevaluación"));	
		}
		   
		public void Mostrar(ActionEvent event) {
		       System.out.println("Button Clicked!");
		       
		       Conexion conexionBBDD = new Conexion();
		       
		       //Tabla.setItems(conexionBBDD.Consulta2());   
		       
	   }
		
		public void Anadir(ActionEvent event) throws IOException{

	 		FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_anadir_Ciclos.fxml"));
	 		AnchorPane ventanaDos = (AnchorPane) loader.load();
	         Stage ventana = new Stage();
	         ventana.setTitle("Nuevo Instituto");
	         Scene scene = new Scene(ventanaDos);
	         ventana.setScene(scene);
	         ventana.show();
	 	}
		
	   public void Modificar(ActionEvent event) throws IOException{
			
			FXMLLoader loader = new FXMLLoader(Main.class.getResource("pantalla_anadir_Ciclos.fxml"));
	 		AnchorPane ventanaDos = (AnchorPane) loader.load();
	         Stage ventana = new Stage();
	         ventana.setTitle("Modificar Instituto");
	         Scene scene = new Scene(ventanaDos);
	         ventana.setScene(scene);
	         ventana.show();
	 	}
		
	   public void Eliminar(ActionEvent event) throws IOException{
			Alumnos.remove(posicionCiclo);
		}
	}


