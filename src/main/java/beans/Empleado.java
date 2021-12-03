package beans;

public class Empleado {
	
	
	public String codigoemple;
	public String codperson;
	public String codcargo;
	
	
	
	public Empleado(String codigoemple, String codperson, String codcargo) {
		super();
		this.codigoemple = codigoemple;
		this.codperson = codperson;
		this.codcargo = codcargo;
	}
	public String getCodigoemple() {
		return codigoemple;
	}
	public void setCodigoemple(String codigoemple) {
		this.codigoemple = codigoemple;
	}
	public String getCodperson() {
		return codperson;
	}
	public void setCodperson(String codperson) {
		this.codperson = codperson;
	}
	public String getCodcargo() {
		return codcargo;
	}
	public void setCodcargo(String codcargo) {
		this.codcargo = codcargo;
	}
	
	

}
