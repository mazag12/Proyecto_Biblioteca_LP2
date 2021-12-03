package interfaces;

import java.util.List;

import beans.Carnet;

public interface CarnetInterface {
	
	public List<Carnet> getListCarnet();
	public int createCarnet (Carnet car);
	public Carnet getCarnet(String cod);
	public int editCarnet(Carnet car);
	public int removeCarnet(String cod);

}
