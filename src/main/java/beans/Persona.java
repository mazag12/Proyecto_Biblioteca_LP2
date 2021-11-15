package beans;

public class Persona {

	
	private String codPersona;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private String tipoDoc;
	private String NumDoc;
	private int telefono;
	private int celular;
	private String correo;
	private String direccion;
	private String sexo;
	private String nacionalidad;
	private String estadoCivil;
	
	public Persona(String codPersona, String nombre, String apePaterno, String apeMaterno, String tipoDoc,
			String numDoc, int telefono, int celular, String correo, String direccion, String sexo, String nacionalidad,
			String estadoCivil) {
		super();
		this.codPersona = codPersona;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.tipoDoc = tipoDoc;
		NumDoc = numDoc;
		this.telefono = telefono;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.sexo = sexo;
		this.nacionalidad = nacionalidad;
		this.estadoCivil = estadoCivil;
	}
	
	
	public String getCodPersona() {
		return codPersona;
	}
	public void setCodPersona(String codPersona) {
		this.codPersona = codPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApePaterno() {
		return apePaterno;
	}
	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}
	public String getApeMaterno() {
		return apeMaterno;
	}
	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getNumDoc() {
		return NumDoc;
	}
	public void setNumDoc(String numDoc) {
		NumDoc = numDoc;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
}
