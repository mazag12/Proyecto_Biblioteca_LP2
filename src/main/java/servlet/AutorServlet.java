package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Autor;
import dao.DAOFactory;
import interfaces.AutorInterface;
import model.AutorModel;

/**
 * Servlet implementation class AutorServlet
 */
@WebServlet("/AutorServlet")
public class AutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listAutor(request, response);
    	} else if (type.equals("register")) {
    		registerAutor(request, response);
    	} else if (type.equals("edit")){
    		editAutor(request, response);
    	} else if (type.equals("delete")) {
    		deleteAutor(request, response);
    	} 
    }
    
    protected void listAutor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	AutorInterface dao = daoFactory.getAutor();
    	
    	List<Autor> data = dao.getListAutor();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Autor.jsp").forward(request, response);
    }
    
    protected void registerAutor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	AutorInterface dao = daoFactory.getAutor();
    	Autor autor = dao.Autor(name); 
    	
    	if(autor.getCodautor() == "SNDATA") {
    		
    		Autor au = new Autor();
        	au.setCodautor("SIN CODIGO");
        	au.setNomautor(name);
    		
    		int value = dao.createAutor(au);
    		
    		if (value == 1) {
        		listAutor(request, response);
        	} else {
        		request.setAttribute("message", "Ocurrio un problema");
        		listAutor(request, response);
        	}
    		
    	}else {
    		request.setAttribute("message", "Ocurrio un problema");
    		listAutor(request, response);
    	}
    	
    }
    
    protected void getAutor(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codAutor = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	AutorInterface dao = daoFactory.getAutor();
    	
    	Autor autor = dao.Autor(codAutor); 
    	List<Autor> listUsuario = dao.getListAutor(); 
    	request.setAttribute("usuarioData", autor);
    	request.setAttribute("data", listUsuario);
    	request.getRequestDispatcher("usuario.jsp").forward(request, response);
    }
    
    protected void editAutor(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("txtcodigo");
    	String name = request.getParameter("txtName");
    	
    	
    	Autor autor = new Autor();
    	autor.setCodautor(codigo);
    	autor.setNomautor(name);
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	AutorInterface dao = daoFactory.getAutor();
    	    	
    	if(autor.getCodautor() == "SNDATA") {
    	
	    	int flagResponde = dao.editAutor(autor); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listAutor(request, response);
	    	} else {
	    		request.setAttribute("message", "Ocurrio un problema");
	    		request.getRequestDispatcher("Autor.jsp").forward(request, response);
	    	}
    	}else {
    		request.setAttribute("message", "Ocurrio un problema");
    		request.getRequestDispatcher("Autor.jsp").forward(request, response);
	    }
    	
    }
    
    protected void deleteAutor(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	AutorInterface dao = daoFactory.getAutor();
    	
    	int flagResponse = dao.removeAutor(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listAutor(request, response);
    	} else {
    		request.setAttribute("message", "Ocurrio un problema");
    		request.getRequestDispatcher("Autor.jsp").forward(request, response);
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
