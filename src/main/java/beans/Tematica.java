package beans;
//@marco
public class Tematica {
	
	public String CodTematica;
	public String NomTematica;
	
	public Tematica(String codTematica, String nomTematica) {
		super();
		CodTematica = codTematica;
		NomTematica = nomTematica;
	}

	public String getCodTematica() {
		return CodTematica;
	}

	public void setCodTematica(String codTematica) {
		CodTematica = codTematica;
	}

	public String getNomTematica() {
		return NomTematica;
	}

	public void setNomTematica(String nomTematica) {
		NomTematica = nomTematica;
	}
	
	

}
