package system.controller.pedido;

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
import system.model.Pedido;
import system.persistence.ClienteDAO;
import system.persistence.PedidoDAO;

@Controller
@RequestMapping("/pedido") // Registramos la URL para acceder al .JSP
public class ListPedidos {

	@Autowired
	private PedidoDAO pedidoDAO;
	@Autowired
	private ClienteDAO clienteDAO;

	// Metodo que devuelve el .JSP por parte del Controllador
	@RequestMapping("/lista")
	public String listaPedido(Model model) {

		List<Pedido> losPedidos = pedidoDAO.getPedidos();
		
		//request.setAttribute("pedido", losPedidos
		model.addAttribute("pedido", losPedidos);

		return "lista-pedidos";
	}

	@RequestMapping("/formularioNuevoPedido")
	public String muestraFormularioNuevoPedido(Model model) {

		Pedido unPedido = new Pedido();

		Cliente unCliente = new Cliente();

		model.addAttribute("pedido", unPedido);
		model.addAttribute("cliente", unCliente);

		return "registrarPedido";
	}

	// Metodo encargado de insertar el registro en la BBDD
	/*@PostMapping("/insertarPedido")
	public String insertarPedido(@ModelAttribute("pedido") Pedido unPedido) { // Pasamos por atributo el atributo
																				// especificado en el <form:form
																				// mdelAttribute=

		pedidoDAO.insertarPedido(unPedido);

		return "redirect:/pedido/lista";
	}*/

	@GetMapping("/muestraFormularioActualizarPedido")
	public String muestraFormularioActualizarPedido(@RequestParam("idPedido") int Id, Model model) {

		Pedido unPedido = pedidoDAO.getUnPedido(Id);

		model.addAttribute("pedido", unPedido);

		return "formularioPedido";
	}

	@GetMapping("/eliminarPedido")
	public String eliminarPedido(@RequestParam("idPedido") int Id) {

		pedidoDAO.eliminarPedido(Id);

		// Enviamos al formulario
		return "redirect:/pedido/lista";
	}

	@PostMapping("/insertarPedido")
	public String insertarPedidoCristo(@ModelAttribute("cliente") Cliente unCliente,
			@ModelAttribute("pedido") Pedido pedido) {
		
		
		pedidoDAO.insertarClienteAlPedido(unCliente, pedido);

		return "redirect:/pedido/lista";

	}

}
