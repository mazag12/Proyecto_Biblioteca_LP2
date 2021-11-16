package interfaces;

import java.util.List;

import beans.Idioma;

public interface IdiomaInterface {
	public List<Idioma> getListIdioma();
	public int createIdioma (Idioma idio);
	public Idioma Idioma(String cod);
	public int editIdioma(Idioma tem);
	public int removeIdioma(String idio);
}
