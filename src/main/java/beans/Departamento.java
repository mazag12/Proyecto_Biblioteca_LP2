package beans;

public class Departamento extends Provincia{

	
	public String coddepartamento;
	public String nomdepartamento;
	public String codpais;
	
	public Departamento(String coddistrito, String nomdistrito, String codprovincia, String nomprovincia,String coddepartamento,String nomdepartamento) {
		super(coddistrito, nomdistrito, codprovincia, nomprovincia);
		this.coddepartamento = coddepartamento;
		this.nomdepartamento = nomdepartamento;
	}
		
	public String getCoddepartamento() {
		return coddepartamento;
	}
	public void setCoddepartamento(String coddepartamento) {
		this.coddepartamento = coddepartamento;
	}
	public String getNomdepartamento() {
		return nomdepartamento;
	}
	public void setNomdepartamento(String nomdepartamento) {
		this.nomdepartamento = nomdepartamento;
	}
	public String getCodpais() {
		return codpais;
	}
	public void setCodpais(String codpais) {
		this.codpais = codpais;
	}
	
	
}
