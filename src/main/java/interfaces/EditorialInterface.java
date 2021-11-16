package interfaces;

import java.util.List;

import beans.Editorial;

public interface EditorialInterface {
	public List<Editorial> getListEditorial();
	public int createEditorial (Editorial tem);
	public Editorial Editorial(String cod);
	public int editEditorial(Editorial tem);
	public int removeEditorial(String cod);
}
