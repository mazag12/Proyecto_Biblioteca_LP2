package interfaces;

import java.util.List;

import beans.Provincia;

public interface ProvinciaInterface {

	public List<Provincia> getListProvincia();
	public int createProvincia (Provincia pr);
	public Provincia Departamento(String cod);
	public int editProvincia(Provincia pr);
	public int removeProvincia(String cod);
}
