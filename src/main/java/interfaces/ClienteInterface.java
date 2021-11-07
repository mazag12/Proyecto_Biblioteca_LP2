package interfaces;

import java.util.List;

import beans.Cliente;

public interface ClienteInterface {
	public List<Cliente> getListCliente();
	public int createCliente(Cliente cl);
	public Cliente Cliente(String cod);
	public int editCliente(Cliente cl);
	public int removeCliente(String cod);
}
