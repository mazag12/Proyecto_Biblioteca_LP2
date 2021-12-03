package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAOFactory;
import beans.Estudios;
import interfaces.EstudiosInterfaceDAO;


/**
 * Servlet implementation class EstudiosServlet
 */
@WebServlet("/EstudiosServlet")
public class EstudiosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EstudiosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  
    
	String type = request.getParameter("type");
    	if (type.equals("lista")) {
    		listEstudios(request, response);
    	} else if (type.equals("register")) {
    		
    		registerEstudios(request, response);
 
    	} else if (type.equals("edit")) {
    		editEstudios(request, response);
    	} else if (type.equals("delete")) {
    		deleteSubject(request, response);
    	} 

    	    	
    	
    }
	
    protected void editEstudios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	String codigo = request.getParameter("txtCodEsA");
    	String nombre = request.getParameter("txtNombreA");
    	String carrera = request.getParameter("txtCarreraA");
    	String telefono = request.getParameter("txtTelefonoA");
    	String celular = request.getParameter("txtCelularA");
    	String direccion = request.getParameter("txtDireccionA");
    	String codpais = request.getParameter("txtCodPaisA");
    	
    
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	EstudiosInterfaceDAO dao = daoFactory.getEstudios();
    	
    	if(telefono == "") {
    		telefono = "0";
    	}
    	if(celular == "") {
    		celular="0";
    	}
    	if(direccion=="") {
    		direccion="SN";
    	}
    	int tele = Integer.parseInt(telefono);
    	int celu = Integer.parseInt(celular);
    	
    		Estudios estudio = new Estudios();
    		estudio.setCodEstudiante(codigo);
    		estudio.setNomEstudio(nombre);
    		estudio.setCarrera(carrera);
    		estudio.setTelefono(tele);
    		estudio.setCelular(celu);
    		estudio.setDireccion(direccion);
    		estudio.setCodPais(codpais);
    		    		
    		int value = dao.editEstudios(estudio);
    		
    		if (value == 1) {
        		listEstudios(request, response);
        	} else {
        		//error
        	}
    	
    }
    
    protected void registerEstudios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	String nombre = request.getParameter("txtNombre");
    	String carrera = request.getParameter("txtCarrera");
    	String telefono = request.getParameter("txtTelefono");
    	String celular = request.getParameter("txtCelular");
    	String direccion = request.getParameter("txtDireccion");
    	String codpais = request.getParameter("txtCodPais");
    	
    
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	EstudiosInterfaceDAO dao = daoFactory.getEstudios();
    	
    	if(telefono == "") {
    		telefono = "0";
    	}
    	if(celular == "") {
    		celular="0";
    	}
    	if(direccion=="") {
    		direccion="SN";
    	}
    	int tele = Integer.parseInt(telefono);
    	int celu = Integer.parseInt(celular);
    	
    		Estudios estudio = new Estudios();
    		estudio.setNomEstudio(nombre);
    		estudio.setCarrera(carrera);
    		estudio.setTelefono(tele);
    		estudio.setCelular(celu);
    		estudio.setDireccion(direccion);
    		estudio.setCodPais(codpais);
    		    		
    		int value = dao.createEstudios(estudio);
    		
    		if (value == 1) {
        		listEstudios(request, response);
        	} else {
        		//error
        	}
    		
    	
    }	
    protected void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String idEstudio = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	EstudiosInterfaceDAO dao = daoFactory.getEstudios();
    	
    	int flagResponse = dao.removeEstudios(idEstudio); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listEstudios(request, response);
    	} else {
    		request.setAttribute("message", "Ocurrio un problema");
    		request.getRequestDispatcher("estudios.jsp").forward(request, response);
    	}
		
	}
	
    protected void listEstudios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	
    	// List<Subject> data = subjectModel.getListSubject();
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	EstudiosInterfaceDAO dao = daoFactory.getEstudios();
    	List<Estudios> data = dao.getListEstudios();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("estudios.jsp").forward(request, response);
    	
    }
    
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

