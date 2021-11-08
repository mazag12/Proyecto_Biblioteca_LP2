package beans;

public class Provincia extends Distrito{

	public String codprovincia;
	public String nomprovincia;
	public String coddepartamento;
	
	public Provincia(String coddistrito, String nomdistrito,String codprovincia,String nomprovincia) {
		super(coddistrito, nomdistrito);
		this.codprovincia = codprovincia;
		this.nomprovincia = nomprovincia;		
	}
	
	public String getCodprovincia() {
		return codprovincia;
	}
	public void setCodprovincia(String codprovincia) {
		this.codprovincia = codprovincia;
	}
	public String getNomprovincia() {
		return nomprovincia;
	}
	public void setNomprovincia(String nomprovincia) {
		this.nomprovincia = nomprovincia;
	}
	public String getCoddepartamento() {
		return coddepartamento;
	}
	public void setCoddepartamento(String coddepartamento) {
		this.coddepartamento = coddepartamento;
	}
	
	
}
