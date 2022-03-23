package system.controller.servicio;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import system.model.Servicio;
import system.persistence.ServicioDAO;

@Controller
@RequestMapping("/servicio") //Registramos la URL para acceder al .JSP
public class ListServicios {
	
	@Autowired   //Inyectamos las dependencias de ClienteDAO en esta clase
	private ServicioDAO servicioDAO;
	
	//Metodo que devuelve el .JSP por parte del Controllador
	@RequestMapping("/lista")
	public String listaServicios(Model model) {
		
		//Inyección de ClientesDAOImpl en el controllador para hacer la consulta y poder retornar la vista
		
		//Obtiene los clientes desde el DAO
		
		List<Servicio> losServicios = servicioDAO.getServicios();
		
		//Agrega los clientes al modelo "model"
		
		model.addAttribute("servicio", losServicios);
		
		return "lista-servicios";
	}
	
	//Mapeo al formulario para insertar registros "Cliente"
	@RequestMapping("/formularioAgregarServicio")
	public String muestraFormularioAltaServicio(Model model) {
		
		//Bind de clientes: creamos un nuevo cliente y lo agregamos a la BBDD
		
		Servicio unServicio = new Servicio();
		
		//Agregamos el cliente al modelo con .addAttribute
		model.addAttribute("servicio", unServicio);
		
		//Devuelve el formularioCliente.jsp 
		return "formularioServicio";
	}
	
	
	//Metodo encargado de insertar el registro en la BBDD
	//Especificamos la URL de redireccion del formulario "Alta Cliente"
	@PostMapping("/insertarServicio")
	public String insertarServicio(@ModelAttribute("servicio") Servicio unServicio) { //Pasamos por atributo el atributo especificado en el <form:form mdelAttribute=
		
		//Insertamos "unCliente" en la BBDD
		servicioDAO.insertarServicio(unServicio);
		
		//Luego de insertar "unCliente" lo redireccionamos a "/clientes/lista"
		return "redirect:/servicio/lista";
	}
	
	@GetMapping("/muestraFormularioActualizarServicio")
	public String muestraFormularioActualizarCliente(@RequestParam("servicioId") int Id, Model model) {
		
		//Obtenemos el cliente cuyo ID pasamos por parámetro
		Servicio unServicio = servicioDAO.getUnServicio(Id);
		
		//Establecemoos el cliente como atributo del modelo (ORM)
		model.addAttribute("servicio", unServicio);
		
		//Enviamos al formulario
		return "formularioServicio";
	}
	
	//Metodo que permite transformar las fechas de tipo "Date" al formato especificado
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    sdf.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@GetMapping("/eliminarServicio")
	public String eliminarServicio(@RequestParam("servicioId") int Id) {
		
		//Eliminamos el cliente cuyo ID pasamos por parámetro
		servicioDAO.eliminarServicio(Id);
		
		//Enviamos al formulario
		return "redirect:/servicio/lista";
	}
	
}
