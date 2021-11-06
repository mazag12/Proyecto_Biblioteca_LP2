package dao;
import interfaces.AutorInterface;
import interfaces.ClienteInterface;
import interfaces.EstudiosInterfaceDAO;
import interfaces.FamiliaInterfaceDAO;
import interfaces.FormatoInterface;
import interfaces.PaisInterface;

public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	public static final int AZURECosmos = 2;
	public static final int SQL_SERVER = 3;
	
	
	// Metodos Abstractos 
	public abstract AutorInterface getAutor();
	public abstract EstudiosInterfaceDAO getEstudios();
	public abstract FamiliaInterfaceDAO getFamilia();
	public abstract ClienteInterface getCliente();
	public abstract PaisInterface getPais();
	public abstract FormatoInterface getFormato();
	
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
