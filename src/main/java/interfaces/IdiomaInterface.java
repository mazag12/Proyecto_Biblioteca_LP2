package interfaces;

import java.util.List;

import beans.Idioma;

public interface IdiomaInterface {
	public List<Idioma> getListIdioma();
	public int createIdioma(Idioma idio);
	public Idioma getIdioma(String id);
	public int editIdioma(Idioma idio);
	public int removeEstudios(String id);
}
