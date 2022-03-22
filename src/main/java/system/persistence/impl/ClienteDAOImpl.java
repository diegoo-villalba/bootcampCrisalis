package system.persistence.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.model.Cliente;
import system.persistence.ClienteDAO;

@Repository //Para que SPRING reconozca la clase como un BEAN
public class ClienteDAOImpl implements ClienteDAO {
	
	/*Session Factory (debe coincidir con el nombre del spring-crud-servlet.xml)
	 * La inyección de dependencias la realizamos con Autowired
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	@Transactional //Anotacion que nos permite prescindir de crear la transaccion y hacer el commit y/o rollback
	public List<Cliente> getClientes() {
		
		//Obtenemos la sesión
		Session mySession = sessionFactory.getCurrentSession();
		
		//Creamos la query usando el objeto Query a partir de la sesion (especificamos la tabla donde ralizamos la consulta
		Query<Cliente> query = mySession.createQuery("from Cliente", Cliente.class);
		
		
		//Ejecutamos la query y devolvemos el resultado
		List<Cliente> clientes = query.getResultList();
		
		return clientes;
	}
	
	//Metodo que insertar el registro en la BBDD
	@Override
	@Transactional
	public void insertarCliente(Cliente unCliente) {
		
		//Obtenemos la sesión
		Session mySession = sessionFactory.getCurrentSession();
		
		//Insercion del registro
		//mySession.save(unCliente);
		mySession.saveOrUpdate(unCliente);
		
	}
	
	//Metodo que proporciono un cliente de la BBDD de acuerdo al ID que le pasemos por parametro
	@Override
	@Transactional
	public Cliente getUnCliente(int id) {
		
		//Obtenemos la sesión
		
		Session mySession = sessionFactory.getCurrentSession();
		
		//Obtenemos la información del cliente seleccionado en la BBDD
		
		Cliente unCliente = mySession.get(Cliente.class, id);
		
		return unCliente;
	}

}
