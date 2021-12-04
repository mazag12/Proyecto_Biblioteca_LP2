package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Autor;
import beans.Cargo;
import beans.Libro;
import dao.DAOFactory;
import interfaces.AutorInterface;
import interfaces.CargoInterface;
import interfaces.LibroInterface;

/**
 * Servlet implementation class CargoServlet
 */
@WebServlet("/CargoServlet")
public class CargoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CargoServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listCargo(request, response);
    	} else if (type.equals("register")) {
    		String codCargo = request.getParameter("codCargo");
    		if(codCargo.isEmpty()) {
    			//registerCargo(request, response);
    		} else {
    			///editCargo(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getCargo(request, response);
    	} else if (type.equals("delete")) {
    		//deleteCargo(request, response);
    	} 
    }
    
    
    protected void listCargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	CargoInterface dao = daoFactory.getCargo();
    	
    	List<Cargo> data = dao.getListCargo();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("cargo.jsp").forward(request, response);
    }
    
    protected void registerCargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String name = request.getParameter("txtName");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	CargoInterface dao = daoFactory.getCargo();
    	Cargo car = dao.gerCargo(name); 
    	
    	if(car.getCodcargo() == "SNDATA") {
    		
    		Cargo au = new Cargo();
        	au.setCodcargo("Sin ID");
        	au.setDescripcion(name);
    		
    		int value = dao.createCargo(au);
    		
    		if (value == 1) {
        		listCargo(request, response);
        	} else {
        		//request.setAttribute("message", "Ocurrio un problema");
        		listCargo(request, response);
        	}
    		
    	}else{
    		//request.setAttribute("message", "Ocurrio un problema");
    		listCargo(request, response);
    	}
    	
    }
    
    protected void getCargo(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codCar = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	CargoInterface dao = daoFactory.getCargo();
    	
    	
    	Cargo car = dao.gerCargo(codCar); 
    	List<Cargo> listUsuario = dao.getListCargo(); 
    	request.setAttribute("usuarioData", car);
    	request.setAttribute("data", listUsuario);
    	request.getRequestDispatcher("Cargo.jsp").forward(request, response);
    }
    
    protected void editCargo(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("txtcodigo");
    	String name = request.getParameter("txtDescripcion");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	CargoInterface dao = daoFactory.getCargo();
    	Cargo car = dao.gerCargo(name); 
    	    	
    	if(car.getCodcargo() == "SNDATA") {
       		Cargo au = new Cargo();
    		au.setCodcargo(codigo);
    		au.setDescripcion(name);
    		
	    	int flagResponde = dao.editCargo(au); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listCargo(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listCargo(request, response);
	    	}
    	}else if(car.getCodcargo() ==  codigo){
    		Cargo au = new Cargo();
    		au.setCodcargo(codigo);
    		au.setDescripcion(name);
    		
	    	int flagResponde = dao.editCargo(au); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listCargo(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listCargo(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
	    	listCargo(request, response);
	    }
    	
    }
    
    protected void deleteCargo(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	CargoInterface dao = daoFactory.getCargo();
    	
    	
    	int flagResponse = dao.removeCargo(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listCargo(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listCargo(request, response);
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
