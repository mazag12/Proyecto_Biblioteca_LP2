package beans;

public class Usuario{

	public String usernombre;
	public String rol;

	public Usuario(String usernombre, String rol) {
		super();
		this.usernombre = usernombre;
		this.rol = rol;
	}

	public String getUsernombre() {
		return usernombre;
	}

	public void setUsernombre(String usernombre) {
		this.usernombre = usernombre;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
}
