
	package application;

	import javafx.collections.ObservableList;

	public class Ciclo {

		private int ID_ciclo;
		private int numdecurso;
		private String Cicloformativo;
		private String Familiaprofesional;
		private String  Capacidadesterminales;
		private String  Actividadesformativos;
		private String  Criterioevaluaci�n;
		
		private ObservableList<Ciclo> CicloData;

		public Ciclo(int iD_ciclo, int numdecurso, String cicloformativo, String familiaprofesional,
				String capacidadesterminales, String actividadesformativos, String criterioevaluaci�n) {
			super();
			ID_ciclo = iD_ciclo;
			this.numdecurso = numdecurso;
			Cicloformativo = cicloformativo;
			Familiaprofesional = familiaprofesional;
			Capacidadesterminales = capacidadesterminales;
			Actividadesformativos = actividadesformativos;
			Criterioevaluaci�n = criterioevaluaci�n;
		}

		public int getID_ciclo() {
			return ID_ciclo;
		}

		public void setID_ciclo(int iD_ciclo) {
			ID_ciclo = iD_ciclo;
		}

		public int getNumdecurso() {
			return numdecurso;
		}

		public void setNumdecurso(int numdecurso) {
			this.numdecurso = numdecurso;
		}

		public String getCicloformativo() {
			return Cicloformativo;
		}

		public void setCicloformativo(String cicloformativo) {
			Cicloformativo = cicloformativo;
		}

		public String getFamiliaprofesional() {
			return Familiaprofesional;
		}

		public void setFamiliaprofesional(String familiaprofesional) {
			Familiaprofesional = familiaprofesional;
		}

		public String getCapacidadesterminales() {
			return Capacidadesterminales;
		}

		public void setCapacidadesterminales(String capacidadesterminales) {
			Capacidadesterminales = capacidadesterminales;
		}

		public String getActividadesformativos() {
			return Actividadesformativos;
		}

		public void setActividadesformativos(String actividadesformativos) {
			Actividadesformativos = actividadesformativos;
		}

		public String getCriterioevaluaci�n() {
			return Criterioevaluaci�n;
		}

		public void setCriterioevaluaci�n(String criterioevaluaci�n) {
			Criterioevaluaci�n = criterioevaluaci�n;
		}

		public ObservableList<Ciclo> getCicloData() {
			return CicloData;
		}

		public void setCicloData(ObservableList<Ciclo> cicloData) {
			CicloData = cicloData;
		}
}
