package interfaces;

import java.util.List;

import beans.Distrito;

public interface DistritoInterface {

	public List<Distrito> getListDistrito();
	public int createDistrito (Distrito di);
	public Distrito Distrito(String cod);
	public int editDepartamento(Distrito di);
	public int removeDistrito(String cod);
}
