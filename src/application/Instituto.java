package application;

public class Instituto {
	
	private String ID_Instituto;
	private String NombreCentro; 
	private String Profesor_Tutor;
	private String FAX;
	private String Director;
	private String NIFDirector;
	private String Telefono;
	private String Direccion;
	private String Poblacion;
	private String DAT; 
	private String Ciudad;
	private String CP;
	
	public Instituto(String iD_Instituto, String nombreCentro, String profesor_Tutor, String fAX, String director,
			String nIFDirector, String telefono, String direccion, String poblacion, String dAT, String ciudad,
			String cP) {
		
		ID_Instituto = iD_Instituto;
		NombreCentro = nombreCentro;
		Profesor_Tutor = profesor_Tutor;
		FAX = fAX;
		Director = director;
		NIFDirector = nIFDirector;
		Telefono = telefono;
		Direccion = direccion;
		Poblacion = poblacion;
		DAT = dAT;
		Ciudad = ciudad;
		CP = cP;
	}

	public String getID_Instituto() {
		return ID_Instituto;
	}

	public void setID_Instituto(String iD_Instituto) {
		ID_Instituto = iD_Instituto;
	}

	public String getNombreCentro() {
		return NombreCentro;
	}

	public void setNombreCentro(String nombreCentro) {
		NombreCentro = nombreCentro;
	}

	public String getProfesor_Tutor() {
		return Profesor_Tutor;
	}

	public void setProfesor_Tutor(String profesor_Tutor) {
		Profesor_Tutor = profesor_Tutor;
	}

	public String getFAX() {
		return FAX;
	}

	public void setFAX(String fAX) {
		FAX = fAX;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		Director = director;
	}

	public String getNIFDirector() {
		return NIFDirector;
	}

	public void setNIFDirector(String nIFDirector) {
		NIFDirector = nIFDirector;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getPoblacion() {
		return Poblacion;
	}

	public void setPoblacion(String poblacion) {
		Poblacion = poblacion;
	}

	public String getDAT() {
		return DAT;
	}

	public void setDAT(String dAT) {
		DAT = dAT;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getCP() {
		return CP;
	}

	public void setCP(String cP) {
		CP = cP;
	}

	public static void remove(int posicionInstituto) {
		// TODO Apéndice de método generado automáticamente
		
	}
}