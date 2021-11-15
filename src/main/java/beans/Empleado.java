package beans;

public class Empleado extends Persona{
	
	
	public String codigoemple;
	public String codperson;
	public String codcargo;
	
	public Empleado(String codPersona, String nombre, String apePaterno, String apeMaterno, String tipoDoc,
			String numDoc, int telefono, int celular, String correo, String direccion, String sexo, String nacionalidad,
			String estadoCivil,String codigoemple,String codperson, String codcargo) {
		super(codPersona, nombre, apePaterno, apeMaterno, tipoDoc, numDoc, telefono, celular, correo, direccion, sexo,
				nacionalidad, estadoCivil);
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
