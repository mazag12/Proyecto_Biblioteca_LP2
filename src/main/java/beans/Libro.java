package beans;

//@marco
public class Libro extends Autor{

	
	public Libro(String codlibro, String titulo, String ano, String codidioma, String codtematica, String codeditorial,
			String restrincion, int paginas, int cantidad, String fragmento, String recomendados, String codformato,
			String codpais, String estado, String isbn) {
		super();
		this.codlibro = codlibro;
		this.titulo = titulo;
		this.ano = ano;
		this.codidioma = codidioma;
		this.codtematica = codtematica;
		this.codeditorial = codeditorial;
		this.restrincion = restrincion;
		this.paginas = paginas;
		this.cantidad = cantidad;
		this.fragmento = fragmento;
		this.recomendados = recomendados;
		this.codformato = codformato;
		this.codpais = codpais;
		this.estado = estado;
		this.isbn = isbn;
	}
	private String codlibro;
	private String titulo;
	private String ano;
	private String codidioma;
	private String codtematica;
	private String codeditorial;
	private String restrincion;
	private int paginas;
	private int cantidad;
	private String fragmento;
	private String recomendados;
	private String codformato;
	private String codpais;
	private String estado;
	private String isbn;
	
	
	
	public String getCodlibro() {
		return codlibro;
	}
	public void setCodlibro(String codlibro) {
		this.codlibro = codlibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getCodidioma() {
		return codidioma;
	}
	public void setCodidioma(String codidioma) {
		this.codidioma = codidioma;
	}
	public String getCodtematica() {
		return codtematica;
	}
	public void setCodtematica(String codtematica) {
		this.codtematica = codtematica;
	}
	public String getCodeditorial() {
		return codeditorial;
	}
	public void setCodeditorial(String codeditorial) {
		this.codeditorial = codeditorial;
	}
	public String getRestrincion() {
		return restrincion;
	}
	public void setRestrincion(String restrincion) {
		this.restrincion = restrincion;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getFragmento() {
		return fragmento;
	}
	public void setFragmento(String fragmento) {
		this.fragmento = fragmento;
	}
	public String getRecomendados() {
		return recomendados;
	}
	public void setRecomendados(String recomendados) {
		this.recomendados = recomendados;
	}
	public String getCodformato() {
		return codformato;
	}
	public void setCodformato(String codformato) {
		this.codformato = codformato;
	}
	public String getCodpais() {
		return codpais;
	}
	public void setCodpais(String codpais) {
		this.codpais = codpais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
