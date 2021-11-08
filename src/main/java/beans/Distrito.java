package beans;

public class Distrito {

	public String coddistrito;
	public String nomdistrito;
	public String codprovincia;
	
	public Distrito(String coddistrito, String nomdistrito) {
		super();
		this.coddistrito = coddistrito;
		this.nomdistrito = nomdistrito;
	}
		
	public String getCoddistrito() {
		return coddistrito;
	}
	public void setCoddistrito(String coddistrito) {
		this.coddistrito = coddistrito;
	}
	public String getNomdistrito() {
		return nomdistrito;
	}
	public void setNomdistrito(String nomdistrito) {
		this.nomdistrito = nomdistrito;
	}
	public String getCodprovincia() {
		return codprovincia;
	}
	public void setCodprovincia(String codprovincia) {
		this.codprovincia = codprovincia;
	}
	
	
}
