package dao;

import interfaces.AutorInterface;
import interfaces.ClienteInterface;
import interfaces.EstudiosInterfaceDAO;
import interfaces.FamiliaInterfaceDAO;
import interfaces.IdiomaInterfaceDAO;
import interfaces.PersonaInterfaceDAO;
import interfaces.FormatoInterface;
import interfaces.PaisInterface;
import interfaces.DepartamentoInterface;
import interfaces.DistritoInterface;
import interfaces.ProvinciaInterface;

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
	public IdiomaInterfaceDAO getIdioma() {
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
	
}
