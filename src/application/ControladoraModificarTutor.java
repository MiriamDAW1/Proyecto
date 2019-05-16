package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraModificarTutor {
	
	@FXML
	private Button GUARDARCAMBIOS;
	
	@FXML
	private Button CANCELAR;
	
	@FXML
    private TextField DNI_TutorTextField;
	
	@FXML
    private TextField TelefonoTextField;
	
	@FXML
    private TextField NacionalidadTextField;
	
	@FXML
    private TextField ApellidoTextField;

	@FXML
    private TextField NombreTextField;
	
	@FXML
    private TextField ProvinciaTextField;
	
	@FXML
    private TextField LocalidadTextField;
	
	@FXML
    private TextField Correo_electronicoTextField;
	
	@FXML
    private TextField ID_ConvenioTextField;
	
	private Stage ventana;
	private Tutor_empresa Tutor_empresa;
    private boolean guardarClicked = false;
    
    @FXML
    private void initialize() {
    }
    
    public void setVentanaDialoge(Stage ventana) {
        this.ventana = ventana;
    }
    
    public void setTutor(Tutor_empresa Tutor_empresa) {
        this.Tutor_empresa = Tutor_empresa;

        DNI_TutorTextField.setText(Tutor_empresa.getDNI_Tutor());
        TelefonoTextField.setText(Tutor_empresa.getTelefono());
        NacionalidadTextField.setText(Tutor_empresa.getNacionalidad());
        ApellidoTextField.setText(Tutor_empresa.getApellido());
        NombreTextField.setText(Tutor_empresa.getNombre());
        ProvinciaTextField.setText(Tutor_empresa.getProvincia());
        LocalidadTextField.setText(Tutor_empresa.getLocalidad());
        Correo_electronicoTextField.setText(Tutor_empresa.getCorreo_electronico());
        ID_ConvenioTextField.setText(Tutor_empresa.getID_Convenio());
        
    }
	
   

	public boolean isGuardarClicked() {
	      return guardarClicked;
	}
	
	@FXML
    private void guardar() {
        
        if (datosValidos()) {
            Conexion conexionBBDD = new Conexion();
            try {
				conexionBBDD.ModificarTutor(DNI_TutorTextField.getText(), TelefonoTextField.getText(), NacionalidadTextField.getText(), ApellidoTextField.getText(), NombreTextField.getText(), ProvinciaTextField.getText(), LocalidadTextField.getText(), Correo_electronicoTextField.getText(), ID_ConvenioTextField.getText());
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
        if (DNI_TutorTextField.getText() == null || DNI_TutorTextField.getText().length() == 0) {
            mensajeError += "DNI_Alumno no válido.\n"; 
        }
        if (TelefonoTextField.getText() == null || TelefonoTextField.getText().length() == 0) {
            mensajeError += "Nombre no válidos.\n"; 
        }
        if (NacionalidadTextField.getText() == null || NacionalidadTextField.getText().length() == 0) {
            mensajeError += "Apellido no válida.\n"; 
        }

        if (ApellidoTextField.getText() == null || ApellidoTextField.getText().length() == 0) {
            mensajeError += "Telefono no válido.\n"; 
        } 

        if (NombreTextField.getText() == null || NombreTextField.getText().length() == 0) {
            mensajeError += "Provincia no válida.\n"; 
        }

        if (ProvinciaTextField.getText() == null || ProvinciaTextField.getText().length() == 0) {
            mensajeError += "Localidad no válida.\n";
        } 
        
        if (LocalidadTextField.getText() == null || LocalidadTextField.getText().length() == 0) {
            mensajeError += "Correoelectronico no válida.\n";
        } 
        
        if (Correo_electronicoTextField.getText() == null ||Correo_electronicoTextField.getText().length() == 0) {
            mensajeError += "Nacionalidad no válida.\n";
        } 
        
        if (ID_ConvenioTextField.getText() == null || ID_ConvenioTextField.getText().length() == 0) {
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
