package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Editorial;
import dao.DAOFactory;
import interfaces.EditorialInterface;

/**
 * Servlet implementation class EditorialServlet
 */
@WebServlet("/EditorialServlet")
public class EditorialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditorialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listEditorial(request, response);
    	} else if (type.equals("register")) {
    		String codprovincia = request.getParameter("codprovincia");
    		if(codprovincia.isEmpty()) {
    			registerEditorial(request, response);
    		} else {
    			///editAutor(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getSubject(request, response);
    	} else if (type.equals("delete")) {
    		//deleteAutor(request, response);
    	} 
    }
    
    
    protected void listEditorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	EditorialInterface dao = daoFactory.getEditorial();
    	    	
    	List<Editorial> data = dao.getListEditorial();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Editorial.jsp").forward(request, response);
    }
    
    protected void registerEditorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    
    	
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
