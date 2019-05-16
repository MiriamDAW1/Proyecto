package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraAnadirEmpresa {
	
		@FXML
		private Button GUARDARCAMBIOS;
		
		@FXML
		private Button CANCELAR;
		
		@FXML
	    private TextField ID_ConvenioTextField;
		
		@FXML
	    private TextField NombreTextField;
		
		@FXML
	    private TextField ProvinciaTextField;
		
		@FXML
	    private TextField CIFTextField;

		@FXML
	    private TextField PaisTextField;
		
		@FXML
	    private TextField CiudadTextField;
		
		@FXML
	    private TextField DireccionTextField;
		
		@FXML
	    private TextField CPTextField;
		
		@FXML
	    private TextField TelefonoTextField;
		
		@FXML
	    private TextField FaxTextField;
		
		@FXML
	    private TextField Fecha_firmaTextField;
		
		private Stage ventana;
		private Empresa empresa; 
	    private boolean guardarClicked = false;
	    
	    @FXML
	    private void initialize() {
	    }
	    
	    public void setVentanaDialoge(Stage ventana) {
	        this.ventana = ventana;
	    }
	    
		public boolean isGuardarClicked() {
		      return guardarClicked;
		}
		
		@FXML
	    private void guardar() {
	        
	        if (datosValidos()) {
	            Conexion conexionBBDD = new Conexion();
	            try {
					conexionBBDD.InsertarEmpresa(ID_ConvenioTextField.getText(), NombreTextField.getText(), ProvinciaTextField.getText(), CIFTextField.getText(), PaisTextField.getText(), CiudadTextField.getText(), DireccionTextField.getText(), CPTextField.getText(), TelefonoTextField.getText(), FaxTextField.getText(), Fecha_firmaTextField.getText());
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
	        if (NombreTextField.getText() == null || NombreTextField.getText().length() == 0) {
	            mensajeError += "Nombre no válidos.\n"; 
	        }
	        if (ProvinciaTextField.getText() == null || ProvinciaTextField.getText().length() == 0) {
	            mensajeError += "Apellido no válida.\n"; 
	        }

	        if (CIFTextField.getText() == null || CIFTextField.getText().length() == 0) {
	            mensajeError += "Telefono no válido.\n"; 
	        } 

	        if (PaisTextField.getText() == null || PaisTextField.getText().length() == 0) {
	            mensajeError += "Provincia no válida.\n"; 
	        }

	        if (CiudadTextField.getText() == null || CiudadTextField.getText().length() == 0) {
	            mensajeError += "Localidad no válida.\n";
	        } 
	        
	        if (DireccionTextField.getText() == null || DireccionTextField.getText().length() == 0) {
	            mensajeError += "Correoelectronico no válida.\n";
	        } 
	        
	        if (CPTextField.getText() == null ||CPTextField.getText().length() == 0) {
	            mensajeError += "Nacionalidad no válida.\n";
	        } 
	        
	        if (TelefonoTextField.getText() == null || TelefonoTextField.getText().length() == 0) {
	            mensajeError += "DNI_Tutor no válida.\n";
	        } 
	        
	        if (FaxTextField.getText() == null || FaxTextField.getText().length() == 0) {
	            mensajeError += "DNI_Tutor no válida.\n";
	        }
	        
	        if (Fecha_firmaTextField.getText() == null || Fecha_firmaTextField.getText().length() == 0) {
	            mensajeError += "DNI_Tutor no válida.\n";
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