package interfaces;

import java.util.List;

import beans.Departamento;

public interface DepartamentoInterface {
	public List<Departamento> getListDepartamento();
	public int createDepartamento (Departamento de);
	public Departamento Departamento(String cod);
	public int editDepartamento(Departamento de);
	public int removeDepartamento(String cod);
	public Departamento getDepartamento(String pais);
}
