package dao;

import interfaces.AutorInterface;
import interfaces.ClienteInterface;
import interfaces.EstudiosInterfaceDAO;
import interfaces.FamiliaInterfaceDAO;
import interfaces.IdiomaInterface;
import interfaces.LibroInterface;
import interfaces.PersonaInterfaceDAO;
import interfaces.FormatoInterface;
import interfaces.PaisInterface;
import interfaces.DepartamentoInterface;
import interfaces.DistritoInterface;
import interfaces.EditorialInterface;
import interfaces.EmpleadoInterface;
import interfaces.ProvinciaInterface;
import interfaces.TematicaInterface;
import interfaces.UsuarioInterface;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public AutorInterface getAutor() {
		// TODO Auto-generated method stub
		return new MySqlAutorDAO();
	}
	
	public  EstudiosInterfaceDAO getEstudios() {
		// TODO Auto-generated method stub
		return new MySqlEstudiosDAO();
	}
	
	public FamiliaInterfaceDAO getFamilia() {
		// TODO Auto-generated method stub
		return new MySqlFamiliaDAO();
	}
	public IdiomaInterface getIdioma() {
		// TODO Auto-generated method stub
		return new MySqlIdiomaDAO();
	}
	public PersonaInterfaceDAO getPersona() {
		// TODO Auto-generated method stub
		return new MySqlPersonaDAO();
	}
	@Override
	public ClienteInterface getCliente() {
		// TODO Auto-generated method stub
		return new MySqlClienteDAO();
	}

	@Override
	public PaisInterface getPais() {
		// TODO Auto-generated method stub
		return new MySqlPaisDAO();
	}

	@Override
	public FormatoInterface getFormato() {
		// TODO Auto-generated method stub
		return new MySqlFormatoDAO();
	}
	
	public DistritoInterface getDistrito() {
		// TODO Auto-generated method stub
		return new MySqlDistritoDAO();
	}
	
	public DepartamentoInterface getDepartamento() {
		// TODO Auto-generated method stub
		return new MySqlDepartamentoDAO();
	}
	
	public ProvinciaInterface getProvincia() {
		// TODO Auto-generated method stub
		return new MySqlProvinciaDAO();
	}

	@Override
	public LibroInterface getLibro() {
		// TODO Auto-generated method stub
		return new MySqlLibroDAO();
	}

	@Override
	public EmpleadoInterface getEmpleado() {
		// TODO Auto-generated method stub
		return new MySqlEmpleadoDAO();
	}

	@Override
	public UsuarioInterface getUsuario() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public EditorialInterface getEditorial() {
		// TODO Auto-generated method stub
		return new MySqlEditorialDAO();
	}

	@Override
	public TematicaInterface getTematica() {
		// TODO Auto-generated method stub
		return new MySqlTematicaDAO();
	}
	
}
