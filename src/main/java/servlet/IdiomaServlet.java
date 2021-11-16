package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Idioma;
import dao.DAOFactory;
import interfaces.IdiomaInterface;

/**
 * Servlet implementation class IdiomaServlet
 */
@WebServlet("/IdiomaServlet")
public class IdiomaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdiomaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listIdioma(request, response);
    	} else if (type.equals("register")) {
    		String codprovincia = request.getParameter("codprovincia");
    		if(codprovincia.isEmpty()) {
    			registerIdioma(request, response);
    		} else {
    			///editAutor(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getSubject(request, response);
    	} else if (type.equals("delete")) {
    		//deleteAutor(request, response);
    	} 
    }
    
    
    protected void listIdioma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	IdiomaInterface dao = daoFactory.getIdioma();
    	    	
    	List<Idioma> data = dao.getListIdioma();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Idioma.jsp").forward(request, response);
    }
    
    protected void registerIdioma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
