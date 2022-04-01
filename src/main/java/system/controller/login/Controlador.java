package system.controller.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu = request.getParameter("menu");
		String accion = request.getParameter("accion");
		
		if(menu.equals("Principal")) {
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
		}
		
		if(menu.equals("NuevoPedido")) {
			request.getRequestDispatcher("registrarPedido.jsp").forward(request, response);
		}
		
		/*switch(accion) {
		case "Principal":
			request.getRequestDispatcher("Principal.jsp").forward(request, response);
			break;
		case "NuevoPedido":
			request.getRequestDispatcher("registrarPedido.jsp").forward(request, response);
			break;*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
