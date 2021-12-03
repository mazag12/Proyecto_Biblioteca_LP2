package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAOFactory;
import beans.Usuario;
import interfaces.UsuarioInterface;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String type = request.getParameter("type");
    	if (type.equals("login")) {
    		String email = request.getParameter("txtNombre");
        	String pass = request.getParameter("txtPass");
        	
        	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
        	UsuarioInterface dao = daoFactory.getUsuario();
        	
        	Usuario usuario = dao.verifyAuthModel(email, pass);
        	if (usuario != null) {
        		
        		HttpSession sesion = request.getSession();
        		sesion.setAttribute("name", usuario.getUsernombre());
        		sesion.setAttribute("rol", usuario.getRol());
        		
        		response.sendRedirect("home.jsp");
        		
        	} else {
        		
        		request.setAttribute("msj", "Verifique sus datos");
        		request.getRequestDispatcher("login.jsp").forward(request, response);
        		
        	}
    	} else if (type.equals("logout")) {
    		request.getSession().invalidate();
    		response.sendRedirect("home.jsp");    		
    	}
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
