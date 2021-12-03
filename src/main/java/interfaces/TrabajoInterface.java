package interfaces;

import java.util.List;

import beans.Trabajo;

public interface TrabajoInterface {

	public List<Trabajo> getListTrabajo();
	public int createTrabajo(Trabajo tr);
	public Trabajo getTrabajo(String cod);
	public int editTrabajo(Trabajo tr);
	public int removeTrabajo(String cod);
	
}
