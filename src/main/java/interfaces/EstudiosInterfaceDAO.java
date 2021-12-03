package interfaces;

import java.util.List;

import beans.Estudios;

public interface EstudiosInterfaceDAO {

	public List<Estudios> getListEstudios();
	public int createEstudios(Estudios estu);
	public Estudios getEstudios(String id);
	public int editEstudios(Estudios estu);
	public int removeEstudios(String id);
}
