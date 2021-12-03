package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import beans.Trabajo;
import dao.DAOFactory;
import interfaces.LibroInterface;
import interfaces.TrabajoInterface;

/**
 * Servlet implementation class TrabajoServlet
 */
@WebServlet("/TrabajoServlet")
public class TrabajoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TrabajoServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listTrabajo(request, response);
    	} else if (type.equals("register")) {
    		String codTrabajo = request.getParameter("codTrabajo");
    		if(codTrabajo.isEmpty()) {
    			//registerTrabajo(request, response);
    		} else {
    			///editTrabajo(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getTrabajo(request, response);
    	} else if (type.equals("delete")) {
    		//deleteTrabajo(request, response);
    	} 
    }
    
    protected void listLibro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	TrabajoInterface dao = daoFactory.getTrabajo();
    	
    	List<Trabajo> data = dao.getListTrabajo();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Trabajo.jsp").forward(request, response);
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
