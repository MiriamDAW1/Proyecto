package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraAnadirAsignarPracticas {
	

	@FXML
	private Button GUARDARCAMBIOS;
	
	@FXML
	private Button CANCELAR;
	
	@FXML
    private TextField ID_ConvenioTextField;
	
	@FXML
    private TextField DNI_AlumnoTextField;
	
	@FXML
    private TextField FechainicioTextField;
	
	@FXML
    private TextField FechafinTextField;

	@FXML
    private TextField HorastotalTextField;
	
	@FXML
    private TextField HoradiaTextField;
	
	@FXML
    private TextField HoratardeTextField;
	
	@FXML
    private TextField HorariomananaTextField;
	
	private Stage ventana;
	private AsignarPracticas asignarpracticas; 
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
				conexionBBDD.InsertarPractica(ID_ConvenioTextField.getText(), DNI_AlumnoTextField.getText(), FechainicioTextField.getText(), FechafinTextField.getText(), HorastotalTextField.getText(), HoradiaTextField.getText(), HoratardeTextField.getText(), HorariomananaTextField.getText());
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
        if (ID_ConvenioTextField.getText() == null || ID_ConvenioTextField.getText().length() == 0) {
            mensajeError += "DNI_Alumno no válido.\n"; 
        }
        if (DNI_AlumnoTextField.getText() == null || DNI_AlumnoTextField.getText().length() == 0) {
            mensajeError += "Nombre no válidos.\n"; 
        }
        if (FechainicioTextField.getText() == null || FechainicioTextField.getText().length() == 0) {
            mensajeError += "Apellido no válida.\n"; 
        }

        if (FechafinTextField.getText() == null || FechafinTextField.getText().length() == 0) {
            mensajeError += "Telefono no válido.\n"; 
        } 

        if (HorastotalTextField.getText() == null || HorastotalTextField.getText().length() == 0) {
            mensajeError += "Provincia no válida.\n"; 
        }

        if (HoradiaTextField.getText() == null || HoradiaTextField.getText().length() == 0) {
            mensajeError += "Localidad no válida.\n";
        } 
        
        if (HoratardeTextField.getText() == null || HoratardeTextField.getText().length() == 0) {
            mensajeError += "Correoelectronico no válida.\n";
        } 
        
        if (HorariomananaTextField.getText() == null ||HorariomananaTextField.getText().length() == 0) {
            mensajeError += "Nacionalidad no válida.\n";
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
