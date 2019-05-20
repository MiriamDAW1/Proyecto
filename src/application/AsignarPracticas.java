package application;

public class AsignarPracticas {
	
	private String ID_Convenio ;
	private String DNI_Alumno;
	private String Fechainicio;
	private String Fechafin;
	private String Horastotal;
	private String Horadia;
	private String Horatarde;
	private String Horariomanana;
	
	public AsignarPracticas(String iD_Convenio, String dNI_Alumno, String fechainicio, String fechafin,
			String horastotal, String horadia, String horatarde, String horariomanana) {
		super();
		ID_Convenio = iD_Convenio;
		DNI_Alumno = dNI_Alumno;
		Fechainicio = fechainicio;
		Fechafin = fechafin;
		Horastotal = horastotal;
		Horadia = horadia;
		Horatarde = horatarde;
		Horariomanana = horariomanana;
	}

	public String getID_Convenio() {
		return ID_Convenio;
	}

	public void setID_Convenio(String iD_Convenio) {
		ID_Convenio = iD_Convenio;
	}

	public String getDNI_Alumno() {
		return DNI_Alumno;
	}

	public void setDNI_Alumno(String dNI_Alumno) {
		DNI_Alumno = dNI_Alumno;
	}

	public String getFechainicio() {
		return Fechainicio;
	}

	public void setFechainicio(String fechainicio) {
		Fechainicio = fechainicio;
	}

	public String getFechafin() {
		return Fechafin;
	}

	public void setFechafin(String fechafin) {
		Fechafin = fechafin;
	}

	public String getHorastotal() {
		return Horastotal;
	}

	public void setHorastotal(String horastotal) {
		Horastotal = horastotal;
	}

	public String getHoradia() {
		return Horadia;
	}

	public void setHoradia(String horadia) {
		Horadia = horadia;
	}

	public String getHoratarde() {
		return Horatarde;
	}

	public void setHoratarde(String horatarde) {
		Horatarde = horatarde;
	}

	public String getHorariomanana() {
		return Horariomanana;
	}

	public void setHorariomañana(String horariomanana) {
		Horariomanana = horariomanana;
	}
}
