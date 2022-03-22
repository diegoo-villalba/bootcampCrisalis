package system.persistence;

import java.util.List;

import system.model.Cliente;

public interface ClienteDAO {

	// Creamos la interfaz para despues hacer las inyecciones de dependencia de manera mas facil

	public List<Cliente> getClientes();

	public void insertarCliente(Cliente unCliente);

	public Cliente getUnCliente(int id);

}
