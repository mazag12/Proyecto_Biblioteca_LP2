package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.Provincia;
import dao.DAOFactory;

import interfaces.ProvinciaInterface;

/**
 * Servlet implementation class ProvinciaServlet
 */
@WebServlet("/ProvinciaServlet")
public class ProvinciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProvinciaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listProvincia(request, response);
    	} else if (type.equals("register")) {
    		String codprovincia = request.getParameter("codprovincia");
    		if(codprovincia.isEmpty()) {
    			registerProvincia(request, response);
    		} else {
    			///editAutor(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getSubject(request, response);
    	} else if (type.equals("delete")) {
    		//deleteAutor(request, response);
    	} 
    }
    
    
    protected void listProvincia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	ProvinciaInterface dao = daoFactory.getProvincia();
    	    	
    	List<Provincia> data = dao.getListProvincia();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Pais.jsp").forward(request, response);
    }
    
    protected void registerProvincia(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
       String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);  
    	ProvinciaInterface dao = daoFactory.getProvincia();
    
        Provincia provincia = dao.Provincia(name);
    
    
   
    	if(provincia.getCodprovincia() == "SNDATA") {
    		
    		Provincia pa = new Provincia(name, name, name, name);
    	    
    		pa.setCodprovincia("sin codigo");
    		pa.setNomprovincia(name);
           
       
    		int value = dao.createProvincia(pa);
    	
    		
    		if (value == 1) {
    			listProvincia(request, response);
        	} else {
        		//request.setAttribute("message", "Ocurrio un problema");
        		listProvincia(request, response);
        	}
    		
    	}else{
    		//request.setAttribute("message", "Ocurrio un problema");
    		listProvincia(request, response);
    	}
    
    	
    }
    
    
    protected void getProvincia(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codProvincia = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	ProvinciaInterface dao = daoFactory.getProvincia();
    	
    	Provincia provincia = dao.Provincia(codProvincia);
        List<Provincia> listProvincia = dao.getListProvincia();
      
     
    	request.setAttribute("provinciaData", provincia);
    	request.setAttribute("data", listProvincia);
    	request.getRequestDispatcher("Pais.jsp").forward(request, response);
    }
    
    protected void editProvincia(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("txtcodigoprovincia");
    	String name = request.getParameter("txtnameprovincia");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	ProvinciaInterface dao = daoFactory.getProvincia();
    	
    	Provincia provincia = dao.Provincia(codigo);
    
    	
    	if(provincia.getCodprovincia() == "SNDATA") {
       		Provincia pr = new Provincia(name, name, codigo, name);
       		pr.setCodprovincia(codigo);
       		pr.setNomprovincia(name);
    	    
    		
    		
	    	int flagResponde = dao.editProvincia(pr); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listProvincia(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listProvincia(request, response);
	    	}
    	}else if(provincia.getCodprovincia() ==  codigo){
    		Provincia pr = new Provincia(name, name, codigo, name);
    		pr.setCodprovincia(codigo);
       		pr.setNomprovincia(name);
    		
	    	int flagResponde = dao.editProvincia(pr); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listProvincia(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listProvincia(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
	    	listProvincia(request, response);
	    }
    	
    }
    
    protected void deleteProvincia(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	ProvinciaInterface dao = daoFactory.getProvincia();
    	
    	int flagResponse = dao.removeProvincia(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listProvincia(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listProvincia(request, response);
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
