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
	private TableColumn<Ciclo,String>  Criterioevaluaci�n;
		
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
	        Criterioevaluaci�n.setText(ciclo.getCriterioevaluaci�n());
	        
	    }
		
	   

		public boolean isGuardarClicked() {
		      return guardarClicked;
		}
		
		@FXML
	    private void guardar() {
	        
	        if (datosValidos()) {
	            Conexion conexionBBDD = new Conexion();
	            try {
					conexionBBDD.ModificarCiclo(ID_ciclo.getText(), numdecurso.getText(), Cicloformativo.getText(), Familiaprofesional.getText(), Capacidadesterminales.getText(), Actividadesformativos.getText(), Criterioevaluaci�n.getText());
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
	        if (ID_ciclo.getText() == null || ID_ciclo.getText().length() == 0) {
	            mensajeError += "DNI_Alumno no v�lido.\n"; 
	        }
	        if (numdecurso.getText() == null || numdecurso.getText().length() == 0) {
	            mensajeError += "Nombre no v�lidos.\n"; 
	        }
	        if (Cicloformativo.getText() == null || Cicloformativo.getText().length() == 0) {
	            mensajeError += "Apellido no v�lida.\n"; 
	        }

	        if (Familiaprofesional.getText() == null || Familiaprofesional.getText().length() == 0) {
	            mensajeError += "Telefono no v�lido.\n"; 
	        } 

	        if (Capacidadesterminales.getText() == null || Capacidadesterminales.getText().length() == 0) {
	            mensajeError += "Provincia no v�lida.\n"; 
	        }

	        if (Actividadesformativos.getText() == null || Actividadesformativos.getText().length() == 0) {
	            mensajeError += "Localidad no v�lida.\n";
	        } 
	        
	        if (Criterioevaluaci�n.getText() == null || Criterioevaluaci�n.getText().length() == 0) {
	            mensajeError += "Correoelectronico no v�lida.\n";
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
