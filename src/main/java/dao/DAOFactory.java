package dao;
import interfaces.AutorInterface;
import interfaces.EstudiosInterfaceDAO;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	public static final int AZURECosmos = 2;
	public static final int SQL_SERVER = 3;
	
	public abstract AutorInterface getAutor();
	public abstract EstudiosInterfaceDAO getEstudios();
	
	public static DAOFactory getFactory(int tipo) {
		switch (tipo) {
			case MYSQL:
				return new MySqlDAOFactory();
			case AZURECosmos:
				return null;
			case SQL_SERVER:
				return null;
		}
		return null;
	}
	
}
