package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.Pais;
import dao.DAOFactory;

import interfaces.PaisInterface;

/**
 * Servlet implementation class PaisServlet
 */
@WebServlet("/PaisServlet")
public class PaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listPais(request, response);
    	} else if (type.equals("register")) {
    			registerPais(request, response);
    	} else if (type.equals("edit")) {
    		//getSubject(request, response);
    	} else if (type.equals("delete")) {
    		//deleteAutor(request, response);
    	}
    }
    
    
    protected void listPais(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	PaisInterface dao = daoFactory.getPais();
    	    	
    	List<Pais> data = dao.getListPais();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Pais.jsp").forward(request, response);
    }
    
    protected void registerPais(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);  
    	PaisInterface dao = daoFactory.getPais();
    
    	Pais pais = dao.Pais(name);
    
    	if(pais.getCodpais() == "sndata") {
    		
    		Pais pa = new Pais("sin codigo","sin codigo","sin codigo","sin codigo","sin codigo","sin codigo","sin codigo",name);
       
    		int value = dao.createPais(pa);
        		
    		if (value == 1) {
    			listPais(request, response);
        	} else {
        		//request.setAttribute("message", "Ocurrio un problema");
        		listPais(request, response);
        	}
    		
    	}else{
    		//request.setAttribute("message", "Ocurrio un problema");
    		listPais(request, response);
    	}
    
    	
    }
    
    
    protected void getPais(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codPais = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    
    	PaisInterface dao = daoFactory.getPais();
        
    	Pais pais = dao.Pais(codPais);
    	List<Pais> listPais = dao.getListPais();
   
     
    	request.setAttribute("paisData", pais);
    	request.setAttribute("data", listPais);
    	request.getRequestDispatcher("Pais.jsp").forward(request, response);
    }
    
    protected void editPais(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("txtcodigopais");
    	String name = request.getParameter("txtnamepais");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	PaisInterface dao = daoFactory.getPais();
    	
    	Pais pais = dao.Pais(codigo);
    	
    	if(pais.getCodpais() == "sndata") {
    		Pais pa = new Pais("sin codigo","sin codigo","sin codigo","sin codigo","sin codigo","sin codigo",codigo,name);
       	       
	    	int flagResponde = dao.editPais(pa); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listPais(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listPais(request, response);
	    	}
    	}else if(pais.getCodpais() ==  codigo){
    		Pais pa = new Pais("sin codigo","sin codigo","sin codigo","sin codigo","sin codigo","sin codigo",codigo,name);
    		
	    	int flagResponde = dao.editPais(pa); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listPais(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listPais(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
	    	listPais(request, response);
	    }
    	
    }
    
    protected void deletePais(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	PaisInterface dao = daoFactory.getPais();

    	
    	int flagResponse = dao.removePais(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listPais(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listPais(request, response);
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
