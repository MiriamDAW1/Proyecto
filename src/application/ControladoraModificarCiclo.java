package application;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class ControladoraModificarCiclo {
	
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
	    
	    public void setVentanaDialoge(Stage ventana) {
	        this.ventana = ventana;
	    }
	    
	    public void setCiclo(Ciclo ciclo) {
	        this.ciclo = ciclo;

	        ID_ciclo.setText(ciclo.getID_ciclo());
	        numdecurso.setText(ciclo.getNumdecurso());
	        Cicloformativo.setText(ciclo.getCicloformativo());
	        Familiaprofesional.setText(ciclo.getFamiliaprofesional());
	        Capacidadesterminales.setText(ciclo.getCapacidadesterminales());
	        Actividadesformativos.setText(ciclo.getActividadesformativos());
	        Criterioevaluación.setText(ciclo.getCriterioevaluación());
	        
	    }
		
	   

		public boolean isGuardarClicked() {
		      return guardarClicked;
		}
		
		@FXML
	    private void guardar() {
	        
	        if (datosValidos()) {
	            Conexion conexionBBDD = new Conexion();
	            try {
					conexionBBDD.ModificarCiclo(ID_ciclo.getText(), numdecurso.getText(), Cicloformativo.getText(), Familiaprofesional.getText(), Capacidadesterminales.getText(), Actividadesformativos.getText(), Criterioevaluación.getText());
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
	            mensajeError += "DNI_Alumno no válido.\n"; 
	        }
	        if (numdecurso.getText() == null || numdecurso.getText().length() == 0) {
	            mensajeError += "Nombre no válidos.\n"; 
	        }
	        if (Cicloformativo.getText() == null || Cicloformativo.getText().length() == 0) {
	            mensajeError += "Apellido no válida.\n"; 
	        }

	        if (Familiaprofesional.getText() == null || Familiaprofesional.getText().length() == 0) {
	            mensajeError += "Telefono no válido.\n"; 
	        } 

	        if (Capacidadesterminales.getText() == null || Capacidadesterminales.getText().length() == 0) {
	            mensajeError += "Provincia no válida.\n"; 
	        }

	        if (Actividadesformativos.getText() == null || Actividadesformativos.getText().length() == 0) {
	            mensajeError += "Localidad no válida.\n";
	        } 
	        
	        if (Criterioevaluación.getText() == null || Criterioevaluación.getText().length() == 0) {
	            mensajeError += "Correoelectronico no válida.\n";
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
