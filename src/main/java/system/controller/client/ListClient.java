package system.controller.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import system.model.Cliente;
import system.persistence.ClienteDAO;

@Controller
@RequestMapping("/clientes") //Registramos la URL para acceder al .JSP
public class ListClient {
	
	@Autowired   //Inyectamos las dependencias de ClienteDAO en esta clase
	private ClienteDAO clienteDAO;
	
	//Metodo que devuelve el .JSP por parte del Controllador
	@RequestMapping("/lista")
	public String listaClientes(Model model) {
		
		//Inyección de ClientesDAOImpl en el controllador para hacer la consulta y poder retornar la vista
		
		//Obtiene los clientes desde el DAO
		
		List<Cliente> losClientes = clienteDAO.getClientes();
		
		//Agrega los clientes al modelo "model"
		
		model.addAttribute("clientes", losClientes);
		
		return "lista-clientes";
	}
	
	//Mapeo al formulario para insertar registros "Cliente"
	@RequestMapping("/formularioAgregarCliente")
	public String muestraFormularioAltaCliente(Model model) {
		
		//Bind de clientes: creamos un nuevo cliente y lo agregamos a la BBDD
		
		Cliente unCliente = new Cliente();
		
		//Agregamos el cliente al modelo con .addAttribute
		model.addAttribute("cliente", unCliente);
		
		//Devuelve el formularioCliente.jsp 
		return "formularioCliente";
	}
	
	
	//Metodo encargado de insertar el registro en la BBDD
	//Especificamos la URL de redireccion del formulario "Alta Cliente"
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente unCliente) { //Pasamos por atributo el atributo especificado en el <form:form mdelAttribute=
		
		//Insertamos "unCliente" en la BBDD
		clienteDAO.insertarCliente(unCliente);
		
		//Luego de insertar "unCliente" lo redireccionamos a "/clientes/lista"
		return "redirect:/clientes/lista";
	}
	
	@GetMapping("/muestraFormularioActualizarCliente")
	public String muestraFormularioActualizarCliente(@RequestParam("clienteId") int Id, Model model) {
		
		//Obtenemos el cliente cuyo ID pasamos por parámetro
		Cliente unCliente = clienteDAO.getUnCliente(Id);
		
		//Establecemoos el cliente como atributo del modelo (ORM)
		model.addAttribute("cliente", unCliente);
		
		//Enviamos al formulario
		return "formularioCliente";
	}
	
	@GetMapping("/eliminarCliente")
	public String eliminarCliente(@RequestParam("clienteId") int Id) {
		
		//Eliminamos el cliente cuyo ID pasamos por parámetro
		clienteDAO.eliminarCiente(Id);
		
		//Enviamos al formulario
		return "redirect:/clientes/lista";
	}

}
