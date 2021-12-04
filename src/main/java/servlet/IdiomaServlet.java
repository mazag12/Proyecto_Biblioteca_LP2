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
    		editarIdioma(request, response);
    	} else if (type.equals("delete")) {
    		eliminarIdioma(request, response);
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
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	IdiomaInterface dao = daoFactory.getIdioma();
    	Idioma editorial = dao.getIdioma(name); 
    	
    	if(editorial.getCodIdioma() == "SNDATA") {
    		
    		Idioma idio = new Idioma();
    		idio.setCodIdioma("SIN CODIGO");
    		idio.setNomIdioma(name);
    		
    		int value = dao.createIdioma(idio);
    		
    		if (value == 1) {
    			listIdioma(request, response);
        	} else {
        		//request.setAttribute("message", "Ocurrio un problema");
        		listIdioma(request, response);
        	}
    		
    	}else{
    		//request.setAttribute("message", "Ocurrio un problema");
    		listIdioma(request, response);
    	}
    }
    
    protected void editarIdioma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String codigo = request.getParameter("txtcodigo");
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	IdiomaInterface dao = daoFactory.getIdioma();
    	Idioma editorial = dao.getIdioma(name);
    	    	
    	if(editorial.getCodIdioma() == "SNDATA") {
    		Idioma idio = new Idioma();
    		idio.setCodIdioma(codigo);
    		idio.setNomIdioma(name);
	    	int flagResponde = dao.editIdioma(idio); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listIdioma(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listIdioma(request, response);
	    	}
    	}else if(editorial.getCodIdioma() ==  codigo){
    		Idioma idio = new Idioma();
    		idio.setCodIdioma(codigo);
    		idio.setNomIdioma(name);
    		
	    	int flagResponde = dao.editIdioma(idio); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listIdioma(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listIdioma(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
	    	listIdioma(request, response);
	    }
    }
    
    protected void eliminarIdioma(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	IdiomaInterface dao = daoFactory.getIdioma();
    	
    	int flagResponse = dao.removeIdioma(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listIdioma(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listIdioma(request, response);
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
