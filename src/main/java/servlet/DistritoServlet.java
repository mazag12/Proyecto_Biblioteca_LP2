package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.Distrito;
import dao.DAOFactory;

import interfaces.DistritoInterface;

/**
 * Servlet implementation class DistritoServlet
 */
@WebServlet("/DistritoServlet")
public class DistritoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistritoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listDistrito(request, response);
    	} else if (type.equals("register")) {
    		String coddistrito = request.getParameter("coddistrito");
    		if(coddistrito.isEmpty()) {
    			registerDistrito(request, response);
    		} else {
    			///editAutor(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getSubject(request, response);
    	} else if (type.equals("delete")) {
    		//deleteAutor(request, response);
    	} 
    }
    
    protected void listDistrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	DistritoInterface dao = daoFactory.getDistrito();
    	    	
    	List<Distrito> data = dao.getListDistrito();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Pais.jsp").forward(request, response);
    }
    
    protected void registerDistrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	DistritoInterface dao = daoFactory.getDistrito();
    	
    	Distrito distrito = dao.Distrito(name);
   
    	if(distrito.getCoddistrito() == "SNDATA") {
    		
    		Distrito di = new Distrito(name, name);
            di.setCoddistrito("sin codigo");
            di.setNomdistrito(name);
            di.setCoddistrito(name);
            
    		int value = dao.createDistrito(di);
    	
    		
    		if (value == 1) {
    			listDistrito(request, response);
        	} else {
        		//request.setAttribute("message", "Ocurrio un problema");
        		listDistrito(request, response);
        	}
    		
    	}else{
    		//request.setAttribute("message", "Ocurrio un problema");
    		listDistrito(request, response);
    	}
    
    	
    }
    
    protected void getDistrito(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codDistrito = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	DistritoInterface dao = daoFactory.getDistrito();
    	
    	Distrito distrito = dao.Distrito(codDistrito);
        List<Distrito> listDistrito = dao.getListDistrito();
     
    	request.setAttribute("distritoData", distrito);
    	request.setAttribute("data", listDistrito);
    	request.getRequestDispatcher("Pais.jsp").forward(request, response);
    }
    
    protected void editDistrito(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("txtcodigodistrito");
    	String name = request.getParameter("txtnamedistrito");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	DistritoInterface dao = daoFactory.getDistrito();
    	
    	Distrito distrito = dao.Distrito(codigo);
    	
    	if(distrito.getCoddistrito() == "SNDATA") {
       		Distrito di = new Distrito(codigo, name);
    	    di.setCoddistrito(codigo);
    	    di.setNomdistrito(name);
    	    di.setCoddistrito(name);
    		
    		
	    	int flagResponde = dao.editDistrito(di); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listDistrito(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listDistrito(request, response);
	    	}
    	}else if(distrito.getCoddistrito() ==  codigo){
    		Distrito di = new Distrito(codigo, name);
    	    di.setCoddistrito(codigo);
    	    di.setNomdistrito(name);
    	    di.setCoddistrito(name);
    		
	    	int flagResponde = dao.editDistrito(di); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listDistrito(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listDistrito(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
	    	listDistrito(request, response);
	    }
    	
    }
    
    protected void deleteDistrito(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	DistritoInterface dao = daoFactory.getDistrito();
    	
    	int flagResponse = dao.removeDistrito(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listDistrito(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listDistrito(request, response);
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
