package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Formato;
import dao.DAOFactory;
import interfaces.FormatoInterface;
/**
 * Servlet implementation class FormatoServlet
 */
@WebServlet("/FormatoServlet")
public class FormatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormatoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listFormato(request, response);
    	} else if (type.equals("register")) {
    		registerFormato(request, response);
    	} else if (type.equals("edit")) {
    		editarFormato(request, response);
    	} else if (type.equals("delete")) {
    		eliminarFormato(request, response);
    	} 
    }
    
    
    protected void listFormato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	FormatoInterface dao = daoFactory.getFormato();
  
    	List<Formato> data = dao.getListFormato();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Formato.jsp").forward(request, response);
    }
    
    protected void registerFormato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	FormatoInterface dao = daoFactory.getFormato();
    	Formato formato = dao.Formato(name); 
    	
    	if(formato.getCodformato() == "SNDATA") {
    		
    		Formato fo = new Formato();
    		fo.setCodformato("SIN CODIGO");
    		fo.setNomformato(name);
    		
    		int value = dao.createFormato(fo);
    		
    		if (value == 1) {
    			listFormato(request, response);
        	} else {
        		//request.setAttribute("message", "Ocurrio un problema");
        		listFormato(request, response);
        	}
    		
    	}else{
    		//request.setAttribute("message", "Ocurrio un problema");
    		listFormato(request, response);
    	}
    }
    
    protected void editarFormato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String codigo = request.getParameter("txtcodigo");
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	FormatoInterface dao = daoFactory.getFormato();
    	Formato autor = dao.Formato(name);
    	    	
    	if(autor.getCodformato() == "SNDATA") {
    		Formato fo = new Formato();
    		fo.setCodformato(codigo);
    		fo.setNomformato(name);
    		
	    	int flagResponde = dao.editFomato(fo); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listFormato(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listFormato(request, response);
	    	}
    	}else if(autor.getCodformato() ==  codigo){
    		Formato fo = new Formato();
    		fo.setCodformato(codigo);
    		fo.setNomformato(name);
    		
	    	int flagResponde = dao.editFomato(fo); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listFormato(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listFormato(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
	    	listFormato(request, response);
	    }
    }
    
    protected void eliminarFormato(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	FormatoInterface dao = daoFactory.getFormato();
    	
    	int flagResponse = dao.removeFormato(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listFormato(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listFormato(request, response);
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
