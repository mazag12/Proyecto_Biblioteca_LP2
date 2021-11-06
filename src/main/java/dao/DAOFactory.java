package dao;
import interfaces.AutorInterface;
<<<<<<< HEAD
import interfaces.ClienteInterface;
=======
import interfaces.EstudiosInterfaceDAO;
>>>>>>> branch 'main' of https://github.com/mazag12/Proyecto_Biblioteca_LP2

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	public static final int AZURECosmos = 2;
	public static final int SQL_SERVER = 3;
	
	public abstract AutorInterface getAutor();
	public abstract EstudiosInterfaceDAO getEstudios();
	
	public abstract ClienteInterface getCliente();
	
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
