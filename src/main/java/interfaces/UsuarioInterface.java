package interfaces;

import java.util.List;

import beans.Usuario;

public interface UsuarioInterface {
	
	public List<Usuario> getListUsuario();
	public Usuario verifyAuthModel(String nombre, String password);
	public int createAutor(Usuario asu);
	public Usuario Usuario(String cod);
	public int editUsuario(Usuario asu);
	public int removeUsuario(String cod);
	
}
