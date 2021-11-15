package beans;

public class Usuario extends Empleado{

	
	public int Codigo;
	public String usernombre;
	
	public Usuario(String codPersona, String nombre, String apePaterno, String apeMaterno, String tipoDoc,
			String numDoc, int telefono, int celular, String correo, String direccion, String sexo, String nacionalidad,
			String estadoCivil, String codigoemple, String codperson, String codcargo,int Codigo,String usernombre) {
		super(codPersona, nombre, apePaterno, apeMaterno, tipoDoc, numDoc, telefono, celular, correo, direccion, sexo,
				nacionalidad, estadoCivil, codigoemple, codperson, codcargo);
		this.Codigo = Codigo;
		this.usernombre =usernombre;
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getUsernombre() {
		return usernombre;
	}

	public void setUsernombre(String usernombre) {
		this.usernombre = usernombre;
	}
	
	
}
