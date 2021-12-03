package interfaces;

import java.util.List;

import beans.Cargo;

public interface CargoInterface {
	
	public List<Cargo> getListCargo();
	public int createCargo (Cargo ca);
	public Cargo gerCargo(String cod);
	public int editCargo(Cargo ca);
	public int removeCargo(String cod);

}
