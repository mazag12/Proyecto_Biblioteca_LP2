package interfaces;

import java.util.List;

import beans.Formato;

public interface FormatoInterface {

	public List<Formato> getListFormato();
	public int createFormato (Formato fn);
	public Formato Formato(String cod);
	public int editFomato(Formato fn);
	public int removeFormato(String cod);
	
}
