package system.model;

import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // En nuestra BBDD, ID es nuestros campo clave
	@Column(name = "idPedido")
	private int idPedido;
	
	@Column(name = "fechaPedido")
	private GregorianCalendar fechaPedido;
	
	@Column(name = "montoPedido")
	private Double montoPedido;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	
	//----------------CONSTRUCTORES--------------------
	
	public Pedido()	{
		
	}
	
	public Pedido(GregorianCalendar fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	
	//---------------GETTERS--------------------
	
	public int getIdPedido() {
		return idPedido;
	}

	public GregorianCalendar getFechaPedido() {
		return fechaPedido;
	}

	public Double getMontoPedido() {
		return montoPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	//----------------SETTERS--------------------
	
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public void setFechaPedido(GregorianCalendar fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public void setMontoPedido(Double montoPedido) {
		this.montoPedido = montoPedido;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
