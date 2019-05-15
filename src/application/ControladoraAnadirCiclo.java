package application;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ControladoraAnadirCiclo {

	@FXML
	private Button GUARDARCAMBIOS;
	
	@FXML
	private Button CANCELAR;
	
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
	
	
   private Stage ventana;
   private Ciclo ciclo; 
   private boolean guardarClicked = false;
   
   @FXML
   private void initialize() {
   }

	public boolean isGuardarClicked() {
	      return guardarClicked;
	}
	
	@FXML
    private void guardar() {
        
        if (datosValidos()) {
            Conexion conexionBBDD = new Conexion();
            try {
				conexionBBDD.InsertarCiclo( ID_ciclo.getText(), numdecurso.getText(), Cicloformativo.getText(), Familiaprofesional.getText(), Capacidadesterminales.getText(), Actividadesformativos.getText(), Criterioevaluación.getText());
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
 	       
            guardarClicked = true; 
            ventana.close();
            
        }
    }
	
	//LLamado cuando se pulsa Cancelar
    @FXML
    private void cancelar() {
        ventana.close();
    }
    
    //Validación de datos
    private boolean datosValidos(){
        
        //Inicializo string para mensajes
        String mensajeError = "";

        //Compruebo los campos
        if (ID_ciclo.getText() == null || ID_ciclo.getText().length() == 0) {
            mensajeError += "ID_Instituto no válido.\n"; 
        }
        if ( numdecurso.getText() == null ||  numdecurso.getText().length() == 0) {
            mensajeError += "NombreCentro no válidos.\n"; 
        }
        if (Cicloformativo.getText() == null || Cicloformativo.getText().length() == 0) {
            mensajeError += "Profesor_Tutor no válida.\n"; 
        }

        if (Familiaprofesional.getText() == null ||  Familiaprofesional.getText().length() == 0) {
            mensajeError += "FAX no válido.\n"; 
        } 

        if ( Capacidadesterminales.getText() == null ||  Capacidadesterminales.getText().length() == 0) {
            mensajeError += "Director no válida.\n"; 
        }

        if ( Actividadesformativos.getText() == null ||  Actividadesformativos.getText().length() == 0) {
            mensajeError += "NIFDirector no válida.\n";
        } 
        
        if (Criterioevaluación.getText() == null || Criterioevaluación.getText().length() == 0) {
            mensajeError += "Telefono no válida.\n";
        } 
        
        //Si no hay errores devuelvo true, si no, una alerta con los errores y false
        if (mensajeError.length() == 0) {
            return true;
        } else {
            //Muestro alerta y devuelvo false
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos no válidos");
            alerta.setContentText("Por favor, corrige los errores");
            alerta.showAndWait();
            return false;
        }
        
    }
	
}
