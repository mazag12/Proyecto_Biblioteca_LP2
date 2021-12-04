package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import beans.Libro;
import beans.Trabajo;
import dao.DAOFactory;
import interfaces.AutorInterface;
import interfaces.ClienteInterface;
import interfaces.LibroInterface;
import interfaces.TrabajoInterface;

/**
 * Servlet implementation class TrabajoServlet
 */
@WebServlet("/TrabajoServlet")
public class TrabajoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TrabajoServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listTrabajo(request, response);
    	} else if (type.equals("register")) {
    		String codTrabajo = request.getParameter("codTrabajo");
    		if(codTrabajo.isEmpty()) {
    			//registerTrabajo(request, response);
    		} else {
    			///editTrabajo(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getTrabajo(request, response);
    	} else if (type.equals("delete")) {
    		//deleteTrabajo(request, response);
    	} 
    }
    
    protected void listTrabajo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	TrabajoInterface dao = daoFactory.getTrabajo();
    	
    	List<Trabajo> data = dao.getListTrabajo();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Trabajo.jsp").forward(request, response);
    }
    
    protected void registerTrabajo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String name = request.getParameter("txtnombre");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	TrabajoInterface dao = daoFactory.getTrabajo();
    	Trabajo job = dao.getTrabajo(name);
    	
    	if(job.getCodtrabajo() == "No hay datos") {
    		 Trabajo j = new Trabajo();
    		 j.setCodtrabajo("Sin ID");
    		 j.setNombre(name);
    		 j.setOcupacion("Sin Datos");
    		 j.setTelefono("Sin telefono");
    		
    		 
    		 int value = dao.createTrabajo(j);
    		 if(value == 1) {
    			 listTrabajo(request, response);
    			 
    		 }else {
    			 listTrabajo(request, response);
			}
    		 
 
    	} else {
    		// error 
    		listTrabajo(request, response);
    	}
    }
    
    protected void getTrabajo(HttpServletRequest request, HttpServletResponse response)  
    		throws ServletException, IOException  {
    	
    	String codJob = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	TrabajoInterface dao = daoFactory.getTrabajo();
    	
    	Trabajo job = dao.getTrabajo(codJob);
    	List<Trabajo > listTrabajo = dao.getListTrabajo();
    	request.setAttribute("usuarioData", job);
    	request.setAttribute("data", listTrabajo);
    	request.getRequestDispatcher("Trabajo.jsp").forward(request, response);
    	
    }
    
    protected void editTrabajo(HttpServletRequest request, HttpServletResponse response)  
    		throws ServletException, IOException {
    	
    	String codT = request.getParameter("txtcodigoTrabajo");
    	String nam = request.getParameter("txtnombre");
    	String ocu = request.getParameter("txtocupacion");
    	String tlf = request.getParameter("txttelefono");
    
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	TrabajoInterface dao = daoFactory.getTrabajo();
    	Trabajo job = dao.getTrabajo(nam);
    	
    	if(job.getCodtrabajo() == "No hay datos") {
    		Trabajo c = new Trabajo();
    		c.setCodtrabajo(codT);
    		c.setNombre(nam);
    		c.setOcupacion(ocu);
    		c.setTelefono(tlf);

    		
    		int flagResponde = dao.editTrabajo(c);
    		if (flagResponde ==1) {
				listTrabajo(request, response);
				
			}else {
				listTrabajo(request, response);
			}	
    	}else if (job.getCodtrabajo() == codT) {
    		
    		Trabajo c = new Trabajo();
    		c.setCodtrabajo(codT);
    		c.setNombre(nam);
    		c.setOcupacion(ocu);
    		c.setTelefono(tlf);
    		
    		int flagResponde = dao.editTrabajo(c);
    		
    		if (flagResponde == 1) {
    			listTrabajo(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listTrabajo(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
	    	listTrabajo(request, response);
			
		}
	
    	
    }
    
    protected void deleteAutor(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	TrabajoInterface dao = daoFactory.getTrabajo();
    	
    	int flagResponse = dao.removeTrabajo(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listTrabajo(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listTrabajo(request, response);
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
