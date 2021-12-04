package dao;
import interfaces.AutorInterface;
import interfaces.CargoInterface;
import interfaces.CarnetInterface;
import interfaces.ClienteInterface;
import interfaces.EstudiosInterfaceDAO;
import interfaces.FamiliaInterfaceDAO;
import interfaces.IdiomaInterface;
import interfaces.LibroInterface;
import interfaces.LogSessionInterfaceDAO;
import interfaces.PersonaInterfaceDAO;
import interfaces.PrestamoInterface;
import interfaces.FormatoInterface;
import interfaces.PaisInterface;
import interfaces.DistritoInterface;
import interfaces.EditorialInterface;
import interfaces.EmpleadoInterface;
import interfaces.ProvinciaInterface;
import interfaces.TematicaInterface;
import interfaces.TrabajoInterface;
import interfaces.DepartamentoInterface;
import interfaces.UsuarioInterface;
public abstract class DAOFactory {
	
	public static final int MYSQL = 1;
	public static final int AZURECosmos = 2;
	public static final int SQL_SERVER = 3;
	
	
	// Metodos Abstractos 
	public abstract AutorInterface getAutor();
	public abstract EstudiosInterfaceDAO getEstudios();
	public abstract FamiliaInterfaceDAO getFamilia();
	public abstract IdiomaInterface getIdioma();
	public abstract PersonaInterfaceDAO getPersona();
	public abstract ClienteInterface getCliente();
	public abstract PaisInterface getPais();
	public abstract FormatoInterface getFormato();
	public abstract DistritoInterface getDistrito();
	public abstract ProvinciaInterface getProvincia();
	public abstract DepartamentoInterface getDepartamento();
	public abstract LibroInterface getLibro();
	public abstract EmpleadoInterface getEmpleado();
	public abstract UsuarioInterface getUsuario();
	public abstract EditorialInterface getEditorial();
	public abstract TematicaInterface getTematica();
	public abstract TrabajoInterface getTrabajo();
	public abstract PrestamoInterface getPrestamo();
	public abstract CargoInterface getCargo();
	public abstract CarnetInterface getCarnet();
    public abstract LogSessionInterfaceDAO getSession();
	
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
