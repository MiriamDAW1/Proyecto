package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
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
	
	public static int ModificarAlumno(String DNI_Alumno, String  Nombre, String  Apellido, String  Telefono, String  Provincia,  String  Localidad, String  Correoelectronico, String  Nacionalidad, String  DNI_Tutor, String NumAlumnos, String Nota) throws SQLException{
		Statement stmt = Conexion.createStatement();
		System.out.println("UPDATE " + Schema + " .ALUMNO SET DNI_Alumno=" + "'" + DNI_Alumno + "'" + "," + "Nombre=" +  "'" + Nombre + "'" + "," +  "Apellido="  +  "'" + Apellido + "'" + "," + "Telefono="  +  "'" + Telefono  +  "'"  + "," + "Provincia="  +  "'" + Provincia  +  "'" + "," + "Localidad="  +  "'" + Localidad  +  "'" + "," + "Correoelectronico="  +  "'" + Correoelectronico  +  "'" + "," + "Nacionalidad="  +  "'" + Nacionalidad  +  "'" + "," + "DNI_Tutor="  +  "'" + DNI_Tutor  +  "'" + "," + "NumAlumnos="  +  "'" + NumAlumnos  +  "'" + "," + "Nota=" +  "'" + Nota  +  "'" + "WHERE DNI_Alumno=" + "'" + DNI_Alumno + "'");
		int num =stmt.executeUpdate("UPDATE " + Schema + " .ALUMNO SET DNI_Alumno=" + "'" + DNI_Alumno + "'" + "," + "Nombre=" +  "'" + Nombre + "'" + "," +  "Apellido="  +  "'" + Apellido + "'" + "," + "Telefono="  +  "'" + Telefono  +  "'"  + "," + "Provincia="  +  "'" + Provincia  +  "'" + "," + "Localidad="  +  "'" + Localidad  +  "'" + "," + "Correoelectronico="  +  "'" + Correoelectronico  +  "'" + "," + "Nacionalidad="  +  "'" + Nacionalidad  +  "'" + "," + "DNI_Tutor="  +  "'" + DNI_Tutor  +  "'" + "," + "NumAlumnos="  +  "'" + NumAlumnos  +  "'" + "," + "Nota=" +  "'" + Nota  +  "'" + "WHERE DNI_Alumno=" + "'" + DNI_Alumno + "'");
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
	
	public static int ModificarInstituto(String iD_Instituto, String nombreCentro, String profesor_Tutor, String fAX, String director,
			String nIFDirector, String telefono, String direccion, String poblacion, String dAT, String ciudad,
			String cP) throws SQLException{
		Statement stmt = Conexion.createStatement();
		System.out.println("UPDATE " + Schema + " .INSTITUTO SET ID_Instituto=" + iD_Instituto + "," + "NombreCentro=" +  "'" + nombreCentro + "'" + "," +  "Profesor_Tutor="  +  "'" + profesor_Tutor + "'" + "," + "FAX=" + fAX + "," + "Director="  +  "'" + director  +  "'" + "," + "NIFDirector="  +  "'" + nIFDirector  +  "'" + "," + "Telefono=" + telefono  + "," + "Direccion="  +  "'" + direccion  +  "'" + "," + "Poblacion="  +  "'" + poblacion  +  "'" + "," + "DAT="  +  "'" + dAT  +  "'" + "," + "Ciudad=" +  "'" + ciudad  +  "'" + "," + "CP=" + cP  + " WHERE ID_Instituto="+ iD_Instituto);
		int num =stmt.executeUpdate("UPDATE " + Schema + " .INSTITUTO SET ID_Instituto=" + iD_Instituto + "," + "NombreCentro=" +  "'" + nombreCentro + "'" + "," +  "Profesor_Tutor="  +  "'" + profesor_Tutor + "'" + "," + "FAX=" + fAX + "," + "Director="  +  "'" + director  +  "'" + "," + "NIFDirector="  +  "'" + nIFDirector  +  "'" + "," + "Telefono=" + telefono  + "," + "Direccion="  +  "'" + direccion  +  "'" + "," + "Poblacion="  +  "'" + poblacion  +  "'" + "," + "DAT="  +  "'" + dAT  +  "'" + "," + "Ciudad=" +  "'" + ciudad  +  "'" + "," + "CP=" + cP  + " WHERE ID_Instituto=" + iD_Instituto );
		return num;
	}

	public ObservableList<Ciclo> Consulta2() {
		
		ObservableList<Ciclo> aux = FXCollections.observableArrayList();
			
			try {
				Statement stmt = Conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT ID_ciclo, numdecurso,  Cicloformativo, Familiaprofesional, Capacidadesterminales, Actividadesformativos, "
				+ "Criterioevaluacion FROM " + Schema + ".CICLO");
				while(rset.next()) {
					String ID_ciclo  = rset.getString(1);
					String numdecurso = rset.getString(2); 
					String Cicloformativo = rset.getString(3);
					String Familiaprofesional  = rset.getString(4);
					String Capacidadesterminales = rset.getString(5);
					String Actividadesformativos = rset.getString(6);
					String Criterioevaluacion = rset.getString(7); 
					Ciclo auxCiclo = new Ciclo(ID_ciclo, numdecurso,Cicloformativo,Familiaprofesional,Capacidadesterminales,Actividadesformativos,Criterioevaluacion);
					aux.add(auxCiclo);
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			return aux;
			
		}
	public static int InsertarCiclo(String iD_ciclo, String numdecurso, String cicloformativo, String familiaprofesional,
			String capacidadesterminales, String actividadesformativos, String criterioevaluacion) throws SQLException{
	
		Statement stmt = Conexion.createStatement();//Introduce los datos
	
		//INSERT INTO SCHEMA.NOMBRE_TABLA VALUES ();
		System.out.println("INSERT INTO " + Schema + ".CICLO VALUES (" + iD_ciclo + ","  + numdecurso  + "," + "'" + cicloformativo  +  "'" + "," + "'" + familiaprofesional + "'" + "," + "'" + capacidadesterminales +  "'" + "," + "'" + actividadesformativos  + "'" + "," +  "'" + criterioevaluacion + "'" + ")");
		int num = stmt.executeUpdate("INSERT INTO " + Schema + ".CICLO VALUES (" + iD_ciclo + ","  + numdecurso  + "," + "'" + cicloformativo  +  "'" + "," + "'" + familiaprofesional + "'" + "," + "'" + capacidadesterminales +  "'" + "," + "'" + actividadesformativos  + "'" + "," +  "'" + criterioevaluacion + "'" + ")");
		return num;
	}

	public static int ModificarCiclo(String iD_ciclo, String numdecurso, String cicloformativo, String familiaprofesional,
			String capacidadesterminales, String actividadesformativos, String criterioevaluacion) throws SQLException{
		Statement stmt = Conexion.createStatement();
		System.out.println("UPDATE " + Schema + " .CICLO SET ID_ciclo=" + iD_ciclo + "," + "numdecurso=" + numdecurso +  "," +  "cicloformativo="  +  "'" + cicloformativo + "'" + "," + "familiaprofesional=" + "'" + familiaprofesional + "'" + "," + "capacidadesterminales="  +  "'" + capacidadesterminales  +  "'" + "," + "actividadesformativos="  +  "'" + actividadesformativos  +  "'" + "," + "criterioevaluacion=" + "'" + criterioevaluacion + "'" + " WHERE ID_ciclo="+ iD_ciclo);
		int num =stmt.executeUpdate("UPDATE " + Schema + " .CICLO SET ID_ciclo=" + iD_ciclo + "," + "numdecurso=" + numdecurso +  "," +  "cicloformativo="  +  "'" + cicloformativo + "'" + "," + "familiaprofesional=" + "'" + familiaprofesional + "'" + "," + "capacidadesterminales="  +  "'" + capacidadesterminales  +  "'" + "," + "actividadesformativos="  +  "'" + actividadesformativos  +  "'" + "," + "criterioevaluacion=" + "'" + criterioevaluacion + "'" + " WHERE ID_ciclo="+ iD_ciclo);
		return num;
	}
	
	public ObservableList<Empresa> Consulta3() {
		
		ObservableList<Empresa> aux = FXCollections.observableArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			try {
				Statement stmt = Conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT  ID_Convenio, Nombre,  Provincia, CIF, Pais, Ciudad, "
				+ " Direccion,CP,Telefono,Fax,Fecha_firma FROM " + Schema + ".empresa");
				while(rset.next()) {
					String ID_Convenio = rset.getString(1);
					String Nombre = rset.getString(2); 
					String Provincia = rset.getString(3);
					String CIF  = rset.getString(4);
					String Pais = rset.getString(5);
					String Ciudad = rset.getString(6);
					String Direccion = rset.getString(7); 
					String CP = rset.getString(8); 
					String Telefono = rset.getString(9); 
					String Fax = rset.getString(10);
					//String Fecha_firma = sdf.format(rset.getDate(11));
					String Fecha_firma = "02/03/2017";
					Empresa auxempresa = new Empresa(ID_Convenio, Nombre,Provincia,CIF,Pais,Ciudad,Direccion,CP,Telefono,Fax,Fecha_firma);
					aux.add(auxempresa);
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			return aux;
		}

	public static int InsertarEmpresa(String iD_Convenio, String nombre, String provincia, String cIF, String pais, String ciudad,
			String direccion, String cP, String telefono, String fax, String fecha_firma) throws SQLException{

	Statement stmt = Conexion.createStatement();//Introduce los datos

	//INSERT INTO SCHEMA.NOMBRE_TABLA VALUES ();
	System.out.println("INSERT INTO " + Schema + ".empresa VALUES (" + iD_Convenio + "," + "'" + nombre  +  "'" + "," + "'" + provincia  +  "'" + "," +  "'" + cIF + "'" + "," + "'" + pais +  "'" + "," + "'" + ciudad  + "'" + "," + "'" + direccion +  "'" + "," + cP  + "," + telefono + "," + "'" + fax + "'" + "," + fecha_firma +")");
	int num = stmt.executeUpdate("INSERT INTO " + Schema + ".empresa VALUES (" + iD_Convenio + "," + "'" + nombre  +  "'" + "," + "'" + provincia  +  "'" + "," +  "'" + cIF + "'" + "," + "'" + pais +  "'" + "," + "'" + ciudad  + "'" + "," + "'" + direccion +  "'" + "," + cP  + "," + telefono + "," + "'" + fax + "'" + "," + fecha_firma +")");
	return num;
	}

	public static int ModificarEmpresa(String iD_Convenio, String nombre, String provincia, String cIF, String pais, String ciudad,
			String direccion, String cP, String telefono, String fax, String fecha_firma) throws SQLException{
	Statement stmt = Conexion.createStatement();
	System.out.println("UPDATE " + Schema + " .empresa SET iD_Convenio=" + iD_Convenio + "," + "nombre=" +  "'" + nombre + "'" + "," +  "provincia="  +  "'" + provincia + "'" + "," + "cIF=" + "'" + cIF + "'" + "," + "pais="  +  "'" + pais  +  "'" + "," + "ciudad="  +  "'" + ciudad  +  "'" + "," + "direccion=" + "'" + direccion + "'" + "," + "cP=" + cP  + "," + "telefono=" + telefono  + "," + "fax=" + fax  + "," + "fecha_firma=" + "'" + fecha_firma + "'" + " WHERE iD_Convenio="+ iD_Convenio);
	int num =stmt.executeUpdate("UPDATE " + Schema + " .empresa SET iD_Convenio=" + iD_Convenio + "," + "nombre=" +  "'" + nombre + "'" + "," +  "provincia="  +  "'" + provincia + "'" + "," + "cIF=" + "'" + cIF + "'" + "," + "pais="  +  "'" + pais  +  "'" + "," + "ciudad="  +  "'" + ciudad  +  "'" + "," + "direccion=" + "'" + direccion + "'" + "," + "cP=" + cP  + "," + "telefono=" + telefono  + "," + "fax=" + fax  + "," + "fecha_firma=" + "'" + fecha_firma + "'" + " WHERE iD_Convenio="+ iD_Convenio);
	return num;
	}
	
	public ObservableList<Tutor_empresa> Consulta4() {
		
		ObservableList<Tutor_empresa> aux = FXCollections.observableArrayList();
			
			try {
				Statement stmt = Conexion.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT DNI_Tutor, Telefono, Nacionalidad, Apellido, Nombre, Provincia, "
				+ "Localidad, Correo_electronico, ID_Convenio FROM " + Schema + ".TUTOR_EMPRESA");
				while(rset.next()) {
					String DNI_Tutor  = rset.getString(1);
					String Telefono = rset.getString(2); 
					String Nacionalidad = rset.getString(3);
					String Apellido  = rset.getString(4);
					String Nombre = rset.getString(5);
					String Provincia = rset.getString(6);
					String Localidad = rset.getString(7); 
					String Correo_electronico = rset.getString(8); 
					String ID_Convenio = rset.getString(9); 
					Tutor_empresa auxTutor = new Tutor_empresa(DNI_Tutor, Telefono,Nacionalidad,Apellido,Nombre,Provincia,Localidad,Correo_electronico,ID_Convenio);
					aux.add(auxTutor);
				}
				rset.close();
				stmt.close();
				
			}catch (SQLException s){
				s.printStackTrace();
			}
			return aux;
			
		}
	
	public static int InsertarTutor(String dNI_Tutor, String telefono, String nacionalidad, String apellido, String nombre,
			String provincia, String localidad, String correo_electronico, String iD_Convenio) throws SQLException{
	
		Statement stmt = Conexion.createStatement();//Introduce los datos
	
		//INSERT INTO SCHEMA.NOMBRE_TABLA VALUES ();
		System.out.println("INSERT INTO " + Schema + ".TUTOR_EMPRESA VALUES (" + dNI_Tutor + "," + "'" + telefono  +  "'" + "," + "'" + nacionalidad  +  "'" + "," +  apellido + "," + "'" + nombre +  "'" + "," + "'" + provincia  + "'" + "," + localidad +  "'" + correo_electronico  + "'" + "," +"'" + iD_Convenio  + "'" + ")");
		int num = stmt.executeUpdate("INSERT INTO " + Schema + ".TUTOR_EMPRESA VALUES (" + dNI_Tutor + "," + "'" + telefono  +  "'" + "," + "'" + nacionalidad  +  "'" + "," +  apellido + "," + "'" + nombre +  "'" + "," + "'" + provincia  + "'" + "," + localidad +  "'" + correo_electronico  + "'" + "," +"'" + iD_Convenio  + "'" + ")");
		return num;
	}

	public static int ModificarTutor(String dNI_Tutor, String telefono, String nacionalidad, String apellido, String nombre,
			String provincia, String localidad, String correo_electronico, String iD_Convenio) throws SQLException{
		Statement stmt = Conexion.createStatement();
		System.out.println("UPDATE " + Schema + " .TUTOR_EMPRESA SET dNI_Tutor=" + dNI_Tutor + "," + "telefono=" +  "'" + telefono + "'" + "," +  "nacionalidad="  +  "'" + nacionalidad + "'" + "," + "apellido=" + apellido + "," + "nombre="  +  "'" + nombre  +  "'" + "," + "provincia="  +  "'" + provincia  +  "'" + "," + "localidad=" +  "'" + localidad +  "'" + "," + "correo_electronico=" +  "'" + correo_electronico +  "'" +"iD_Convenio=" +  "'" + iD_Convenio +  "'" + " WHERE dNI_Tutor="+ dNI_Tutor);
		int num =stmt.executeUpdate("UPDATE " + Schema + " .TUTOR_EMPRESA SET dNI_Tutor=" + dNI_Tutor + "," + "telefono=" +  "'" + telefono + "'" + "," +  "nacionalidad="  +  "'" + nacionalidad + "'" + "," + "apellido=" + apellido + "," + "nombre="  +  "'" + nombre  +  "'" + "," + "provincia="  +  "'" + provincia  +  "'" + "," + "localidad=" +  "'" + localidad +  "'" + "," + "correo_electronico=" +  "'" + correo_electronico +  "'" +"iD_Convenio=" +  "'" + iD_Convenio +  "'" + " WHERE dNI_Tutor="+ dNI_Tutor);
		return num;
	}
}