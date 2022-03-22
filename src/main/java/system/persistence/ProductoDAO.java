package system.persistence;

import java.util.List;

import system.model.Producto;

public interface ProductoDAO {

	public List<Producto> getProductos();
	
	public void insertarProducto(Producto unProducto);

	public Producto getUnProducto(int id);

	public void eliminarProducto(int id);

}
