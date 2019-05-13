package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Ventana Principal");

			 // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("pantalla_principal.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
           } catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	public void Controladora2() {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Ventana Secundaria");
			 // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("pantalla_2.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
           } catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ControladoraTablaAlumno() {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Alumno");
			 // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("pantalla_3_tabla_alumno.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
           } catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ControladoraTablaInstituto() {
		try {
			this.primaryStage = primaryStage;
			this.primaryStage.setTitle("Instituto");
			 // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("pantalla_tabla_instituto.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
           } catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean Modificar(Alumno Alumno) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("pantalla_4_modificar_alumno.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Contacto");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ControladoraModificarAlumno controller = loader.getController();
            controller.setVentanaDialoge(dialogStage);
            controller.setAlumno(Alumno);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isGuardarClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
	
}
