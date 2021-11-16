package beans;
//@marco
public class Editorial {
		
	
	public String CodEditorial;
	public String NomEditorial;
	
	public Editorial(String codEditorial, String nomEditorial) {
		super();
		CodEditorial = codEditorial;
		NomEditorial = nomEditorial;
	}
	
	public String getCodEditorial() {
		return CodEditorial;
	}
	public void setCodEditorial(String codEditorial) {
		CodEditorial = codEditorial;
	}
	public String getNomEditorial() {
		return NomEditorial;
	}
	public void setNomEditorial(String nomEditorial) {
		NomEditorial = nomEditorial;
	}
	
	
	
}
