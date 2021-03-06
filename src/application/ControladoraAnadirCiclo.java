package application;

import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraAnadirCiclo {

	@FXML
	private Button GUARDARCAMBIOS;
	
	@FXML
	private Button CANCELAR;
	
	@FXML
    private TextField ID_cicloTextField;

	@FXML
    private TextField numdecursoTextField;
	
	@FXML
    private TextField CicloformativoTextField;
	
	@FXML
    private TextField  FamiliaprofesionalTextField;
	
	@FXML
    private TextField CapacidadesterminalesTextField;
	
	@FXML
    private TextField  ActividadesformativosTextField;
	
	@FXML
    private TextField  CriterioevaluacionTextField;
	
	
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
				conexionBBDD.InsertarCiclo( ID_cicloTextField.getText(), numdecursoTextField.getText(), CicloformativoTextField.getText(), FamiliaprofesionalTextField.getText(), CapacidadesterminalesTextField.getText(), ActividadesformativosTextField.getText(), CriterioevaluacionTextField.getText());
			} catch (SQLException e) {
				// TODO Bloque catch generado autom�ticamente
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
    
    //Validaci�n de datos
    private boolean datosValidos(){
        
        //Inicializo string para mensajes
        String mensajeError = "";

        //Compruebo los campos
        if (ID_cicloTextField.getText() == null || ID_cicloTextField.getText().length() == 0) {
            mensajeError += "ID_Instituto no v�lido.\n"; 
        }
        if ( numdecursoTextField.getText() == null ||  numdecursoTextField.getText().length() == 0) {
            mensajeError += "NombreCentro no v�lidos.\n"; 
        }
        if (CicloformativoTextField.getText() == null || CicloformativoTextField.getText().length() == 0) {
            mensajeError += "Profesor_Tutor no v�lida.\n"; 
        }

        if (FamiliaprofesionalTextField.getText() == null ||  FamiliaprofesionalTextField.getText().length() == 0) {
            mensajeError += "FAX no v�lido.\n"; 
        } 

        if ( CapacidadesterminalesTextField.getText() == null ||  CapacidadesterminalesTextField.getText().length() == 0) {
            mensajeError += "Director no v�lida.\n"; 
        }

        if ( ActividadesformativosTextField.getText() == null ||  ActividadesformativosTextField.getText().length() == 0) {
            mensajeError += "NIFDirector no v�lida.\n";
        } 
        
        if (CriterioevaluacionTextField.getText() == null || CriterioevaluacionTextField.getText().length() == 0) {
            mensajeError += "Telefono no v�lida.\n";
        } 
        
        //Si no hay errores devuelvo true, si no, una alerta con los errores y false
        if (mensajeError.length() == 0) {
            return true;
        } else {
            //Muestro alerta y devuelvo false
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Datos no v�lidos");
            alerta.setContentText("Por favor, corrige los errores");
            alerta.showAndWait();
            return false;
        }
        
    }
	
}

