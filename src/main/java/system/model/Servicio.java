package system.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "servicio")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idServicio")
	private int idServicio;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "costoMensual")
	private Double costoMensual;

	@Column(name = "fechaFin")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFinalizacion;

	public Servicio() {

	}

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getCostoMensual() {
		return costoMensual;
	}

	public void setCostoMensual(Double costoMensual) {
		this.costoMensual = costoMensual;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombre=" + nombre + ", costoMensual=" + costoMensual
				+ ", fechaFinalizacion=" + fechaFinalizacion + "]";
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

}
