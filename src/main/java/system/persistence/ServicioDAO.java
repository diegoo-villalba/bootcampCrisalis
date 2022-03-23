package system.persistence;

import java.util.List;

import system.model.Servicio;

public interface ServicioDAO {

	// Creamos la interfaz para despues hacer las inyecciones de dependencia de manera mas facil

	public List<Servicio> getServicios();

	public void insertarServicio(Servicio unServicio);

	public Servicio getUnServicio(int id);

	public void eliminarServicio(int id);

}
