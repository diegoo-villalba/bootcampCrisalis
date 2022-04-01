package system.connection;


import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import system.model.Cliente;
import system.model.Pedido;

public class App {

	public static void main(String[] args) {

		SessionFactory myFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Cliente.class).addAnnotatedClass(Pedido.class).buildSessionFactory();

		Session mySession = myFactory.openSession();
		try {

			mySession.beginTransaction();

			// Obtenemos el cliente de la BBDD
			Cliente unCliente = mySession.get(Cliente.class, 2);

			// Creamos el Pedido del cliente
			Pedido unPedido = new Pedido(new GregorianCalendar(2029, 07, 31));

			// Agregamos el pedido al cliente creado
			unCliente.agregarPedidos(unPedido);

			// Guardamos los pedidos en la BBDD
			mySession.save(unPedido);

			mySession.getTransaction().commit();

			System.out.println("Registro insertado");

		} catch (Exception e) {
			e.printStackTrace();

		}

		finally {
			mySession.close();
			myFactory.close();
		}

	}

}
