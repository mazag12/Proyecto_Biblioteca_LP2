package interfaces;

import java.util.List;

import beans.Empleado;

public interface EmpleadoInterface {
	
	public List<Empleado> getListEmpleado();
	public int createEmpleado (Empleado di);
	public Empleado getEmpleado(String cod);
	public int editDepartamento(Empleado di);
	public int removeEmpleado(String cod);

}
