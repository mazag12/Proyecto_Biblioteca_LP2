package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Persona;
import dao.DAOFactory;
import interfaces.PersonaInterfaceDAO;

/**
 * Servlet implementation class PersonaServlet
 */
@WebServlet("/PersonaServlet")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	  
    	String type = request.getParameter("type");
    	if (type.equals("lista")) {
    		listPersona(request, response);
    	} else if (type.equals("register")) {
    		
    		registerPersona(request, response);
 
    	} else if (type.equals("edit")) {
    		editPersona(request, response);
    	} else if (type.equals("delete")) {
    		deletePersona(request, response);
    	} 	    	
    	
    }
    
    protected void editPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	String codigo = request.getParameter("txtCodA");
    	String nombre = request.getParameter("txtNombreA");
    	String Paterno = request.getParameter("txtPaternoA");
    	String Materno = request.getParameter("txtMaternoA");
    	String Tipo = request.getParameter("txtTipoA");
    	String nume = request.getParameter("txtNumA");
    	String telefono = request.getParameter("txtTelefonoA");
    	String celular = request.getParameter("txtCelularA");
    	String correo = request.getParameter("txtCorreoA");
    	String direccion = request.getParameter("txtDireccionA");
    	String sexo = request.getParameter("txtSexoA");
    	String nacio = request.getParameter("txtNacionalidadA");
    	String estado = request.getParameter("txtEstadoA");
    	
    	
    
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	PersonaInterfaceDAO dao = daoFactory.getPersona();
    	
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
    	
    		Persona persona = new Persona();
    		persona.setCodPersona(codigo);
    		persona.setNombre(nombre);
    		persona.setApePaterno(Paterno);
    		persona.setApeMaterno(Materno);
    		persona.setTipoDoc(Tipo);
    		persona.setNumDoc(nume);
    		persona.setTelefono(tele);
    		persona.setCelular(celu);
    		persona.setCorreo(correo);
    		persona.setDireccion(direccion);
    		persona.setSexo(sexo);
    		persona.setNacionalidad(nacio);
    		persona.setEstadoCivil(estado);
    		
    	
    		    		
    		int value = dao.editPersona(persona);
    		
    		if (value == 1) {
        		listPersona(request, response);
        	} else {
        		//error
        	}
    	
    }
    
    
    protected void registerPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
   
    	String nombre = request.getParameter("txtNombre");
    	String Paterno = request.getParameter("txtPaterno");
    	String Materno = request.getParameter("txtMaterno");
    	String Tipo = request.getParameter("txtTipo");
    	String nume = request.getParameter("txtNum");
    	String telefono = request.getParameter("txtTelefono");
    	String celular = request.getParameter("txtCelular");
    	String correo = request.getParameter("txtCorreo");
    	String direccion = request.getParameter("txtDireccion");
    	String sexo = request.getParameter("txtSexo");
    	String nacio = request.getParameter("txtNacionalidad");
    	String estado = request.getParameter("txtEstado");
    	
    
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	PersonaInterfaceDAO dao = daoFactory.getPersona();
    	
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
    	
    		Persona persona = new Persona();
    		persona.setNombre(nombre);
    		persona.setApePaterno(Paterno);
    		persona.setApeMaterno(Materno);
    		persona.setTipoDoc(Tipo);
    		persona.setNumDoc(nume);
    		persona.setTelefono(tele);
    		persona.setCelular(celu);
    		persona.setCorreo(correo);
    		persona.setDireccion(direccion);
    		persona.setSexo(sexo);
    		persona.setNacionalidad(nacio);
    		persona.setEstadoCivil(estado);
    		    		
    		int value = dao.createPersona(persona);
    		
    		if (value == 1) {
        		listPersona(request, response);
        	} else {
        		//error
        	}    	
    }
    
	protected void listPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	
    	// List<Subject> data = subjectModel.getListSubject();
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	PersonaInterfaceDAO dao = daoFactory.getPersona();
    	List<Persona> data = dao.getListPersona();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Persona.jsp").forward(request, response);
    	
    }
	
	protected void deletePersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		String idPersona = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	PersonaInterfaceDAO dao = daoFactory.getPersona();
    	
    	int flagResponse = dao.removePersona(idPersona); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listPersona(request, response);
    	} else {
    		request.setAttribute("message", "Ocurrio un problema");
    		request.getRequestDispatcher("Persona.jsp").forward(request, response);
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
