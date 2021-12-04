package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Departamento;
import beans.Provincia;
import dao.DAOFactory;
import interfaces.DepartamentoInterface;
import interfaces.ProvinciaInterface;

/**
 * Servlet implementation class DepartamentoServlet
 */
@WebServlet("/DepartamentoServlet")
public class DepartamentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartamentoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listDepartamento(request, response);
    	} else if (type.equals("register")) {
    		String coddepartamento = request.getParameter("coddepartamento");
    		if(coddepartamento.isEmpty()) {
    			registerDepartamento(request, response);
    		} else {
    			///editAutor(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getSubject(request, response);
    	} else if (type.equals("delete")) {
    		//deleteAutor(request, response);
    	} 
    }

    
    
    protected void listDepartamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	DepartamentoInterface dao = daoFactory.getDepartamento();
    	    	
    	List<Departamento> data = dao.getListDepartamento();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Pais.jsp").forward(request, response);
    }
    
    protected void registerDepartamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	 String name = request.getParameter("txtName");
     	
     	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);  
     	DepartamentoInterface dao = daoFactory.getDepartamento();
    
         Departamento departamento = dao.Departamento(name);

     
     
    
     	if(departamento.getCoddepartamento() == "SNDATA") {
     		
     		Departamento de = new Departamento(name, name, name, name, name, name);
     		
     	    de.setCoddepartamento("sin codigo");
     	    de.setNomdepartamento(name);
     	
            
        
     		int value = dao.createDepartamento(de);
     	
     		
     		if (value == 1) {
     			listDepartamento(request, response);
         	} else {
         		//request.setAttribute("message", "Ocurrio un problema");
         		listDepartamento(request, response);
         	}
     		
     	}else{
     		//request.setAttribute("message", "Ocurrio un problema");
     		listDepartamento(request, response);
     	}
    	
    }
    
    protected void getDepartamento(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codDepartamento = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	DepartamentoInterface dao = daoFactory.getDepartamento();
    	
    	Departamento departamento = dao.Departamento(codDepartamento);
    	List<Departamento> listDepartamento = dao.getListDepartamento();
      
      
    	request.setAttribute("departamentoData", departamento);
    	request.setAttribute("data", listDepartamento);
    	request.getRequestDispatcher("Pais.jsp").forward(request, response);
    }
    
    protected void editDepartamento(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("txtcodigoprovincia");
    	String name = request.getParameter("txtnameprovincia");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	DepartamentoInterface dao = daoFactory.getDepartamento();
    	
    	Departamento departamento = dao.Departamento(codigo);
    
    	
    	if(departamento.getCoddepartamento() == "SNDATA") {
    		Departamento de = new Departamento(name, name, name, codigo, name, name);
       		de.setCoddepartamento(codigo);
       		de.setNomdepartamento(name);
       	
    	    
    		
    		
	    	int flagResponde = dao.editDepartamento(de); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listDepartamento(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listDepartamento(request, response);
	    	}
    	}else if(departamento.getCoddepartamento() ==  codigo){
    		Departamento de = new Departamento(name, name, name, codigo, name, name);
       		de.setCoddepartamento(codigo);
       		de.setNomdepartamento(name);
    		
	    	int flagResponde = dao.editDepartamento(de); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listDepartamento(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listDepartamento(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
	    	listDepartamento(request, response);
	    }
    	
    }
    
    protected void deleteDepartamento(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	DepartamentoInterface dao = daoFactory.getDepartamento();
    	
    	int flagResponse = dao.removeDepartamento(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listDepartamento(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listDepartamento(request, response);
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
