package dao;

import interfaces.AutorInterface;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public AutorInterface getAutor() {
		// TODO Auto-generated method stub
		return new MySqlAutorDAO();
	}
	
	
	
}
