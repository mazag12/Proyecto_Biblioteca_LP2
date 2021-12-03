package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Libro;
import beans.Prestamo;
import dao.DAOFactory;
import interfaces.LibroInterface;
import interfaces.PrestamoInterface;

/**
 * Servlet implementation class PrestamoServlet
 */
@WebServlet("/PrestamoServlet")
public class PrestamoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PrestamoServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listPrestamo(request, response);
    	} else if (type.equals("register")) {
    		String codPrestamo = request.getParameter("codPrestamo");
    		if(codPrestamo.isEmpty()) {
    			//registerPrestamo(request, response);
    		} else {
    			///editPrestamo(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getPrestamo(request, response);
    	} else if (type.equals("delete")) {
    		//deletePrestamo(request, response);
    	} 
    }
    
    
    protected void listPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	PrestamoInterface dao = daoFactory.getPrestamo();
    	
    	List<Prestamo> data = dao.getListPrestamo();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
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
