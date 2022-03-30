package system.persistence.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.model.Pedido;
import system.persistence.PedidoDAO;

@Repository
public class PedidoDAOImpl implements PedidoDAO {

	/*Session Factory (debe coincidir con el nombre del spring-crud-servlet.xml)
	 * La inyección de dependencias la realizamos con Autowired
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	@Transactional //Anotacion que nos permite prescindir de crear la transaccion y hacer el commit y/o rollback
	public List<Pedido> getPedidos() {
		
		//Obtenemos la sesión
		Session mySession = sessionFactory.getCurrentSession();
		
		//Creamos la query usando el objeto Query a partir de la sesion (especificamos la tabla donde ralizamos la consulta
		Query<Pedido> query = mySession.createQuery("from Pedido", Pedido.class);
		
		
		//Ejecutamos la query y devolvemos el resultado
		List<Pedido> pedidos = query.getResultList();
		
		return pedidos;
	}
	
	//Metodo que insertar el registro en la BBDD
	@Override
	@Transactional
	public void insertarPedido(Pedido unPedido) {
		
		//Obtenemos la sesión
		Session mySession = sessionFactory.getCurrentSession();
		
		//Insercion del registro
		mySession.saveOrUpdate(unPedido);
		
	}
	
	//Metodo que proporciono un registro de la BBDD de acuerdo al ID que le pasemos por parametro
	@Override
	@Transactional
	public Pedido getUnPedido(int id) {
		
		//Obtenemos la sesión
		
		Session mySession = sessionFactory.getCurrentSession();
		
		//Obtenemos la información del cliente seleccionado en la BBDD
		
		Pedido unPedido = mySession.get(Pedido.class, id);
		
		return unPedido;
	}
	
	
	//Metodo que elimina el registro en la BBDD
	@Override
	@Transactional
	public void eliminarPedido(int id) {
		
		//Obtenemos la sesión
		Session mySession = sessionFactory.getCurrentSession();
				
		//Borrar el registro de la BBDD usando su ID como criterio
		//Ejecutamos una query de tipo DELETE (Query Class)
		Query query = mySession.createQuery("delete from Pedido where id=:idPedido");
		
		//Insertamos el ID que recibimos por parámetro dentro de la query con .setParameter()		
		query.setParameter("idPedido", id);
		
		//Ejecutamos query
		query.executeUpdate();
		
	}

}
