package beans;
/*@marco antonio*/
public class Autor {

	
	public String Codautor;
	public String Nomautor;
	
	public Autor(String codautor, String nomautor) {
		super();
		Codautor = codautor;
		Nomautor = nomautor;
	}
	
	public String getCodautor() {
		return Codautor;
	}
	public void setCodautor(String codautor) {
		Codautor = codautor;
	}
	public String getNomautor() {
		return Nomautor;
	}
	public void setNomautor(String nomautor) {
		Nomautor = nomautor;
	}
	
}
