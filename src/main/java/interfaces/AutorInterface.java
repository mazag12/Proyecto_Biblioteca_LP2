package interfaces;

import java.util.List;

import beans.Autor;

public interface AutorInterface {

	public List<Autor> getListAutor();
	public int createAutor(Autor au);
	public Autor Autor(String nombre);
	public int editAutor(Autor au);
	public int removeAutor(String cod);
	
}
