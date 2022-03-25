package system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedido")
	private int idPedido;
	
	@Column(name = "costoTotal")
	private Double costoTotal;
	
	@Column(name = "idCliente")
	private int idCliente;
	
	@Column(name = "idProducto")
	private int idProducto;
	
	@Column(name = "idServicio")
	private int idServicio;
	
	//private Servicio servicio;
	//private Producto producto;
	//private Cliente cliente;
	
	//------------------CONSTRUCTORES------------------
	
	public Pedido() {
		
	}
	
	//------------------GETTERS------------------------

	public int getIdPedido() {
		return idPedido;
	}

	public Double getCostoTotal() {
		return costoTotal;
	}
	/*
	public Cliente getCliente() {
		return cliente;
	}

	public Producto getProducto() {
		return producto;
	}

	public Servicio getServicio() {
		return servicio;
	}*/
	
	//------------------SETTERS------------------------

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}

	/*public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}*/
	
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", costoTotal=" + costoTotal + ", idCliente=" + idCliente
				+ ", idProducto=" + idProducto + ", idServicio=" + idServicio + "]";
	}


}
