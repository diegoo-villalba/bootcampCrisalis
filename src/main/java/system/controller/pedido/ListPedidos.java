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

import system.model.Pedido;
import system.model.Producto;
import system.persistence.PedidoDAO;

@Controller
@RequestMapping("/pedido") //Registramos la URL para acceder al .JSP
public class ListPedidos {
	
	@Autowired   //Inyectamos las dependencias de ClienteDAO en esta clase
	private PedidoDAO pedidoDAO;
	
	//Metodo que devuelve el .JSP por parte del Controllador
	@RequestMapping("/lista")
	public String listaPedidos(Model model) {
		
		//Inyección de ClientesDAOImpl en el controllador para hacer la consulta y poder retornar la vista
		
		//Obtiene los clientes desde el DAO
		
		List<Pedido> losPedidos = pedidoDAO.getPedidos();
		
		//Agrega los clientes al modelo "model"
		
		model.addAttribute("pedido", losPedidos);
		
		return "lista-pedidos";
	}
	
	//Mapeo al formulario para insertar registros "Cliente"
	@RequestMapping("/formularioAgregarPedido")
	public String muestraFormularioAltaPedido(Model model) {
		
		//Bind de clientes: creamos un nuevo cliente y lo agregamos a la BBDD
		
		Pedido unPedido = new Pedido();
		
		//Agregamos el cliente al modelo con .addAttribute
		model.addAttribute("pedido", unPedido);
		
		//Devuelve el formularioCliente.jsp 
		return "formularioPedido";
	}
	
	
	//Metodo encargado de insertar el registro en la BBDD
	//Especificamos la URL de redireccion del formulario "Alta Cliente"
	@PostMapping("/insertarPedido")
	public String insertarPedido(@ModelAttribute("pedido") Pedido unPedido) { //Pasamos por atributo el atributo especificado en el <form:form mdelAttribute=
		
		//Insertamos "unCliente" en la BBDD
		pedidoDAO.insertarPedido(unPedido);
		
		//Luego de insertar "unCliente" lo redireccionamos a "/clientes/lista"
		return "redirect:/pedido/lista";
	}
	
	@GetMapping("/muestraFormularioActualizarPedido")
	public String muestraFormularioActualizarPedido(@RequestParam("idPedido") int Id, Model model) {
		
		//Obtenemos el cliente cuyo ID pasamos por parámetro
		Pedido unPedido = pedidoDAO.getUnPedido(Id);
		
		//Establecemoos el cliente como atributo del modelo (ORM)
		model.addAttribute("pedido", unPedido);
		
		//Enviamos al formulario
		return "formularioPedido";
	}
	
	@GetMapping("/eliminarPedido")
	public String eliminarPedido(@RequestParam("idPedido") int Id) {
		
		//Eliminamos el cliente cuyo ID pasamos por parámetro
		pedidoDAO.eliminarPedido(Id);
		
		//Enviamos al formulario
		return "redirect:/pedido/lista";
	}

}
