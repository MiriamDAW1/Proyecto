package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladoraModificarInstituto {
	
	@FXML
	private Button GUARDARCAMBIOS;
	
	@FXML
	private Button CANCELAR;
	
	@FXML
    private TextField ID_institutoTextField;
	
	@FXML
    private TextField  NombreCentroTextField;
	
	@FXML
    private TextField Profesor_TutorTextField;
	
	@FXML
    private TextField FAXTextField;
	
	@FXML
    private TextField DirectorTextField;
	
	@FXML
    private TextField NIFDirectorTextField;
	
	@FXML
    private TextField TelefonoTextField;
	
	@FXML
    private TextField DireccionTextField;
	
	@FXML
    private TextField PoblacionTextField;
	
	@FXML
    private TextField DATTextField;
	
	@FXML
    private TextField CiudadTextField;
	
	@FXML
    private TextField CPTextField;
	
	private Stage ventana;
	private Instituto instituto; 
    private boolean GUARDARCAMBIOSClicked = false;
    
    @FXML
    private void initialize() {
    }
    
    public void setVentanaDialoge(Stage ventana) {
        this.ventana = ventana;
    }
    
    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;

        ID_institutoTextField.setText(instituto.getID_Instituto());
        NombreCentroTextField.setText(instituto.getNombreCentro());
        Profesor_TutorTextField.setText(instituto.getProfesor_Tutor());
        FAXTextField.setText(instituto.getFAX());
        DirectorTextField.setText(instituto.getDirector());
        NIFDirectorTextField.setText(instituto.getNIFDirector());
        TelefonoTextField.setText(instituto.getTelefono());
        DireccionTextField.setText(instituto.getDireccion());
        PoblacionTextField.setText(instituto.getPoblacion());
        DATTextField.setText(instituto.getDAT());
        CiudadTextField.setText(instituto.getCiudad());
        CPTextField.setText(instituto.getCP());
        
    }
	
	public boolean isGuardarClicked() {
	      return GUARDARCAMBIOSClicked;
	}
	
	@FXML
    private void guardar() {
        
        if (datosValidos()) {
            
            Conexion conexionBBDD = new Conexion();
            try {
				conexionBBDD.ModificarInstituto(ID_institutoTextField.getText(), NombreCentroTextField.getText(), Profesor_TutorTextField.getText(), FAXTextField.getText(), DirectorTextField.getText(), NIFDirectorTextField.getText(), TelefonoTextField.getText(), DireccionTextField.getText(), PoblacionTextField.getText(), DATTextField.getText(), CiudadTextField.getText(), CPTextField.getText());
			} catch (SQLException e) {
				// TODO Bloque catch generado automáticamente
				e.printStackTrace();
			}
 	       
            GUARDARCAMBIOSClicked = true; //Cambio valor booleano
            ventana.close(); //Cierro el escenario de edición
            
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
        if (ID_institutoTextField.getText() == null || ID_institutoTextField.getText().length() == 0) {
            mensajeError += "ID_Instituto no válido.\n"; 
        }
        if ( NombreCentroTextField.getText() == null ||  NombreCentroTextField.getText().length() == 0) {
            mensajeError += "NombreCentro no válidos.\n"; 
        }
        if (Profesor_TutorTextField.getText() == null || Profesor_TutorTextField.getText().length() == 0) {
            mensajeError += "Profesor_Tutor no válida.\n"; 
        }

        if (FAXTextField.getText() == null ||  FAXTextField.getText().length() == 0) {
            mensajeError += "FAX no válido.\n"; 
        } 

        if ( DirectorTextField.getText() == null ||  DirectorTextField.getText().length() == 0) {
            mensajeError += "Director no válida.\n"; 
        }

        if ( NIFDirectorTextField.getText() == null ||  NIFDirectorTextField.getText().length() == 0) {
            mensajeError += "NIFDirector no válida.\n";
        } 
        
        if (TelefonoTextField.getText() == null || TelefonoTextField.getText().length() == 0) {
            mensajeError += "Telefono no válida.\n";
        } 
        
        if ( DireccionTextField.getText() == null || DireccionTextField.getText().length() == 0) {
            mensajeError += "Dirección no válida.\n";
        } 
        if (PoblacionTextField.getText() == null || PoblacionTextField.getText().length() == 0) {
            mensajeError += "Poblacion no válida.\n";
        } 
        if (DATTextField.getText() == null || DATTextField.getText().length() == 0) {
            mensajeError += "DAT no válida.\n";
        } 
        if (CiudadTextField.getText() == null || CiudadTextField.getText().length() == 0) {
            mensajeError += "Ciudad no válida.\n";
        } 
        if (CPTextField.getText() == null || CPTextField.getText().length() == 0) {
            mensajeError += "CP no válida.\n";
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
