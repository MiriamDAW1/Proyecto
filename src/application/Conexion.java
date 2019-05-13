package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Conexion {

	private String bd;
	private String url= "";
	private String usr = "";
	private String pwd = "";
	private static String Schema = "";
	private static Connection Conexion;
	

	public Conexion()  {
		Properties propiedades = new Properties();
		InputStream entrada = null;
		try {
			File miFichero = new File("src/configuracion.ini");
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				propiedades.load(entrada);
				url = propiedades.getProperty("url");
				usr = propiedades.getProperty("usr");	
				pwd = propiedades.getProperty("pwd");
				Schema = propiedades.getProperty("Schema");
			}else 
				System.out.println("Fichero no encontrado");
		}catch (IOException ex) {
		ex.printStackTrace();
		
		}finally {
			if (entrada != null ) {
				try {
					entrada.close();
					System.out.println(url + " " + usr + " " + pwd);
					
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Conexion = DriverManager.getConnection(url, usr, pwd);
					
					if(!Conexion.isClosed()) {
						System.out.println("Conexión establecida");
						//conexion.close();
					}
					else
						System.out.println("Fallo en Conexión");	
					

				}catch (Exception e) {
					System.out.println("ERROR en conexión con ORACLE");	
					e.printStackTrace();
				}
			}
		}
		
	}


	
	public ObservableList<Alumno> Consulta() {
		
	ObservableList<Alumno> aux = FXCollections.observableArrayList();
		
		try {
			Statement stmt = Conexion.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT DNI_Alumno, Nombre, Apellido, Telefono, Provincia,  Localidad, "
			+ "Correoelectronico, Nacionalidad, DNI_Tutor, NumAlumnos, Nota FROM " + Schema + ".ALUMNO" );
			while(rset.next()) {
				String DNI_Alumno = rset.getString(1);
				String Nombre = rset.getString(2); 
				String Apellido = rset.getString(3);
				String Telefono = rset.getString(4);
				String Provincia = rset.getString(5);
				String Localidad = rset.getString(6);
				String Correoelectronico = rset.getString(7); 
				String Nacionalidad = rset.getString(8);
				String DNI_Tutor = rset.getString(9);
				String NumAlumnos = rset.getString(10);
				String Nota = rset.getString(11);
				Alumno auxAlum = new Alumno(DNI_Alumno, Nombre, Apellido, Telefono, Provincia,  Localidad, Correoelectronico, Nacionalidad, DNI_Tutor, NumAlumnos, Nota);
				aux.add(auxAlum);
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		return aux;
		
	}
	
	public static int InsertarAlumno(String DNI_Alumno, String  Nombre, String  Apellido, String  Telefono, String  Provincia,  String  Localidad, String  Correoelectronico, String  Nacionalidad, String  DNI_Tutor, String NumAlumnos, String Nota) throws SQLException{
		
		Statement stmt = Conexion.createStatement();//Introduce los datos
		
		//INSERT INTO SCHEMA.NOMBRE_TABLA VALUES ();
		System.out.println("INSERT INTO " + Schema + ".ALUMNO VALUES (" +  "'" + DNI_Alumno +  "'" + "," + "'" + Nombre  +  "'" + "," + "'" + Apellido  +  "'" + "," +  Telefono  + "," + "'" + Provincia +  "'" + "," + "'" + Localidad  + "'" + "," + "'" + Correoelectronico +  "'" + "," + "'" + Nacionalidad +  "'" + "," + "'" + DNI_Tutor + "'" +  "," +NumAlumnos+ "," +Nota + ")");
		int num = stmt.executeUpdate("INSERT INTO " + Schema + ".ALUMNO VALUES (" +  "'" + DNI_Alumno +  "'" + "," + "'" + Nombre  +  "'" + "," + "'" + Apellido  +  "'" + "," + Telefono + "," + "'" + Provincia +  "'" + "," + "'" + Localidad  + "'" + "," + "'" + Correoelectronico +  "'" + "," + "'" + Nacionalidad +  "'" + "," + "'" + DNI_Tutor+ "'"  + "," + NumAlumnos+"," + Nota + ")");
		return num;
	}
	
	public static int Modificararmario() throws SQLException{
		Statement stmt = Conexion.createStatement();
		System.out.println("UDATE MIRIAM.ARMARIO SET numarmario =3");
		int num =stmt.executeUpdate("UDATE MIRIAM.ARMARIO SET tipoarmario='XL");
		return num;
	}
	
	public ObservableList<Instituto> Consulta1() {
		
		ObservableList<Instituto> aux = FXCollections.observableArrayList();
			
			try {
				Statement stmt = Conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT ID_Instituto, NombreCentro, Profesor_Tutor, FAX, Director, NIFDirector, "
				+ "Telefono,  Direccion, Poblacion,  DAT, Ciudad, CP FROM " + Schema + ".INSTITUTO");
				while(rset.next()) {
					String ID_Instituto = rset.getString(1);
					String NombreCentro = rset.getString(2); 
					String Profesor_Tutor = rset.getString(3);
					String FAX  = rset.getString(4);
					String Director = rset.getString(5);
					String NIFDirector = rset.getString(6);
					String Telefono = rset.getString(7); 
					String Direccion = rset.getString(8);
					String Poblacion = rset.getString(9);
					String DAT = rset.getString(10);
					String Ciudad = rset.getString(11);
					String CP = rset.getString(12);
					Instituto auxInsti = new Instituto(ID_Instituto, NombreCentro, Profesor_Tutor, FAX, Director, NIFDirector, Telefono, Direccion, Poblacion, DAT, Ciudad, CP);
					aux.add(auxInsti);
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			return aux;
			
		}
	
	public static int InsertarInstituto(String ID_Instituto, String NombreCentro, String Profesor_Tutor, String FAX, String Director,
			String NIFDirector, String Telefono, String Direccion, String Poblacion, String DAT, String Ciudad,
			String CP) throws SQLException{
		
		Statement stmt = Conexion.createStatement();//Introduce los datos
		
		//INSERT INTO SCHEMA.NOMBRE_TABLA VALUES ();
		System.out.println("INSERT INTO " + Schema + ".INSTITUTO VALUES (" + ID_Instituto + "," + "'" + NombreCentro  +  "'" + "," + "'" + Profesor_Tutor  +  "'" + "," +  FAX + "," + "'" + Director +  "'" + "," + "'" + NIFDirector  + "'" + "," + Telefono + "," + "'" + Direccion +  "'" + "," + "'" + Poblacion + "'" +  "," + "'" + DAT + "'" + "," + "'" + Ciudad + "'" + ", " + CP +")");
		int num = stmt.executeUpdate("INSERT INTO " + Schema + ".INSTITUTO VALUES ("  + ID_Instituto + "," + "'" + NombreCentro  +  "'" + "," + "'" + Profesor_Tutor  +  "'" + "," +  FAX + "," + "'" + Director +  "'" + "," + "'" + NIFDirector  + "'" + "," +  Telefono + "," + "'" + Direccion +  "'" + "," + "'" + Poblacion+ "'"  + "," + "'" + DAT + "'" +"," + "'" + Ciudad + "'" + ", " + CP +")");
		return num;
	}
	

	public static PreparedStatement prepareStatement(String consultar) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}
}