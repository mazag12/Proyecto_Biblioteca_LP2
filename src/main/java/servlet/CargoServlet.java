package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cargo;
import beans.Libro;
import dao.DAOFactory;
import interfaces.CargoInterface;
import interfaces.LibroInterface;

/**
 * Servlet implementation class CargoServlet
 */
@WebServlet("/CargoServlet")
public class CargoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CargoServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listCargo(request, response);
    	} else if (type.equals("register")) {
    		String codCargo = request.getParameter("codCargo");
    		if(codCargo.isEmpty()) {
    			//registerCargo(request, response);
    		} else {
    			///editCargo(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getCargo(request, response);
    	} else if (type.equals("delete")) {
    		//deleteCargo(request, response);
    	} 
    }
    
    
    protected void listCargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	CargoInterface dao = daoFactory.getCargo();
    	
    	List<Cargo> data = dao.getListCargo();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("cargo.jsp").forward(request, response);
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
