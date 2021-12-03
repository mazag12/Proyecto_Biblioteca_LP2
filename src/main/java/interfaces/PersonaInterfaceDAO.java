package interfaces;

import java.util.List;

import beans.Persona;

public interface PersonaInterfaceDAO {
	public List<Persona> getListPersona();
	public int createPersona(Persona perso);
	public Persona getPersona(String id);
	public int editPersona(Persona perso);
	public int removePersona(String id);
}
