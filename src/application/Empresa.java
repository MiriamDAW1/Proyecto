package application;

public class Empresa {

	private String  ID_Convenio;
	private String Nombre; 
	private String Provincia;
	private String  CIF;
	private String  Pais;
	private String Ciudad;
	private String Direccion; 
	private String  CP;
	private String Telefono;
	private String Fax;
	private String Fecha_firma;
	
	public Empresa(String iD_Convenio, String nombre, String provincia, String cIF, String pais, String ciudad,
			String direccion, String cP, String telefono, String fax, String fecha_firma) {
		super();
		ID_Convenio = iD_Convenio;
		Nombre = nombre;
		Provincia = provincia;
		CIF = cIF;
		Pais = pais;
		Ciudad = ciudad;
		Direccion = direccion;
		CP = cP;
		Telefono = telefono;
		Fax = fax;
		Fecha_firma = fecha_firma;
	}

	
	public String getID_Convenio() {
		return ID_Convenio;
	}

	public void setID_Convenio(String iD_Convenio) {
		ID_Convenio = iD_Convenio;
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

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getFax() {
		return Fax;
	}

	public void setFax(String fax) {
		Fax = fax;
	}

	public String getFecha_firma() {
		return Fecha_firma;
	}

	public void setFecha_firma(String fecha_firma) {
		Fecha_firma = fecha_firma;
	}
}

