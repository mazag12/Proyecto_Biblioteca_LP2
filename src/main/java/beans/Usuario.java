package beans;

public class Usuario{

	
	public int Codigo;
	public String usernombre;
	
	
	

	@Override
	public String toString() {
		return "Usuario [Codigo=" + Codigo + ", usernombre=" + usernombre + "]";
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
