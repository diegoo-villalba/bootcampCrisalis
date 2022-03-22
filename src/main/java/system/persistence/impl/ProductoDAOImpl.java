package system.persistence.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.model.Cliente;
import system.model.Producto;
import system.persistence.ProductoDAO;

@Repository //Para que SPRING reconozca la clase como un BEAN
public class ProductoDAOImpl implements ProductoDAO {
	
	/*Session Factory (debe coincidir con el nombre del spring-crud-servlet.xml)
	 * La inyección de dependencias la realizamos con Autowired
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	@Transactional //Anotacion que nos permite prescindir de crear la transaccion y hacer el commit y/o rollback
	public List<Producto> getProductos() {
		
		//Obtenemos la sesión
		Session mySession = sessionFactory.getCurrentSession();
		
		//Creamos la query usando el objeto Query a partir de la sesion (especificamos la tabla donde ralizamos la consulta
		Query<Producto> query = mySession.createQuery("from Producto", Producto.class);
		
		
		//Ejecutamos la query y devolvemos el resultado
		List<Producto> productos = query.getResultList();
		
		return productos;
	}
	
	//Metodo que insertar el registro en la BBDD
	@Override
	@Transactional
	public void insertarProducto(Producto unProducto) {
		
		//Obtenemos la sesión
		Session mySession = sessionFactory.getCurrentSession();
		
		//Insercion del registro
		mySession.saveOrUpdate(unProducto);
		
	}
	
	//Metodo que proporciono un cliente de la BBDD de acuerdo al ID que le pasemos por parametro
	@Override
	@Transactional
	public Producto getUnProducto(int id) {
		
		//Obtenemos la sesión
		
		Session mySession = sessionFactory.getCurrentSession();
		
		//Obtenemos la información del cliente seleccionado en la BBDD
		
		Producto unProducto = mySession.get(Producto.class, id);
		
		return unProducto;
	}
	
	
	//Metodo que elimina el registro en la BBDD
	@Override
	@Transactional
	public void eliminarProducto(int id) {
		
		//Obtenemos la sesión
		Session mySession = sessionFactory.getCurrentSession();
				
		//Borrar el cliente de la BBDD usando su ID como criterio
		//Ejecutamos una query de tipo DELETE (Query Class)
		Query query = mySession.createQuery("delete from Producto where id=:idProducto");
		
		//Insertamos el ID que recibimos por parámetro dentro de la query con .setParameter()		
		query.setParameter("idProducto", id);
		
		//Ejecutamos query
		query.executeUpdate();
		
	}

}
