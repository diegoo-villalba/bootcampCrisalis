package system.persistence;

import java.util.List;

import system.model.Pedido;

public interface PedidoDAO {

	public List<Pedido> getPedidos();

	public void insertarPedido(Pedido unPedido);

	public Pedido getUnPedido(int id);

	public void eliminarPedido(int id);

}
