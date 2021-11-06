package interfaces;

import java.util.List;

import beans.Pais;

public interface PaisInterface {

	public List<Pais> getListPais();
	public int createPais (Pais pa);
	public Pais Pais(String cod);
	public int editPais(Pais pa);
	public int removePais(String cod);
}
