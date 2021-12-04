package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Autor;
import beans.Empleado;
import dao.DAOFactory;
import interfaces.AutorInterface;
import interfaces.EmpleadoInterface;

/**
 * Servlet implementation class EmpleadoServlet
 */
@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listEmpleado(request, response);
    	} else if (type.equals("register")) {
    		String CodigoEmple = request.getParameter("CodigoEmple");
    		if(CodigoEmple.isEmpty()) {
    			//registerEmpelado(request, response);
    		} else {
    			///editEmpleado(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getEmpleado(request, response);
    	} else if (type.equals("delete")) {
    		//deleteEmpleado(request, response);
    	} 
    }
    
    protected void listEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	EmpleadoInterface dao = daoFactory.getEmpleado();
    	
    	List<Empleado> data = dao.getListEmpleado();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Empleado.jsp").forward(request, response);
    }
    
    protected void registerAutor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	EmpleadoInterface dao = daoFactory.getEmpleado();
    	Empleado emp = dao.getEmpleado(name); 
    	
    	if(emp.getCodigoemple() == "SNDATA") {
    		
    		Empleado au = new Empleado();
        	au.setCodigoemple("Sin ID");
        	au.setCodperson(name);
        	au.setCodcargo("Sin ID");
    		
    		int value = dao.createEmpleado(au);
    		
    		if (value == 1) {
        		listEmpleado(request, response);
        	} else {
        		//request.setAttribute("message", "Ocurrio un problema");
        		listEmpleado(request, response);
        	}
    		
    	}else{
    		//request.setAttribute("message", "Ocurrio un problema");
    		listEmpleado(request, response);
    	}
    	
    }
    
    protected void getEmpleado(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codEmp = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	EmpleadoInterface dao = daoFactory.getEmpleado();
    
    	
    	Empleado emp = dao.getEmpleado(codEmp); 
    	List<Empleado> listUsuario = dao.getListEmpleado(); 
    	request.setAttribute("usuarioData", emp);
    	request.setAttribute("data", listUsuario);
    	request.getRequestDispatcher("Empleado.jsp").forward(request, response);
    }
    
    protected void editEmpleado(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codemp = request.getParameter("txtcodigoempleado");
    	String codp = request.getParameter("txtcodigoperson");
    	String codc = request.getParameter("txtcodcargo");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	EmpleadoInterface dao = daoFactory.getEmpleado();
    	Empleado emp = dao.getEmpleado(codp); 
    	    	
    	if(emp.getCodigoemple() == "SNDATA") {
    		Empleado au = new Empleado();
        	au.setCodigoemple("Sin ID");
        	au.setCodperson(codp);
        	au.setCodcargo("Sin ID");
    		
	    	int flagResponde = dao.editEmpleado(au); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listEmpleado(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listEmpleado(request, response);
	    	}
    	}else if(emp.getCodigoemple() ==  codemp){
    		Empleado au = new Empleado();
        	au.setCodigoemple("Sin ID");
        	au.setCodperson(codp);
        	au.setCodcargo("Sin ID");
    		
	    	int flagResponde = dao.editEmpleado(au); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listEmpleado(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listEmpleado(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
	    	listEmpleado(request, response);
	    }
    	
    }
    
    protected void deleteEmpleado(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	EmpleadoInterface dao = daoFactory.getEmpleado();
    	
    	
    	int flagResponse = dao.removeEmpleado(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listEmpleado(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listEmpleado(request, response);
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
