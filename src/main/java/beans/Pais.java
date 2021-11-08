package beans;

public class Pais extends Departamento{
  
	
	public String codpais;
	public String nompais;
	
	public Pais(String coddistrito, String nomdistrito, String codprovincia, String nomprovincia,
			String coddepartamento, String nomdepartamento,String codpais, String nompais) {
		super(coddistrito, nomdistrito, codprovincia, nomprovincia, coddepartamento, nomdepartamento);
		this.codpais = codpais;
		this.nompais = nompais;
	}
	
	public String getNompais() {
		return nompais;
	}
	public void setNompais(String nompais) {
		this.nompais = nompais;
	}
	public String getCodpais() {
		return codpais;
	}
	public void setCodpais(String codpais) {
		this.codpais = codpais;
	}
	
	
}
