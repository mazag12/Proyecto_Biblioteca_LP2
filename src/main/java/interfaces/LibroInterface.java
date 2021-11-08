package interfaces;

import java.util.List;

import beans.Libro;

public interface LibroInterface {

	public List<Libro> getListLibro();
	public int createLibro (Libro pa);
	public Libro getLibro(String cod);
	public int editLibro(Libro pa);
	public int removeLibro(String cod);
}
