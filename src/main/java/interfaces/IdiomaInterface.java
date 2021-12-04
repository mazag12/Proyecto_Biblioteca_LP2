package interfaces;

import java.util.List;

import beans.Idioma;

public interface IdiomaInterface {
	public List<Idioma> getListIdioma();
	public int createIdioma(Idioma idio);
	public Idioma getIdioma(String id);
	public Idioma getdatosIdioma(String id);
	public int editIdioma(Idioma idio);
	public int removeIdioma(String id);
	
}
