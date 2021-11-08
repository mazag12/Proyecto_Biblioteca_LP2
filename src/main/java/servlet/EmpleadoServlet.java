package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Empleado;
import dao.DAOFactory;
import interfaces.EmpleadoInterface;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listEmpleado(request, response);
    	} else if (type.equals("register")) {
    		String codAutor = request.getParameter("codAutor");
    		if(codAutor.isEmpty()) {
    			//registerAutor(request, response);
    		} else {
    			///editAutor(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getAutor(request, response);
    	} else if (type.equals("delete")) {
    		//deleteAutor(request, response);
    	} 
    }
    
    protected void listEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	EmpleadoInterface dao = daoFactory.getEmpleado();
    	
    	List<Empleado> data = dao.getListEmpleado();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Empleado.jsp").forward(request, response);
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
