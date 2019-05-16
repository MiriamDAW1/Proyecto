package application;

public class Tutor_empresa {
	
	private String  DNI_Tutor;
	private String Telefono; 
	private String Nacionalidad;
	private String  Apellido;
	private String  Nombre;
	private String Provincia;
	private String Localidad ; 
	private String  Correo_electronico;
	private String ID_Convenio;
	
	public Tutor_empresa(String dNI_Tutor, String telefono, String nacionalidad, String apellido, String nombre,
			String provincia, String localidad, String correo_electronico, String iD_Convenio) {
		super();
		DNI_Tutor = dNI_Tutor;
		Telefono = telefono;
		Nacionalidad = nacionalidad;
		Apellido = apellido;
		Nombre = nombre;
		Provincia = provincia;
		Localidad = localidad;
		Correo_electronico = correo_electronico;
		ID_Convenio = iD_Convenio;
	}

	public String getDNI_Tutor() {
		return DNI_Tutor;
	}

	public void setDNI_Tutor(String dNI_Tutor) {
		DNI_Tutor = dNI_Tutor;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getNacionalidad() {
		return Nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
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

	public String getCorreo_electronico() {
		return Correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		Correo_electronico = correo_electronico;
	}

	public String getID_Convenio() {
		return ID_Convenio;
	}

	public void setID_Convenio(String iD_Convenio) {
		ID_Convenio = iD_Convenio;
	}	
}
