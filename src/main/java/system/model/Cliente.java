package system.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // En nuestra BBDD, ID es nuestros campo clave
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "dni")
	private int dni;
	
	@OneToMany(mappedBy="cliente", orphanRemoval = true)
	private List<Pedido> pedidos = new ArrayList<>();
	
	
	//----------------CONSTRUCTORES--------------------
	
	public Cliente() {

	}
	
	public Cliente(String nombre, String apellido, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
	
	public void agregarPedidos(Pedido unPedido) {
		//Si la lista de pedidos no existe, instanciamos una
		if(pedidos==null) pedidos = new ArrayList<>();
			
			//Anadimos el pedido a la lista de pedidos
			pedidos.add(unPedido);
			
			//Establecemos el cliente que realiza el pedido ("this")
			unPedido.setCliente(this);
		}

}
