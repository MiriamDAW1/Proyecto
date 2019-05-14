package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraModificarAlumno {
		@FXML
		private Button GUARDARCAMBIOS;
		
		@FXML
		private Button CANCELAR;
		
		@FXML
	    private TextField DNI_AlumnoTextField;
		
		@FXML
	    private TextField NombreTextField;
		
		@FXML
	    private TextField ApellidoTextField;
		
		@FXML
	    private TextField TelefonoTextField;

		@FXML
	    private TextField ProvinciaTextField;
		
		@FXML
	    private TextField LocalidadTextField;
		
		@FXML
	    private TextField CorreoelectronicoTextField;
		
		@FXML
	    private TextField NacionalidadTextField;
		
		@FXML
	    private TextField DNI_TutorTextField;
		
		@FXML
	    private TextField NumAlumnosTextField;
		
		@FXML
	    private TextField NotaTextField;
		
		private Stage ventana;
		private Alumno alumno; 
	    private boolean guardarClicked = false;
	    
	    @FXML
	    private void initialize() {
	    }
	    
	    public void setVentanaDialoge(Stage ventana) {
	        this.ventana = ventana;
	    }
	    
	    public void setAlumno(Alumno alumno) {
	        this.alumno = alumno;

	        DNI_AlumnoTextField.setText(alumno.getDNI_Alumno());
	        NombreTextField.setText(alumno.getNombre());
	        ApellidoTextField.setText(alumno.getApellido());
	        TelefonoTextField.setText(alumno.getTelefono());
	        ProvinciaTextField.setText(alumno.getProvincia());
	        LocalidadTextField.setText(alumno.getLocalidad());
	        CorreoelectronicoTextField.setText(alumno.getCorreoelectronico());
	        NacionalidadTextField.setText(alumno.getNacionalidad());
	        DNI_TutorTextField.setText(alumno.getDNI_Tutor());
	        NumAlumnosTextField.setText(alumno.getNumAlumnos());
	        NotaTextField.setText(alumno.getNota());
	        
	    }
		
	   

		public boolean isGuardarClicked() {
		      return guardarClicked;
		}
		
		@FXML
	    private void guardar() {
	        
	        if (datosValidos()) {
	            Conexion conexionBBDD = new Conexion();
	            try {
					conexionBBDD.ModificarAlumno(DNI_AlumnoTextField.getText(), NombreTextField.getText(), ApellidoTextField.getText(), TelefonoTextField.getText(), ProvinciaTextField.getText(), LocalidadTextField.getText(), CorreoelectronicoTextField.getText(), NacionalidadTextField.getText(), DNI_TutorTextField.getText(), NumAlumnosTextField.getText(), NotaTextField.getText());
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
	        if (DNI_AlumnoTextField.getText() == null || DNI_AlumnoTextField.getText().length() == 0) {
	            mensajeError += "DNI_Alumno no válido.\n"; 
	        }
	        if (NombreTextField.getText() == null || NombreTextField.getText().length() == 0) {
	            mensajeError += "Nombre no válidos.\n"; 
	        }
	        if (ApellidoTextField.getText() == null || ApellidoTextField.getText().length() == 0) {
	            mensajeError += "Apellido no válida.\n"; 
	        }

	        if (TelefonoTextField.getText() == null || TelefonoTextField.getText().length() == 0) {
	            mensajeError += "Telefono no válido.\n"; 
	        } 

	        if (ProvinciaTextField.getText() == null || ProvinciaTextField.getText().length() == 0) {
	            mensajeError += "Provincia no válida.\n"; 
	        }

	        if (LocalidadTextField.getText() == null || LocalidadTextField.getText().length() == 0) {
	            mensajeError += "Localidad no válida.\n";
	        } 
	        
	        if (CorreoelectronicoTextField.getText() == null || CorreoelectronicoTextField.getText().length() == 0) {
	            mensajeError += "Correoelectronico no válida.\n";
	        } 
	        
	        if (NacionalidadTextField.getText() == null ||NacionalidadTextField.getText().length() == 0) {
	            mensajeError += "Nacionalidad no válida.\n";
	        } 
	        
	        if (DNI_TutorTextField.getText() == null || DNI_TutorTextField.getText().length() == 0) {
	            mensajeError += "DNI_Tutor no válida.\n";
	        } 
	        
	        if (NumAlumnosTextField.getText() == null || NumAlumnosTextField.getText().length() == 0) {
	            mensajeError += "DNI_Tutor no válida.\n";
	        }
	        
	        if (NotaTextField.getText() == null || NotaTextField.getText().length() == 0) {
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
