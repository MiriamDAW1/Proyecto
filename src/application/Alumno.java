package application;

import java.util.List;

import javafx.collections.ObservableList;

public class Alumno {
	
	private String DNI_Alumno;
	private String Nombre; 
	private String Apellido;
	private String Telefono;
	private String Provincia;
	private String Localidad;
	private String Correoelectronico; 
	private String Nacionalidad;
	private String DNI_Tutor;
	private String NumAlumnos;
	private String Nota;
	
	public Alumno(String dNI_Alumno, String nombre, String apellido, String telefono, String provincia,
			String localidad, String correoelectronico, String nacionalidad, String dNI_Tutor, String numAlumnos,
			String nota) {
		super();
		DNI_Alumno = dNI_Alumno;
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
		Provincia = provincia;
		Localidad = localidad;
		Correoelectronico = correoelectronico;
		Nacionalidad = nacionalidad;
		DNI_Tutor = dNI_Tutor;
		NumAlumnos = numAlumnos;
		Nota = nota;
	}

	public String getDNI_Alumno() {
		return DNI_Alumno;
	}

	public void setDNI_Alumno(String dNI_Alumno) {
		DNI_Alumno = dNI_Alumno;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getCorreoelectronico() {
		return Correoelectronico;
	}

	public void setCorreoelectronico(String correoelectronico) {
		Correoelectronico = correoelectronico;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String getDNI_Tutor() {
		return DNI_Tutor;
	}

	public void setDNI_Tutor(String dNI_Tutor) {
		DNI_Tutor = dNI_Tutor;
	}

	public String getNumAlumnos() {
		return NumAlumnos;
	}

	public void setNumAlumno(String numAlumnos) {
		NumAlumnos = numAlumnos;
	}

	public String getNota() {
		return Nota;
	}

	public void setNota(String nota) {
		Nota = nota;
	}

	public static ObservableList<Alumno> getAlumnoData() {
		// TODO Apéndice de método generado automáticamente
		return null;
	}
}
