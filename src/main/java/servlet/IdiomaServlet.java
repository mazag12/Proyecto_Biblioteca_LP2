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
    		registerIdioma(request, response);
    		
    	} else if (type.equals("edit")) {
    		editIdioma(request, response);
    	} else if (type.equals("delete")) {
    		deleteIdioma(request, response);
    	} 
    }
    
	protected void editIdioma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	String codigo = request.getParameter("txtCodigoA");
    	String nombre = request.getParameter("txtNombreA");
   	
    
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	IdiomaInterfaceDAO dao = daoFactory.getIdioma();
    	

    		Idioma idio = new Idioma();
    		idio.setCodIdioma(codigo);
    		idio.setNomIdioma(nombre);

    		    		
    		int value = dao.editIdioma(idio);
    		
    		if (value == 1) {
        		listIdioma(request, response);
        	} else {
        		//error
        	}
    	
    }
    
	 protected void registerIdioma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	String nombre = request.getParameter("txtNombre");
  
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	IdiomaInterfaceDAO dao = daoFactory.getIdioma();
    	

    		Idioma idio = new Idioma();
    		idio.setNomIdioma(nombre);

    		int value = dao.createIdioma(idio);
    		
    		if (value == 1) {
        		listIdioma(request, response);
        	} else {
        		//error
        	}
    		
    	
    }

	
  protected void listIdioma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	IdiomaInterfaceDAO dao = daoFactory.getIdioma();    	
    	List<Idioma> data = dao.getListIdiomas();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Idioma.jsp").forward(request, response);
    }
    
  	 protected void deleteIdioma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String idIdioma = request.getParameter("id");

    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	IdiomaInterfaceDAO dao = daoFactory.getIdioma();
    	
    	int flagResponse = dao.removeEstudios(idIdioma); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listIdioma(request, response);
    	} else {
    		request.setAttribute("message", "Ocurrio un problema");
    		request.getRequestDispatcher("Idioma.jsp").forward(request, response);
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
