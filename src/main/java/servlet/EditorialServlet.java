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
    		registerEditorial(request, response);
    	} else if (type.equals("edit")) {
    		editarEditorial(request, response);
    	} else if (type.equals("delete")) {
    		eliminarEditorial(request, response);
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
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	EditorialInterface dao = daoFactory.getEditorial();
    	Editorial editorial = dao.Editorial(name); 
    	
    	if(editorial.getCodEditorial() == "SNDATA") {
    		
    		Editorial ed = new Editorial("SIN CODIGO",name);
    		
    		int value = dao.createEditorial(ed);
    		
    		if (value == 1) {
    			listEditorial(request, response);
        	} else {
        		//request.setAttribute("message", "Ocurrio un problema");
        		listEditorial(request, response);
        	}
    		
    	}else{
    		//request.setAttribute("message", "Ocurrio un problema");
    		listEditorial(request, response);
    	}
    }
    
    protected void editarEditorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String codigo = request.getParameter("txtcodigo");
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	EditorialInterface dao = daoFactory.getEditorial();
    	Editorial editorial = dao.Editorial(name);
    	    	
    	if(editorial.getCodEditorial() == "SNDATA") {
    		Editorial ed = new Editorial(codigo,name);
    		
	    	int flagResponde = dao.editEditorial(ed); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listEditorial(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listEditorial(request, response);
	    	}
    	}else if(editorial.getCodEditorial() ==  codigo){
    		Editorial fo = new Editorial(codigo,name);
    		
	    	int flagResponde = dao.editEditorial(fo); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listEditorial(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listEditorial(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
	    	listEditorial(request, response);
	    }
    }
    
    protected void eliminarEditorial(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	EditorialInterface dao = daoFactory.getEditorial();
    	
    	int flagResponse = dao.removeEditorial(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listEditorial(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listEditorial(request, response);
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
