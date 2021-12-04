package interfaces;

import java.util.List;

import beans.Tematica;

public interface TematicaInterface {
	public List<Tematica> getListTematica();
	public int createTematica (Tematica tem);
	public Tematica Tematica(String cod);
	public int editTematica(Tematica tem);
	public int removeTematica(String cod);
}
