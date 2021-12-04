package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Tematica;
import dao.DAOFactory;
import interfaces.TematicaInterface;

/**
 * Servlet implementation class TematicaServlet
 */
@WebServlet("/TematicaServlet")
public class TematicaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TematicaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listTematica(request, response);
    	} else if (type.equals("register")) {
    		String codprovincia = request.getParameter("codprovincia");
    		if(codprovincia.isEmpty()) {
    			registerTematica(request, response);
    		} else {
    			///editAutor(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getSubject(request, response);
    	} else if (type.equals("delete")) {
    		//deleteAutor(request, response);
    	} 
    }
    
    
    protected void listTematica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	TematicaInterface dao = daoFactory.getTematica();
    	    	
    	List<Tematica> data = dao.getListTematica();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Tematica.jsp").forward(request, response);
    }
    
    protected void registerTematica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	TematicaInterface dao = daoFactory.getTematica();
    	Tematica editorial = dao.Tematica(name); 
    	
    	if(editorial.getCodTematica() == "SNDATA") {
    		
    		Tematica te = new Tematica("SIN CODIGO",name);
    		
    		int value = dao.createTematica(te);
    		
    		if (value == 1) {
    			listTematica(request, response);
        	} else {
        		//request.setAttribute("message", "Ocurrio un problema");
        		listTematica(request, response);
        	}
    		
    	}else{
    		//request.setAttribute("message", "Ocurrio un problema");
    		listTematica(request, response);
    	}
    }
    
    protected void editarTematica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String codigo = request.getParameter("txtcodigo");
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	TematicaInterface dao = daoFactory.getTematica();
    	Tematica editorial = dao.Tematica(name);
    	    	
    	if(editorial.getCodTematica() == "SNDATA") {
    		Tematica te = new Tematica(codigo,name);
    		
	    	int flagResponde = dao.editTematica(te); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listTematica(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listTematica(request, response);
	    	}
    	}else if(editorial.getCodTematica() ==  codigo){
    		Tematica te = new Tematica(codigo,name);
    		
	    	int flagResponde = dao.editTematica(te); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listTematica(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listTematica(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
	    	listTematica(request, response);
	    }
    }
    
    protected void eliminarTematica(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	TematicaInterface dao = daoFactory.getTematica();
    	
    	int flagResponse = dao.removeTematica(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listTematica(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listTematica(request, response);
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
