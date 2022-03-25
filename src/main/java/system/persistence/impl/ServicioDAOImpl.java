package system.persistence.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.model.Servicio;
import system.persistence.ServicioDAO;

@Repository //Para que SPRING reconozca la clase como un BEAN
public class ServicioDAOImpl implements ServicioDAO {
	
	/*Session Factory (debe coincidir con el nombre del spring-crud-servlet.xml)
	 * La inyección de dependencias la realizamos con Autowired
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional //Anotacion que nos permite prescindir de crear la transaccion y hacer el commit y/o rollback
	public List<Servicio> getServicios() {
		
		//Obtenemos la sesión
		Session mySession = sessionFactory.getCurrentSession();
		
		//Creamos la query usando el objeto Query a partir de la sesion (especificamos la tabla donde ralizamos la consulta
		Query<Servicio> query = mySession.createQuery("from Servicio", Servicio.class);
		
		
		//Ejecutamos la query y devolvemos el resultado
		List<Servicio> servicios = query.getResultList();
		
		return servicios;
	}
	
	//Metodo que insertar el registro en la BBDD
	@Override
	@Transactional
	public void insertarServicio(Servicio unServicio) {
		
		//Obtenemos la sesión
		Session mySession = sessionFactory.getCurrentSession();
		
		//Insercion del registro
		mySession.saveOrUpdate(unServicio);
		
	}
	
	//Metodo que proporciono un cliente de la BBDD de acuerdo al ID que le pasemos por parametro
	@Override
	@Transactional
	public Servicio getUnServicio(int id) {
		
		//Obtenemos la sesión
		
		Session mySession = sessionFactory.getCurrentSession();
		
		//Obtenemos la información del cliente seleccionado en la BBDD
		
		Servicio unServicio = mySession.get(Servicio.class, id);
		
		return unServicio;
	}
	
	
	//Metodo que elimina el registro en la BBDD
	@Override
	@Transactional
	public void eliminarServicio(int id) {
		
		//Obtenemos la sesión
		Session mySession = sessionFactory.getCurrentSession();
				
		//Borrar el cliente de la BBDD usando su ID como criterio
		//Ejecutamos una query de tipo DELETE (Query Class)
		Query query = mySession.createQuery("delete from Servicio where id=:idServicio");
		
		//Insertamos el ID que recibimos por parámetro dentro de la query con .setParameter()		
		query.setParameter("idServicio", id);
		
		//Ejecutamos query
		query.executeUpdate();
		
	}

}
