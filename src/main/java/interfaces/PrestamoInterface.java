package interfaces;

import java.util.List;

import beans.Prestamo;

public interface PrestamoInterface {

	public List<Prestamo> getListPrestamo();
	public int createPrestamo (Prestamo pr);
	public Prestamo getPrestamo(String cod);
	public int editPrestamo(Prestamo pr);
	public int removePrestamo(String cod);
	
}
