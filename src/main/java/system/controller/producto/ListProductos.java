package system.controller.producto;

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
import system.model.Producto;
import system.persistence.ProductoDAO;

@Controller
@RequestMapping("/producto") //Registramos la URL para acceder al .JSP
public class ListProductos {
	
	@Autowired   //Inyectamos las dependencias de ClienteDAO en esta clase
	private ProductoDAO productoDAO;
	
	//Metodo que devuelve el .JSP por parte del Controllador
	@RequestMapping("/lista")
	public String listaProductos(Model model) {
		
		//Inyección de ClientesDAOImpl en el controllador para hacer la consulta y poder retornar la vista
		
		//Obtiene los clientes desde el DAO
		
		List<Producto> losProductos = productoDAO.getProductos();
		
		//Agrega los clientes al modelo "model"
		
		model.addAttribute("producto", losProductos);
		
		return "lista-productos";
	}
	
	//Mapeo al formulario para insertar registros "Cliente"
	@RequestMapping("/formularioAgregarProducto")
	public String muestraFormularioAltaCliente(Model model) {
		
		//Bind de clientes: creamos un nuevo cliente y lo agregamos a la BBDD
		
		Producto unProducto = new Producto();
		
		//Agregamos el cliente al modelo con .addAttribute
		model.addAttribute("producto", unProducto);
		
		//Devuelve el formularioCliente.jsp 
		return "formularioProducto";
	}
	
	
	//Metodo encargado de insertar el registro en la BBDD
	//Especificamos la URL de redireccion del formulario "Alta Cliente"
	@PostMapping("/insertarProducto")
	public String insertarCliente(@ModelAttribute("producto") Producto unProducto) { //Pasamos por atributo el atributo especificado en el <form:form mdelAttribute=
		
		//Insertamos "unCliente" en la BBDD
		productoDAO.insertarProducto(unProducto);
		
		//Luego de insertar "unCliente" lo redireccionamos a "/clientes/lista"
		return "redirect:/producto/lista";
	}
	
	@GetMapping("/muestraFormularioActualizarProducto")
	public String muestraFormularioActualizarCliente(@RequestParam("productoId") int Id, Model model) {
		
		//Obtenemos el cliente cuyo ID pasamos por parámetro
		Producto unProducto = productoDAO.getUnProducto(Id);
		
		//Establecemoos el cliente como atributo del modelo (ORM)
		model.addAttribute("producto", unProducto);
		
		//Enviamos al formulario
		return "formularioProducto";
	}
	
	@GetMapping("/eliminarProducto")
	public String eliminarCliente(@RequestParam("productoId") int Id) {
		
		//Eliminamos el cliente cuyo ID pasamos por parámetro
		productoDAO.eliminarProducto(Id);
		
		//Enviamos al formulario
		return "redirect:/producto/lista";
	}

}
