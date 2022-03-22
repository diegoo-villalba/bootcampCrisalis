package system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // En nuestra BBDD, ID es nuestros campo clave
	@Column(name = "idProducto")
	private int idProducto;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "costoBase")
	private Double costoBase;

	
	public Producto() {

	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCostoBase() {
		return costoBase;
	}

	public void setCostoBase(Double costoBase) {
		this.costoBase = costoBase;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", costoBase=" + costoBase + "]";
	}

}
